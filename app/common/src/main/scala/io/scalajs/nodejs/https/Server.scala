package io.scalajs.nodejs
package https

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * This class is a subclass of tls.Server and emits events same as http.Server. See http.Server for more information.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("https", "Server")
class Server extends tls.Server