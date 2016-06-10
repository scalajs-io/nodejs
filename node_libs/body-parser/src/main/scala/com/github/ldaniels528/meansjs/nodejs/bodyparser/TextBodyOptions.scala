package com.github.ldaniels528.meansjs.nodejs.bodyparser

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Text Body Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TextBodyOptions extends js.Object {

  /**
    * Specify the default character set for the text content if the charset is not specified in the Content-Type
    * header of the request. Defaults to utf-8.
    */
  var defaultCharset: js.UndefOr[String] = js.native

  /**
    * When set to true, then deflated (compressed) bodies will be inflated; when false, deflated bodies are rejected.
    * Defaults to true.
    */
  var inflate: js.UndefOr[Boolean] = js.native

  /**
    * Controls the maximum request body size. If this is a number, then the value specifies the number of bytes;
    * if it is a string, the value is passed to the bytes library for parsing. Defaults to '100kb'.
    */
  var limit: js.UndefOr[Int] = js.native

  /**
    * The type option is used to determine what media type the middleware will parse. This option can be a function or
    * a string. If a string, type option is passed directly to the type-is library and this can be an extension name
    * (like json), a mime type (like application/json), or a mime type with a wildcard (like * / * or * /json).
    * If a function, the type option is called as fn(req) and the request is parsed if it returns a truthy value.
    * Defaults to application/json.
    */
  var `type`: js.UndefOr[String] = js.native

  /**
    * The verify option, if supplied, is called as verify(req, res, buf, encoding), where buf is a Buffer of the raw
    * request body and encoding is the encoding of the request. The parsing can be aborted by throwing an error.
    */
  var verify: js.UndefOr[String] = js.native

}

/**
  * Text Body Options Companion
  * @author lawrence.daniels@gmail.com
  */
object TextBodyOptions {

  def apply(defaultCharset: js.UndefOr[String] = js.undefined,
            inflate: js.UndefOr[Boolean] = js.undefined,
            limit: js.UndefOr[Int] = js.undefined,
            `type`: js.UndefOr[String] = js.undefined,
            verify: js.UndefOr[String] = js.undefined) = {
    val options = New[TextBodyOptions]
    options.defaultCharset = defaultCharset
    options.inflate = inflate
    options.limit = limit
    options.`type`= `type`
    options.verify = verify
    options
  }

}