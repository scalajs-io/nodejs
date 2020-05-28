package io.scalajs.nodejs.dns

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("dns", "promises.Resolver")
class PromisesResolver extends js.Object {
  def getServers(): js.Array[String]              = js.native
  def setServers(servers: js.Array[String]): Unit = js.native

  def resolve(hostname: String, rrtype: RRType): js.Promise[ResolveResult]                      = js.native
  def resolve(hostname: String): js.Promise[js.Array[String]]                                   = js.native
  def resolve4(hostname: String, options: TtlOptions = js.native): js.Promise[js.Array[String]] = js.native
  def resolve6(hostname: String, options: TtlOptions = js.native): js.Promise[js.Array[String]] = js.native
  def resolveAny(hostname: String): js.Promise[js.Array[ResolveObject]]                         = js.native
  def resolveCname(hostname: String): js.Promise[js.Array[String]]                              = js.native
  def resolveMx(hostname: String): js.Promise[js.Array[MX]]                                     = js.native
  def resolveNaptr(hostname: String): js.Promise[js.Array[NAPTR]]                               = js.native
  def resolveNs(hostname: String): js.Promise[js.Array[String]]                                 = js.native
  def resolveSoa(hostname: String): js.Promise[js.Array[SOA]]                                   = js.native
  def resolveSrv(hostname: String): js.Promise[js.Array[SRV]]                                   = js.native
  def resolvePtr(hostname: String): js.Promise[js.Array[String]]                                = js.native
  def resolveTxt(hostname: String): js.Promise[js.Array[String]]                                = js.native
  def reverse(ipAddress: String): js.Promise[js.Array[String]]                                  = js.native
}
