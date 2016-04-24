package com.github.ldaniels528.meansjs.nodejs.https

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Https extends NodeModule {

  /**
    * Returns a new HTTPS web server object. The options is similar to tls.createServer().
    * The requestListener is a function which is automatically added to the 'request' event.
    * @example https.createServer(options[, requestListener])
    */
  def createServer(options: ServerOptions, requestListener: js.Function): Server = js.native

  /**
    * Returns a new HTTPS web server object. The options is similar to tls.createServer().
    * The requestListener is a function which is automatically added to the 'request' event.
    * @example https.createServer(options[, requestListener])
    */
  def createServer(options: ServerOptions): Server = js.native

}
