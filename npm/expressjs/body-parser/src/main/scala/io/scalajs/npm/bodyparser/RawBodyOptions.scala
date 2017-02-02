package io.scalajs.npm.bodyparser

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Raw Body Options
  * @param inflate When set to true, then deflated (compressed) bodies will be inflated; when false, deflated bodies are rejected.
  *                Defaults to true.
  * @param limit   Controls the maximum request body size. If this is a number, then the value specifies the number of bytes;
  *                if it is a string, the value is passed to the bytes library for parsing. Defaults to '100kb'.
  * @param `type`  The type option is used to determine what media type the middleware will parse. This option can be a function or
  *                a string. If a string, type option is passed directly to the type-is library and this can be an extension name
  *                (like json), a mime type (like application/json), or a mime type with a wildcard (like * / * or * /json).
  *                If a function, the type option is called as fn(req) and the request is parsed if it returns a truthy value.
  *                Defaults to application/json.
  * @param verify  The verify option, if supplied, is called as verify(req, res, buf, encoding), where buf is a Buffer of the raw
  *                request body and encoding is the encoding of the request. The parsing can be aborted by throwing an error.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RawBodyOptions(var inflate: js.UndefOr[Boolean] = js.undefined,
                     var limit: js.UndefOr[Int] = js.undefined,
                     var `type`: js.UndefOr[String] = js.undefined,
                     var verify: js.UndefOr[String] = js.undefined)
    extends js.Object
