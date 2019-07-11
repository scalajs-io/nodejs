package io.scalajs.npm.cookie

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Cookie Deserialization Options
  * @param decode Specifies a function that will be used to decode a cookie's value. Since the value of a cookie
  *               has a limited character set (and must be a simple string), this function can be used to decode
  *               a previously-encoded cookie value into a JavaScript string or other object.
  *
  *               The default function is the global decodeURIComponent, which will decode any URL-encoded sequences
  *               into their byte representations.
  *
  *               Note: if an error is thrown from this function, the original, non-decoded cookie value will
  *               be returned as the cookie's value.
  * @author lawrence.daniels@gmail.com
  */
class DeserializationOptions(var decode: js.UndefOr[js.Function] = js.undefined) extends js.Object

/**
  * Deserialization Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DeserializationOptions extends FlexibleOptions[DeserializationOptions]