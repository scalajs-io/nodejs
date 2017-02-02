package io.scalajs.npm.socketio

import io.scalajs.JSON
import io.scalajs.nodejs.http.{ClientRequest, Http, ServerResponse}
import io.scalajs.nodejs.{setTimeout, _}
import io.scalajs.npm.express.Express
import org.scalatest.FunSpec

import scala.concurrent.duration._

/**
  * Socket.io Server Tests
  * @author lawrence.daniels@gmail.com
  */
class ServerTest extends FunSpec {

  describe("Server") {

    it("works standalone") {
      val server = SocketIO()
      server.listen(3000)
      setTimeout(() => server.close(), 1.second)
    }

    it("works with Node Server") {
      val httpServer = Http.createServer()
      val server     = SocketIO(httpServer)
      httpServer.listen(3001)
      setTimeout(() => server.close(), 1.second)
    }

    it("works with Express") {
      val app        = Express()
      val httpServer = Http.createServer((_: ClientRequest, _: ServerResponse) => {})
      val server     = SocketIO(httpServer)
      httpServer.listen(3002)
      setTimeout(() => server.close(), 1.second)
    }

    it("supports client connections") {
      val port = 3003

      // schedule the client connection
      setTimeout(
        () => {
          info("client: Connecting to server...")
          val client = SocketIOClient(s"http://localhost:$port")
          client.onConnect(() => client.emit("status: I'm in love!"))
          client.onEvent(data => console.log("client: I have an event", data))
          client.onDisconnect(() => info(s"client: I've disconnected"))
        },
        500.millis
      )

      // start the HTTP server
      val httpServer = Http.createServer()
      val server     = SocketIO(httpServer)
      server.onConnection { socket =>
        info(s"server: client connected on port $port")
        server.sockets.emit("an event sent to all connected clients")
        socket.onEvent(data => info(s"server: socket data => ${JSON.stringify(data)}"))
        setTimeout(() => socket.onDisconnect(() => info(s"server: client disconnected")), 500.millis)
      }
      server.listen(port)

      // shutdown the server
      setTimeout(() => server.close(), 1.second)
    }

  }

}
