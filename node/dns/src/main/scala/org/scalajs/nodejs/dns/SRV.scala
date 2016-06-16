package org.scalajs.nodejs.dns

import scala.scalajs.js

/**
  * Represents a DNS SRV record.
  * <pre>
  * {
  * priority: 10,
  * weight: 5,
  * port: 21223,
  * name: 'service.example.com'
  * }
  * </pre>
  */
@js.native
trait SRV extends js.Object {
  var priority: Integer = js.native
  var weight: Integer = js.native
  var port: Integer = js.native
  var name: String = js.native
}
