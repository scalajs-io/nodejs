package io.scalajs.nodejs.dns

import scala.scalajs.js

@js.native
sealed trait ResolveObject extends js.Object {}

@js.native
trait AddressTtl extends ResolveObject {
  val address: String = js.native
  val ttl: Int        = js.native
}

@js.native
trait ValueOnly extends ResolveObject {
  val value: String = js.native
}

@js.native
trait MX extends ResolveObject {
  val priority: Int    = js.native
  val exchange: String = js.native
}

@js.native
trait NAPTR extends ResolveObject {
  val flags: String       = js.native
  val service: String     = js.native
  val regexp: String      = js.native
  val replacement: String = js.native
  val order: Int          = js.native
  val preference: Int     = js.native
}

@js.native
trait SOA extends ResolveObject {
  val nsname: String     = js.native
  val hostmaster: String = js.native
  val serial: Int        = js.native
  val refresh: Int       = js.native
  val retry: Int         = js.native
  val expire: Int        = js.native
  val minttl: Int        = js.native
}

@js.native
trait SRV extends ResolveObject {
  val name: String  = js.native
  val priority: Int = js.native
  val port: Int     = js.native
  val weight: Int   = js.native
}

@js.native
trait TXT extends ResolveObject {
  val `type`: String                      = js.native
  val entires: js.Array[js.Array[String]] = js.native
}
