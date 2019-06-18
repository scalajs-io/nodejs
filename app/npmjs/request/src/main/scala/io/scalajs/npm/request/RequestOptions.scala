package io.scalajs.npm.request

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.npm.toughcookie.CookieJar

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Request Options
  * @author lawrence.daniels@gmail.com
  */
class RequestOptions(var url: js.UndefOr[String] = js.undefined,
                     var uri: js.UndefOr[String] = js.undefined,
                     var json: js.UndefOr[js.Any] = js.undefined,
                     var body: js.UndefOr[Buffer | String] = js.undefined,
                     var form: js.Any = js.undefined,
                     var formData: js.Any = js.undefined,
                     var jar: js.UndefOr[CookieJar] = js.undefined,
                     var gzip: js.UndefOr[Boolean] = js.undefined,
                     var method: js.UndefOr[String] = js.undefined,
                     var oauth: js.Any = js.undefined,
                     var proxy: js.UndefOr[String] = js.undefined,
                     var qs: js.Any = js.undefined)
  extends js.Object