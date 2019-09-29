package io.scalajs.nodejs.https

import io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  */
@js.native
@JSImport("https", "Agent")
class Agent(options: AgentOptions = js.native) extends nodejs.http.Agent
