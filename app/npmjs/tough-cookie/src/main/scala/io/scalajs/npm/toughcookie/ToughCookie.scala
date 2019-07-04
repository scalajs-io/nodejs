package io.scalajs.npm.toughcookie

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Tough-Cookie Object
  * @see https://www.npmjs.com/package/tough-cookie
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ToughCookie extends js.Object {

  /**
    * Parse a cookie date string into a Date. Parses according to RFC6265 Section 5.1.1, not Date.parse().
    * @param string the given date string
    * @return the [[js.Date]]
    */
  def parseDate(string: String): js.Date = js.native

  /**
    * Format a Date into a RFC1123 string (the RFC6265-recommended format).
    * @param date the given [[js.Date]]
    * @return the date-formatted string
    */
  def formatDate(date: js.Date): String = js.native

  /**
    * Transforms a domain-name into a canonical domain-name. The canonical domain-name is a trimmed,
    * lowercased, stripped-of-leading-dot and optionally punycode-encoded domain-name (Section 5.1.2 of RFC6265).
    * For the most part, this function is idempotent (can be run again on its output without ill effects).
    * @param str the domain string
    * @return the canonical domain
    */
  def canonicalDomain(str: String): String = js.native

  /**
    * Answers "does this real domain match the domain in a cookie?". The str is the "current" domain-name
    * and the domStr is the "cookie" domain-name. Matches according to RFC6265 Section 5.1.3, but it helps
    * to think of it as a "suffix match".
    *
    * The canonicalize parameter will run the other two paramters through canonicalDomain or not.
    * @param str
    * @param domStr
    * @param canonicalize
    * @return
    */
  def domainMatch(str: String, domStr: String, canonicalize: Boolean = js.native): Boolean = js.native

  /**
    * Given a current request/response path, gives the Path appropriate for storing in a cookie.
    * This is basically the "directory" of a "file" in the path, but is specified by Section 5.1.4 of the RFC.
    *
    * The path parameter MUST be only the pathname part of a URI (i.e. excludes the hostname, query, fragment, etc.).
    * This is the .pathname property of node's uri.parse() output.
    * @param path
    * @return
    */
  def defaultPath(path: String): String = js.native

  /**
    * Answers "does the request-path path-match a given cookie-path?" as per
    * RFC6265 Section 5.1.4. Returns a boolean.
    *
    * This is essentially a prefix-match where cookiePath is a prefix of reqPath.
    * @param reqPath
    * @param cookiePath
    * @return
    */
  def pathMatch(reqPath: String, cookiePath: String): Boolean = js.native

  /**
    * Alias for Cookie.parse(cookieString[, options])
    * @param cookieString the given cookie string
    * @param options      the parsing options
    */
  def parse(cookieString: String, options: js.Any = js.native): Cookie = js.native

  /**
    * Alias for Cookie.fromJSON(string)
    * @param string
    * @return
    */
  def fromJSON(string: String): js.Any = js.native

  /**
    * Returns the public suffix of this hostname. The public suffix is the shortest domain-name
    * upon which a cookie can be set. Returns null if the hostname cannot have cookies set for it.
    *
    * For example: www.example.com and www.subdomain.example.com both have public suffix example.com.
    *
    * For further information, see http://publicsuffix.org/. This module derives its list from that site.
    * @param hostname
    * @return
    */
  def getPublicSuffix(hostname: String): String = js.native

  /**
    * For use with .sort(), sorts a list of cookies into the recommended order given in
    * the RFC (Section 5.4 step 2). The sort algorithm is, in order of precedence:
    * <ul>
    * <li>Longest .path</li>
    * <li>oldest .creation (which has a 1ms precision, same as Date)</li>
    * <li>lowest .creationIndex (to get beyond the 1ms precision)</li>
    * </ul>
    * @param a
    * @param b
    * @return
    */
  def cookieCompare(a: Cookie, b: Cookie): Boolean = js.native

  /**
    * Generates a list of all possible domains that domainMatch() the parameter.
    * May be handy for implementing cookie stores.
    * @param domain
    * @return
    */
  def permuteDomain(domain: String): js.Array[String] = js.native

  /**
    * Generates a list of all possible paths that pathMatch() the parameter.
    * May be handy for implementing cookie stores.
    * @param path
    * @return
    */
  def permutePath(path: String): js.Array[String] = js.native

}

@js.native
@JSImport("tough-cookie", JSImport.Namespace)
object ToughCookie extends ToughCookie