package com.github.ldaniels528.meansjs.angularjs.http

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * AngularJS HTTP Service Configuration
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class HttpConfig(var method: String,
                 var url: String,
                 var params: js.Dictionary[js.Any],
                 var data: js.Any,
                 var headers: js.Dictionary[js.Any],
                 var xsrfHeaderName: String,
                 var xsrfCookieName: String,
                 var transformResponse: js.Array[js.Function], // js.Function2[js.Any, js.Any, js.Any]
                 var transformRequest: js.Array[js.Function], // js.Function2[js.Any, js.Any, js.Any]
                 var cache: js.Any,
                 var withCredentials: Boolean,
                 var timeout: js.Any,
                 var responseType: String) extends js.Object

/**
  * AngularJS HTTP Service Configuration Singleton
  * @author lawrence.daniels@gmail.com
  */
object HttpConfig {

  def apply(method: String = null,
            url: String = null,
            params: js.Dictionary[js.Any] = null,
            data: js.Any = null,
            headers: js.Dictionary[js.Any] = null,
            xsrfHeaderName: String = null,
            xsrfCookieName: String = null,
            transformResponse: js.Array[js.Function] = null,
            transformRequest: js.Array[js.Function] = null,
            cache: js.Any = null,
            withCredentials: Boolean = false,
            timeout: js.Any = null,
            responseType: String = null) = {
    new HttpConfig(
      method = method, url = url, params = params, data = data, headers = headers,
      xsrfCookieName = xsrfCookieName, xsrfHeaderName = xsrfHeaderName,
      transformRequest = transformRequest, transformResponse = transformResponse,
      cache = cache, withCredentials = withCredentials, timeout = timeout,
      responseType = responseType
    )
  }

}
