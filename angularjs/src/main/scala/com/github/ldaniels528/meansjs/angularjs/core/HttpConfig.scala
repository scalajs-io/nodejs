package com.github.ldaniels528.meansjs.angularjs.core

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => JS}

/**
 * AngularJS HTTP Service Configuration
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait HttpConfig extends js.Object {
  var method: String = js.native
  var url: String = js.native
  var params: js.Dictionary[js.Any] = js.native
  var data: js.Any = js.native
  var headers: js.Dictionary[js.Any] = js.native
  var xsrfHeaderName: String = js.native
  var xsrfCookieName: String = js.native
  var transformResponse: js.Array[js.Function2[js.Any, js.Any, js.Any]] = js.native
  var transformRequest: js.Array[js.Function2[js.Any, js.Any, js.Any]] = js.native
  var cache: js.Any = js.native
  var withCredentials: Boolean = js.native
  var timeout: js.Any = js.native
  var responseType: String = js.native
}

/**
 * AngularJS HTTP Service Configuration Singleton
 * @author lawrence.daniels@gmail.com
 */
object HttpConfig {

  def apply[T](params: (String, T)*): HttpConfig = JS(params = js.Dictionary(params: _*)).asInstanceOf[HttpConfig]

  def apply(method: String = null,
            url: String = null,
            params: js.Dictionary[js.Any] = null,
            data: js.Any = null,
            headers: js.Dictionary[js.Any] = null,
            xsrfHeaderName: String = null,
            xsrfCookieName: String = null,
            transformResponse: js.Array[js.Function2[js.Any, js.Any, js.Any]] = null,
            transformRequest: js.Array[js.Function2[js.Any, js.Any, js.Any]] = null,
            cache: js.Any = null,
            withCredentials: Boolean = false,
            timeout: js.Any = null,
            responseType: String = null): HttpConfig = {
    JS(method = method, url = url, params = params, data = data, headers = headers,
      xsrfCookieName = xsrfCookieName, xsrfHeaderName = xsrfHeaderName,
      transformRequest = transformRequest, transformResponse = transformResponse,
      cache = cache, withCredentials = withCredentials, timeout = timeout,
      responseType = responseType).asInstanceOf[HttpConfig]
  }

}
