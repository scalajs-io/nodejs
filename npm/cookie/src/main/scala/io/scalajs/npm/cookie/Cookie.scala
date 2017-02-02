package io.scalajs.npm.cookie

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * cookie - HTTP server cookie parsing and serialization
  * Basic HTTP cookie parser and serializer for HTTP servers.
  * @version 0.3.1
  * @see https://www.npmjs.com/package/cookie
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Cookie extends js.Object {

  /**
    * Parse an HTTP Cookie header string and returning an object of all cookie name-value pairs.
    * @param str     the string representing a Cookie header value
    * @param options is an optional object containing additional parsing options.
    * @return an object of all cookie name-value pairs.
    */
  def parse(str: String, options: DeserializationOptions | RawOptions = js.native): js.Dictionary[String] = js.native

  /**
    * Serialize a cookie name-value pair into a Set-Cookie header string.
    * @param name    is the name for the cookie
    * @param value   is the value to set the cookie to.
    * @param options is an optional object containing additional serialization options.
    * @return
    */
  def serialize(name: String, value: String | js.Any, options: SerializationOptions | RawOptions = js.native): String =
    js.native

}

/**
  * Cookie Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cookie", JSImport.Namespace)
object Cookie extends Cookie
