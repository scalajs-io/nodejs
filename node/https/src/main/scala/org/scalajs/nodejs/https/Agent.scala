package org.scalajs.nodejs.https

import org.scalajs.nodejs

import scala.scalajs.js

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Agent extends nodejs.http.Agent
