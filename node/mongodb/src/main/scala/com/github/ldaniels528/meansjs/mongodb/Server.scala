package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

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
@js.native
@JSName("Server")
object Server extends ServerClass