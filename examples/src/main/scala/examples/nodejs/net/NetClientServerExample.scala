package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.net._
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * net.Client / net.Server Example
  * @author lawrence.daniels@gmail.com
  */
class NetClientServerExample(bootstrap: Bootstrap) {

  import bootstrap._

  val net = require[Net]("net")

  /**
    * In the node.js intro tutorial (http://nodejs.org/), they show a basic tcp
    * server, but for some reason omit a client connecting to it.  I added an
    * example at the bottom.
    * Save the following server in example.js:
    */

  val server = net.createServer((socket: Socket) => {
    socket.write("Echo server\r\n")
    socket.pipe(socket)
  })

  server.listen(1337, "127.0.0.1")

  /**
    * And connect with a tcp client from the command line using netcat, the *nix
    * utility for reading and writing across tcp/udp network connections.  I"ve only
    * used it for debugging myself.
    * $ netcat 127.0.0.1 1337
    * You should see:
    * > Echo server
    */

  /* Or use this example tcp client written in node.js.  (Originated with 
   example code from 
   http://www.hacksparrow.com/tcp-socket-programming-in-node-js.html.) */

  val client = net.Socket()

  // open the connection (using the Scala-enhanced version)
  openConnectionFuture()

  client.onData { data =>
    console.log("Received: " + data)
    client.destroy() // kill client after server"s response
  }

  client.onClose { hadError =>
    console.log("Connection closed: state =>", hadError)
  }

  def openConnectionFuture() = client.connectFuture(1337, "127.0.0.1") foreach { _ =>
    console.log("Connected")
    client.write("Hello, server! Love, Client.")
  }

  def openConnectionCallback() = client.connect(1337, "127.0.0.1", () => {
    console.log("Connected")
    client.write("Hello, server! Love, Client.")
  })


}
