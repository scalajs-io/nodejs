package io.scalajs.nodejs
package url

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * This module has utilities for URL resolution and parsing. Call require('url') to use it.
  * @param input The input URL to parse
  * @param base  The base URL to resolve against if the input is not absolute.
  * @see https://nodejs.org/api/url.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("url", "URL")
class URL(input: String, base: String | URL = js.native) extends js.Object {

  /**
    * The auth property is the username and password portion of the URL, also referred to as "userinfo".
    * This string subset follows the protocol and double slashes (if present) and precedes the host component,
    * delimited by an ASCII "at sign" (@). The format of the string is {username}[:{password}],
    * with the [:{password}] portion being optional.
    */
  var auth: String = js.native

  /**
    * Gets and sets the fragment portion of the URL.
    */
  var hash: String = js.native

  /**
    * Gets and sets the host portion of the URL.
    */
  var host: String = js.native

  /**
    * Gets and sets the hostname portion of the URL.
    * The key difference between url.host and url.hostname is that url.hostname does not include the port.
    */
  var hostname: String = js.native

  /**
    * Gets and sets the serialized URL.
    */
  var href: String = js.native

  /**
    * Gets the read-only serialization of the URL's origin.
    */
  var origin: String = js.native

  /**
    * Gets and sets the password portion of the URL.
    */
  var password: String = js.native

  /**
    * Gets and sets the path portion of the URL.
    */
  var pathname: String = js.native

  /**
    * Gets and sets the port portion of the URL.
    */
  var port: String = js.native

  /**
    * Gets and sets the protocol portion of the URL.
    */
  var protocol: String = js.native

  /**
    * Gets and sets the serialized query portion of the URL.
    */
  var search: String = js.native

  /**
    * Gets the URLSearchParams object representing the query parameters of the URL. This property is read-only;
    * to replace the entirety of query parameters of the URL, use the url.search setter.
    * See URLSearchParams documentation for details.
    */
  var searchParams: URLSearchParams = js.native

  /**
    * Gets and sets the username portion of the URL.
    */
  var username: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The toJSON() method on the URL object returns the serialized URL. The value returned is equivalent to that of
    * url.href and url.toString().
    *
    * This method is automatically called when an URL object is serialized with JSON.stringify().
    * @return a JSON representation of the URL
    */
  def toJSON(): String = js.native

}

/**
  * This module has utilities for URL resolution and parsing. Call require('url') to use it.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("url", JSImport.Namespace)
object URL extends IEventEmitter {

  /**
    * Take a parsed URL object, and return a formatted URL string.
    * @example url.format(urlObj)
    */
  def format(urlObj: ParsedURL): String = js.native

  /**
    * Take a URL string, and return an object.
    *
    * Pass true as the second argument to also parse the query string using the querystring module. If true then the
    * query property will always be assigned an object, and the search property will always be a (possibly empty)
    * string. If false then the query property will not be parsed or decoded. Defaults to false.
    *
    * Pass true as the third argument to treat //foo/bar as { host: 'foo', pathname: '/bar' } rather
    * than { pathname: '//foo/bar' }. Defaults to false.
    * @example url.parse(urlStr[, parseQueryString][, slashesDenoteHost])
    */
  def parse(urlStr: String, parseQueryString: String, slashesDenoteHost: Boolean): ParsedURL = js.native

  /**
    * Take a URL string, and return an object.
    *
    * Pass true as the second argument to also parse the query string using the querystring module. If true then the
    * query property will always be assigned an object, and the search property will always be a (possibly empty)
    * string. If false then the query property will not be parsed or decoded. Defaults to false.
    *
    * Pass true as the third argument to treat //foo/bar as { host: 'foo', pathname: '/bar' } rather
    * than { pathname: '//foo/bar' }. Defaults to false.
    * @example url.parse(urlStr[, parseQueryString][, slashesDenoteHost])
    */
  def parse(urlStr: String, parseQueryString: String): ParsedURL = js.native

  /**
    * Take a URL string, and return an object.
    *
    * Pass true as the second argument to also parse the query string using the querystring module. If true then the
    * query property will always be assigned an object, and the search property will always be a (possibly empty)
    * string. If false then the query property will not be parsed or decoded. Defaults to false.
    *
    * Pass true as the third argument to treat //foo/bar as { host: 'foo', pathname: '/bar' } rather
    * than { pathname: '//foo/bar' }. Defaults to false.
    * @example url.parse(urlStr[, parseQueryString][, slashesDenoteHost])
    */
  def parse(urlStr: String, slashesDenoteHost: Boolean): ParsedURL = js.native

  /**
    * Take a URL string, and return an object.
    *
    * Pass true as the second argument to also parse the query string using the querystring module. If true then the
    * query property will always be assigned an object, and the search property will always be a (possibly empty)
    * string. If false then the query property will not be parsed or decoded. Defaults to false.
    *
    * Pass true as the third argument to treat //foo/bar as { host: 'foo', pathname: '/bar' } rather
    * than { pathname: '//foo/bar' }. Defaults to false.
    * @example url.parse(urlStr[, parseQueryString][, slashesDenoteHost])
    */
  def parse(urlStr: String): ParsedURL = js.native

  /**
    * Take a base URL, and a href URL, and resolve them as a browser would for an anchor tag.
    * Examples:
    * url.resolve('/one/two/three', 'four')         // '/one/two/four'
    * url.resolve('http://example.com/', '/one')    // 'http://example.com/one'
    * url.resolve('http://example.com/one', '/two') // 'http://example.com/two'
    * @example url.resolve(from, to)
    */
  def resolve(from: String, to: String): String = js.native

}