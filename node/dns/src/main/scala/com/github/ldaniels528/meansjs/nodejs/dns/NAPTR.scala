package com.github.ldaniels528.meansjs.nodejs.dns

import scala.scalajs.js

/**
  * Represents a DNS NAPTR record.
  * <pre>
  * {
  * flags: "s",
  * service: "SIP+D2U",
  * regexp: "",
  * replacement: "_sip._udp.example.com",
  * order: 30,
  * preference: 100
  * }
  * </pre>
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NAPTR extends js.Object {
  var flags: String = js.native
  var service: String = js.native
  var regexp: String = js.native
  var replacement: String = js.native
  var order: Integer = js.native
  var preference: Integer = js.native
}
