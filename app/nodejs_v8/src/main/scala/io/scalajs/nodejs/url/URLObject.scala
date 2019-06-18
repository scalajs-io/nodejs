package io.scalajs.nodejs.url

import scala.scalajs.js

/**
  * Parsed URL Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait URLObject extends js.Object {

  /**
    * The auth property is the username and password portion of the URL, also referred to as "userinfo".
    * This string subset follows the protocol and double slashes (if present) and precedes the host component,
    * delimited by an ASCII "at sign" (@). The format of the string is {username}[:{password}], with
    * the [:{password}] portion being optional.
    * @example 'user:pass'
    */
  var auth: js.UndefOr[String] = js.native

  /**
    * The hash property consists of the "fragment" portion of the URL including the leading ASCII hash (#) character.
    * @example '#hash'
    */
  var hash: js.UndefOr[String] = js.native

  /**
    * The host property is the full lower-cased host portion of the URL, including the port if specified.
    * @example 'host.com:8080'
    */
  var host: js.UndefOr[String] = js.native

  /**
    * The hostname property is the lower-cased host name portion of the host component without the port included.
    * @example 'host.com'
    */
  var hostname: js.UndefOr[String] = js.native

  /**
    * The href property is the full URL string that was parsed with both the protocol and host components
    * converted to lower-case.
    * @example {{{ http://user:pass@host.com:8080/p/a/t/h?query=string#hash }}}
    */
  var href: js.UndefOr[String] = js.native

  /**
    * The path property is a concatenation of the pathname and search components.
    * @example '/p/a/t/h?query=string'
    */
  var path: js.UndefOr[String] = js.native

  /**
    * The pathname property consists of the entire path section of the URL. This is everything following the host
    * (including the port) and before the start of the query or hash components, delimited by either the ASCII
    * question mark (?) or hash (#) characters.
    * @example '/p/a/t/h'
    */
  var pathname: js.UndefOr[String] = js.native

  /**
    * The port property is the numeric port portion of the host component.
    * @example '8080'
    */
  var port: js.UndefOr[String] = js.native

  /**
    * The protocol property identifies the URL's lower-cased protocol scheme.
    * @example 'http:'
    */
  var protocol: js.UndefOr[String] = js.native

  /**
    * The query property is either the query string without the leading ASCII question mark (?), or an object returned
    * by the querystring module's parse() method. Whether the query property is a string or object is determined by the
    * parseQueryString argument passed to url.parse().
    *
    * If returned as a string, no decoding of the query string is performed. If returned as an object, both keys and
    * values are decoded.
    * @example 'query=string' or {'query': 'string'}
    */
  var query: js.UndefOr[String] = js.native

  /**
    * The search property consists of the entire "query string" portion of the URL, including the leading ASCII
    * question mark (?) character.
    * @example '?query=string'
    */
  var search: js.UndefOr[String] = js.native

  /**
    * The slashes property is a boolean with a value of true if two ASCII forward-slash characters (/) are required
    * following the colon in the protocol.
    */
  var slashes: js.UndefOr[Boolean] = js.native

}
