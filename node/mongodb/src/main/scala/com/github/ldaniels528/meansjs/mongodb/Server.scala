package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * MongoDB Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Server extends js.Object {
  var host: String = _
  var port: Int = _
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