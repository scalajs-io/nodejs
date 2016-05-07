package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.net.{ClientOptions, Net}
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Net Server Example
  * @author lawrence.daniels@gmail.com
  */
class NetServerExample(bootstrap: Bootstrap) {
  import bootstrap._

  val net = require[Net]("net")
  val client = net.connect(ClientOptions(port = 8124), connect)

  client.onData((data: js.Any) => {
    console.log(data.toString())
    client.end()
  })

  client.onEnd(() => console.log("disconnected from server"))

  private def connect: js.Function = () => {
    console.log("connected to server!")
    client.write("world!\r\n")
  }

}
