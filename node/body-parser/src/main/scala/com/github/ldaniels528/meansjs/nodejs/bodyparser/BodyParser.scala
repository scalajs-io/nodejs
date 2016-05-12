package com.github.ldaniels528.meansjs.nodejs.bodyparser

import com.github.ldaniels528.meansjs.nodejs.express.Router

import scala.scalajs.js

/**
  * Express Body Parser
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/body-parser
  * @version 1.15.1
  */
@js.native
trait BodyParser extends js.Object {

  /**
    * Returns middleware that only parses json. This parser accepts any Unicode encoding of the body and supports
    * automatic inflation of gzip and deflate encodings.
    * @param options the optional options object
    * @return A new body object containing the parsed data is populated on the request object after the middleware (i.e. req.body).
    */
  def json(options: JsonBodyOptions = null): Router = js.native

  /**
    * Returns middleware that parses all bodies as a Buffer. This parser supports automatic inflation of gzip and deflate encodings.
    * @param options the optional options object
    * @return A new body object containing the parsed data is populated on the request object after the middleware
    *         (i.e. req.body). This will be a Buffer object of the body.
    */
  def raw(options: RawBodyOptions = null): Router = js.native

  /**
    * Returns middleware that parses all bodies as a string. This parser supports automatic inflation of gzip and deflate encodings.
    * @param options the optional options object
    * @return A new body string containing the parsed data is populated on the request object after the middleware
    *         (i.e. req.body). This will be a string of the body.
    */
  def text(options: TextBodyOptions = null): Router = js.native

  /**
    * Returns middleware that only parses urlencoded bodies. This parser accepts only UTF-8 encoding of the body and
    * supports automatic inflation of gzip and deflate encodings.
    * @param options the optional options object
    * @return A new body object containing the parsed data is populated on the request object after the middleware
    *         (i.e. req.body). This object will contain key-value pairs, where the value can be a string or array
    *         (when extended is false), or any type (when extended is true).
    */
  def urlencoded(options: UrlEncodedBodyOptions = null): Router = js.native

}
