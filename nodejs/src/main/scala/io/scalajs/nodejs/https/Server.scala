package io.scalajs.nodejs.https

import io.scalajs.nodejs.net

import scala.scalajs.js

/**
  * This class is a subclass of tls.Server and emits events same as http.Server. See http.Server for more information.
  * @author lawrence.daniels@gmail.com
  * @see [[Server]]
  */
@js.native
trait Server extends net.Server {

}
