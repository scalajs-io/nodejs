package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * MongoDB Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Server extends js.Object {
  var host: String = js.native
  var port: Int = js.native
}

/**
  * MongoDB Server
  * @author lawrence.daniels@gmail.com
  */
object Server {

  def apply(host: String, port: Int) = {
    val server = new Server()
    server.host = host
    server.port = port
    server
  }

}