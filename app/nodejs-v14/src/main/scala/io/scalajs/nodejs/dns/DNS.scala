package io.scalajs.nodejs.dns

import com.thoughtworks.enableIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The dns module contains functions belonging to two different categories:
  * 1) Functions that use the underlying operating system facilities to perform name resolution, and that do not
  * necessarily perform any network communication. This category contains only one function: dns.lookup(). Developers
  * looking to perform name resolution in the same way that other applications on the same operating system behave
  * should use dns.lookup().
  * @see https://nodejs.org/api/dns.html
  */
@js.native
trait DNS extends IResolver {

  /**
    * Resolves a hostname (e.g. 'nodejs.org') into the first found A (IPv4) or AAAA (IPv6) record. options can be an
    * object or integer. If options is not provided, then IPv4 and IPv6 addresses are both valid. If options is an
    * integer, then it must be 4 or 6.
    *
    * Alternatively, options can be an object containing these properties:
    * <ul>
    * <li>family <Number> - The record family. If present, must be the integer 4 or 6. If not provided, both IP v4
    * and v6 addresses are accepted.</li>
    * <li>hints: <Number> - If present, it should be one or more of the supported getaddrinfo flags. If hints is not
    * provided, then no flags are passed to getaddrinfo. Multiple flags can be passed through hints by logically
    * ORing their values. See supported getaddrinfo flags for more information on supported flags.</li>
    * <li>all: <Boolean> - When true, the callback returns all resolved addresses in an array, otherwise returns a
    * single address. Defaults to false.</li>
    * </ul>
    * All properties are optional.
    * @example dns.lookup(hostname[, options], callback)
    */
  def lookup(hostname: String, options: DnsOptions | Int, callback: DnsCallback2[String, Int]): Unit = js.native

  /**
    * Resolves a hostname (e.g. 'nodejs.org') into the first found A (IPv4) or AAAA (IPv6) record. options can be an
    * object or integer. If options is not provided, then IPv4 and IPv6 addresses are both valid. If options is an
    * integer, then it must be 4 or 6.
    *
    * Alternatively, options can be an object containing these properties:
    * <ul>
    * <li>family <Number> - The record family. If present, must be the integer 4 or 6. If not provided, both IP v4
    * and v6 addresses are accepted.</li>
    * <li>hints: <Number> - If present, it should be one or more of the supported getaddrinfo flags. If hints is not
    * provided, then no flags are passed to getaddrinfo. Multiple flags can be passed through hints by logically
    * ORing their values. See supported getaddrinfo flags for more information on supported flags.</li>
    * <li>all: <Boolean> - When true, the callback returns all resolved addresses in an array, otherwise returns a
    * single address. Defaults to false.</li>
    * </ul>
    * All properties are optional.
    * @example dns.lookup(hostname[, options], callback)
    */
  def lookup(hostname: String, callback: DnsCallback1[String]): Unit = js.native

  /**
    * Resolves the given address and port into a hostname and service using the operating system's underlying
    * getnameinfo implementation.
    *
    * If address is not a valid IP address, a TypeError will be thrown. The port will be coerced to a number. If it is
    * not a legal port, a TypeError will be thrown.
    *
    * The callback has arguments (err, hostname, service). The hostname and service arguments are strings
    * (e.g. 'localhost' and 'http' respectively).
    *
    * On error, err is an Error object, where err.code is the error code.
    * @example dns.lookupService(address, port, callback)
    * @example dns.lookupService('127.0.0.1', 22, (err, hostname, service) => { ... })
    */
  def lookupService(address: String, port: Int, callback: DnsCallback2[String, String]): Unit = js.native
}

/**
  * DNS Singleton
  */
@js.native
@JSImport("dns", JSImport.Namespace)
object DNS extends DNS {
  @js.native
  object promises extends js.Object {
    type Resolver = PromisesResolver
  }

  /////////////////////////////////////////////////////////////////////////////////
  //      getaddrinfo flags
  /////////////////////////////////////////////////////////////////////////////////
  /** Returned address types are determined by the types of addresses supported by the current system.
    * For example, IPv4 addresses are only returned if the current system has at least one IPv4 address configured.
    * Loopback addresses are not considered.
    */
  val ADDRCONFIG: Int = js.native

  /** If the IPv6 family was specified, but no IPv6 addresses were found, then return IPv4 mapped IPv6 addresses.
    * It is not supported on some operating systems (e.g FreeBSD 10.1).
    */
  val V4MAPPED: Int = js.native

  /** If dns.V4MAPPED is specified, return resolved IPv6 addresses as well as IPv4 mapped IPv6 addresses.
    * From Node.js v14.0.0.
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  val ALL: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Error Codes
  /////////////////////////////////////////////////////////////////////////////////

  /** DNS server returned answer with no data. */
  val NODATA: String = js.native

  /** DNS server claims query was misformatted. */
  val FORMERR: String = js.native

  /** DNS server returned general failure. */
  val SERVFAIL: String = js.native

  /** Domain name not found. */
  val NOTFOUND: String = js.native

  /** DNS server does not implement requested operation. */
  val NOTIMP: String = js.native

  /** DNS server refused query. */
  val REFUSED: String = js.native

  /** Misformatted DNS query. */
  val BADQUERY: String = js.native

  /** Misformatted hostname. */
  val BADNAME: String = js.native

  /** Unsupported address family. */
  val BADFAMILY: String = js.native

  /** Misformatted DNS reply. */
  val BADRESP: String = js.native

  /** Could not contact DNS servers. */
  val CONNREFUSED: String = js.native

  /** Timeout while contacting DNS servers. */
  val TIMEOUT: String = js.native

  /** End of file. */
  val EOF: String = js.native

  /** Error reading file. */
  val FILE: String = js.native

  /** Out of memory. */
  val NOMEM: String = js.native

  /** Channel is being destroyed. */
  val DESTRUCTION: String = js.native

  /** Misformatted string. */
  val BADSTR: String = js.native

  /** Illegal flags specified. */
  val BADFLAGS: String = js.native

  /** Given hostname is not numeric. */
  val NONAME: String = js.native

  /** Illegal hints flags specified. */
  val BADHINTS: String = js.native

  /** c-ares library initialization not yet performed. */
  val NOTINITIALIZED: String = js.native

  /** Error loading iphlpapi.dll. */
  val LOADIPHLPAPI: String = js.native

  /** Could not find GetNetworkParams function. */
  val ADDRGETNETWORKPARAMS: String = js.native

  /** DNS query cancelled. */
  val CANCELLED: String = js.native
}
