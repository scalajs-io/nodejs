package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

/**
  * MongoDB Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "Server")
class Server(val host: String, val port: Int) extends js.Object

/**
  * MongoDB Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Server")
object Server extends js.Object {
  val READ_SECONDARY: String = js.native
  val READ_PRIMARY: String   = js.native

}
