package com.github.ldaniels528.meansjs.nodejs.dns

import scala.scalajs.js

/**
  * Represents a DNS SOA record.
  * <pre>
  * {
  * nsname: 'ns.example.com',
  * hostmaster: 'root.example.com',
  * serial: 2013101809,
  * refresh: 10000,
  * retry: 2400,
  * expire: 604800,
  * minttl: 3600
  * }
  * </pre>
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SOA extends js.Object {
  var nsname: String = js.native
  var hostmaster: String = js.native
  var serial: Integer = js.native
  var refresh: Integer = js.native
  var retry: Integer = js.native
  var expire: Integer = js.native
  var minttl: Integer = js.native
}
