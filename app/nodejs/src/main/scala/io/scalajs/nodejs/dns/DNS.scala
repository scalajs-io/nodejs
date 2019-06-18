package io.scalajs.nodejs.dns

import io.scalajs.RawOptions

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
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DNS extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns an array of IP address strings that are being used for name resolution.
    */
  def getServers(): js.Array[String] = js.native

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
  def lookup(hostname: String, options: DnsOptions | RawOptions | Int, callback: DnsCallback1[String]): Unit = js.native

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

  /**
    * Uses the DNS protocol to resolve a hostname (e.g. 'nodejs.org') into an array of the record types specified by rrtype.
    * On error, err is an Error object, where err.code is one of the error codes listed here.
    * @param hostname the hostname
    * @param rrtype   the given rrtype
    *                 Valid values for rrtype are:
    *                 'A' - IPV4 addresses, default
    *                 'AAAA' - IPV6 addresses
    *                 'MX' - mail exchange records
    *                 'TXT' - text records
    *                 'SRV' - SRV records
    *                 'PTR' - PTR records
    *                 'NS' - name server records
    *                 'CNAME' - canonical name records
    *                 'SOA' - start of authority record
    *                 'NAPTR' - name authority pointer record
    * @param callback the callback function has arguments (err, addresses). When successful, addresses will be an array.
    *                 The type of each item in addresses is determined by the record type, and described in the
    *                 documentation for the corresponding lookup methods.
    * @example dns.resolve(hostname[, rrtype], callback)
    */
  def resolve[A](hostname: String, rrtype: RRType, callback: DnsCallback1[A]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve a hostname (e.g. 'nodejs.org') into an array of the record types specified by rrtype.
    * On error, err is an Error object, where err.code is one of the error codes listed here.
    * @param hostname the hostname
    * @param callback the callback function has arguments (err, addresses). When successful, addresses will be an array. The type of
    *                 each item in addresses is determined by the record type, and described in the documentation for the corresponding
    *                 lookup methods.
    * @example dns.resolve(hostname[, rrtype], callback)
    */
  def resolve(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve a IPv4 addresses (A records) for the hostname. The addresses argument passed to
    * the callback function will contain an array of IPv4 addresses (e.g. ['74.125.79.104', '74.125.79.105', '74.125.79.106']).
    * @example dns.resolve4(hostname, callback)
    */
  def resolve4(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve a IPv6 addresses (AAAA records) for the hostname. The addresses argument passed
    * to the callback function will contain an array of IPv6 addresses.
    * @example dns.resolve6(hostname, callback)
    */
  def resolve6(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve CNAME records for the hostname. The addresses argument passed to the callback
    * function will contain an array of canonical name records available for the hostname (e.g. ['bar.example.com']).
    * @example dns.resolveCname(hostname, callback)
    */
  def resolveCname(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve mail exchange records (MX records) for the hostname. The addresses argument
    * passed to the callback function will contain an array of objects containing both a priority and exchange property
    * (e.g. [{priority: 10, exchange: 'mx.example.com'}, ...]).
    * @example dns.resolveMx(hostname, callback)
    */
  def resolveMx(hostname: String, callback: DnsCallback1[MX]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve regular expression based records (NAPTR records) for the hostname. The callback
    * function has arguments (err, addresses). The addresses argument passed to the callback function will contain an
    * array of objects with the following properties:
    * <ul>
    * <li>flags</li>
    * <li>service</li>
    * <li>regexp</li>
    * <li>replacement</li>
    * <li>order</li>
    * <li>preference</li>
    * </ul>
    * @example dns.resolveNaptr(hostname, callback)
    */
  def resolveNaptr(hostname: String, callback: DnsCallback1[NAPTR]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve name server records (NS records) for the hostname. The addresses argument passed
    * to the callback function will contain an array of name server records available for hostname
    * (e.g., ['ns1.example.com', 'ns2.example.com']).
    * @example dns.resolveNs(hostname, callback)
    */
  def resolveNs(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve a start of authority record (SOA record) for the hostname. The addresses argument
    * passed to the callback function will be an object with the following properties:
    * <ul>
    * <li>nsname</li>
    * <li>hostmaster</li>
    * <li>serial</li>
    * <li>refresh</li>
    * <li>retry</li>
    * <li>expire</li>
    * <li>minttl</li>
    * </ul>
    * @example dns.resolveSoa(hostname, callback)
    */
  def resolveSoa(hostname: String, callback: DnsCallback1[SOA]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve service records (SRV records) for the hostname. The addresses argument passed to
    * the callback function will be an array of objects with the following properties:
    * <ul>
    * <li>priority</li>
    * <li>weight</li>
    * <li>port</li>
    * <li>name</li>
    * </ul>
    * @example dns.resolveSrv(hostname, callback)
    */
  def resolveSrv(hostname: String, callback: DnsCallback1[SRV]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve pointer records (PTR records) for the hostname. The addresses argument passed to
    * the callback function will be an array of strings containing the reply records.
    * @example dns.resolvePtr(hostname, callback)
    */
  def resolvePtr(hostname: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Uses the DNS protocol to resolve text queries (TXT records) for the hostname. The addresses argument passed to the
    * callback function is is a two-dimentional array of the text records available for hostname
    * (e.g., [ ['v=spf1 ip4:0.0.0.0 ', '~all' ] ]). Each sub-array contains TXT chunks of one record. Depending on the
    * use case, these could be either joined together or treated separately.
    * @example dns.resolveTxt(hostname, callback)
    */
  def resolveTxt(hostname: String, callback: DnsCallback1[js.Array[js.Array[String]]]): Unit = js.native

  /**
    * Performs a reverse DNS query that resolves an IPv4 or IPv6 address to an array of hostnames.
    * The callback function has arguments (err, hostnames), where hostnames is an array of resolved hostnames for the given ip.
    * On error, err is an Error object, where err.code is one of the DNS error codes.
    * @example dns.reverse(ip, callback)
    */
  def reverse(ipAddress: String, callback: DnsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Sets the IP addresses of the servers to be used when resolving. The servers argument is an array of IPv4 or IPv6 addresses.
    * If a port specified on the address it will be removed.
    * An error will be thrown if an invalid address is provided.
    * The dns.setServers() method must not be called while a DNS query is in progress.
    * @example dns.setServers(servers)
    */
  def setServers(servers: js.Array[String]): Unit = js.native

}

/**
  * DNS Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("dns", JSImport.Namespace)
object DNS extends DNS {

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