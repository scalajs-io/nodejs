package org.scalajs.nodejs.azure.storage

import scala.scalajs.js

/**
  * Server Message
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerMessage extends js.Object {
  var messageid: String = js.native
  var messagetext: String = js.native
  var popreceipt: js.Any = js.native
}
