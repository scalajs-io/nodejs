package org.scalajs.nodejs.adal

import scala.scalajs.js

/**
  * Authentication Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AuthenticationResponse extends js.Object {
  val tokenType: String = js.native
  val accessToken: String = js.native
}
