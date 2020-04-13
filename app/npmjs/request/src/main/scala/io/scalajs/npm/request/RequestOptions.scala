package io.scalajs.npm.request

import io.scalajs.FlexibleOptions
import io.scalajs.npm.toughcookie.CookieJar

import scala.scalajs.js

/**
  * Request Options
  * @param url
  * @param uri
  * @param json
  * @param body
  * @param form
  * @param formData
  * @param jar
  * @param gzip
  * @param method
  * @param oauth
  * @param proxy
  * @param qs
  */
class RequestOptions(var url: js.UndefOr[String] = js.undefined,
                     var uri: js.UndefOr[String] = js.undefined,
                     var json: js.UndefOr[Boolean] = js.undefined,
                     var body: js.Any = js.undefined,
                     var form: js.Any = js.undefined,
                     var formData: js.Any = js.undefined,
                     var jar: js.UndefOr[CookieJar] = js.undefined,
                     var gzip: js.UndefOr[Boolean] = js.undefined,
                     var method: js.UndefOr[String] = js.undefined,
                     var oauth: js.Any = js.undefined,
                     var proxy: js.UndefOr[String] = js.undefined,
                     var qs: js.Any = js.undefined)
  extends js.Object

/**
  * Request Options
  * @author lawrence.daniels@gmail.com
  */
object RequestOptions extends FlexibleOptions[RequestOptions]