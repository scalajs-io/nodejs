package io.scalajs.nodejs
package http

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * http.Server - This class inherits from net.Server and has the following additional events
  */
@js.native
@JSImport("http", "Server")
class Server extends net.Server {
  var headersTimeout: Int         = js.native
  var maxHeadersCount: Int | Null = js.native
  var timeout: Int                = js.native
  var keepAliveTimeout: Int       = js.native

  def setTimeout(callback: js.Function): this.type = js.native
}
