package org.scalajs.angularjs.http

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

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
  var transformResponse: js.Array[js.Function] = js.native
  // js.Function2[js.Any = js.native js.Any, js.Any]
  var transformRequest: js.Array[js.Function] = js.native
  // js.Function2[js.Any, js.Any, js.Any]
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
    val config = New[HttpConfig]
    config.method = method
    config.url = url
    config.params = params
    config.data = data
    config.headers = headers
    config.xsrfCookieName = xsrfCookieName
    config.xsrfHeaderName = xsrfHeaderName
    config.transformRequest = transformRequest
    config.transformResponse = transformResponse
    config.cache = cache
    config.withCredentials = withCredentials
    config.timeout = timeout
    config.responseType = responseType
    config
  }

}
