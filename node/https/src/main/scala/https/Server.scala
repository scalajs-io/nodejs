package https

import org.scalajs.nodejs

import scala.scalajs.js

/**
  * This class is a subclass of tls.Server and emits events same as http.Server. See http.Server for more information.
  * @author lawrence.daniels@gmail.com
  * @see [[org.scalajs.nodejs.http.Server]]
  */
@js.native
trait Server extends nodejs.net.Server {

}
