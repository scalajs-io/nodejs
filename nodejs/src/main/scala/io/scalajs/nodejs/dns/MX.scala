package io.scalajs.nodejs.dns

import scala.scalajs.js

/**
  * Represents an MX record.
  * <pre>
  * {
  * exchange: 'bing-com.mail.protection.outlook.com',
  * priority: 10
  * }
  * </pre>
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MX extends js.Object {
  var exchange: String = js.native
  var priority: Integer = js.native
}
