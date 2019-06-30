package io.scalajs.nodejs.https

import io.scalajs.nodejs

import scala.scalajs.js

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  */
@js.native
trait Agent extends nodejs.http.Agent
