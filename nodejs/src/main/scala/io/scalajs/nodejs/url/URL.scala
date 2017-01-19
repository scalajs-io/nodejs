package io.scalajs.nodejs.url

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * This module has utilities for URL resolution and parsing. Call require('url') to use it.
  * @version 7.4.0
  * @see https://nodejs.org/api/url.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait URL extends IEventEmitter {

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

/**
  * URL Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("url", JSImport.Namespace)
object URL extends URL