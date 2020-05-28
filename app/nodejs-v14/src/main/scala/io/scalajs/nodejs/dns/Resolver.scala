package io.scalajs.nodejs.dns

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("dns", "Resolver")
class Resolver extends IResolver {
  def cancel(): Unit = js.native
}

@js.native
trait IResolver extends js.Object {
  def getServers(): js.Array[String] = js.native

  def resolve(hostname: String, rrtype: RRType, callback: DnsCallback1[ResolveResult]): Unit =
    js.native
  def resolve(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def resolve4(hostname: String, options: TtlOptions, callback: DnsCallback1[js.Array[String]]): Unit = js.native
  def resolve4(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit                      = js.native

  def resolve6(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit                      = js.native
  def resolve6(hostname: String, options: TtlOptions, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def resolveAny(hostname: String, callback: DnsCallback1[js.Array[ResolveObject]]): Unit = js.native

  def resolveCname(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def resolveMx(hostname: String, callback: DnsCallback1[js.Array[MX]]): Unit = js.native

  def resolveNaptr(hostname: String, callback: DnsCallback1[js.Array[NAPTR]]): Unit = js.native

  def resolveNs(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def resolveSoa(hostname: String, callback: DnsCallback1[js.Array[SOA]]): Unit = js.native

  def resolveSrv(hostname: String, callback: DnsCallback1[js.Array[SRV]]): Unit = js.native

  def resolvePtr(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def resolveTxt(hostname: String, callback: DnsCallback1[js.Array[js.Array[String]]]): Unit = js.native

  def reverse(ipAddress: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  def setServers(servers: js.Array[String]): Unit = js.native
}
