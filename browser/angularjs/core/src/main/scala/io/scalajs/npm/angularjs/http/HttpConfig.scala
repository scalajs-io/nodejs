package io.scalajs.npm.angularjs.http

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * AngularJS HTTP Service Configuration
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class HttpConfig(var method: js.UndefOr[String] = js.undefined,
                 var url: js.UndefOr[String] = js.undefined,
                 var params: js.UndefOr[js.Dictionary[js.Any]] = js.undefined,
                 var data: js.Any = js.undefined,
                 var headers: js.UndefOr[js.Dictionary[js.Any]] = js.undefined,
                 var xsrfHeaderName: js.UndefOr[String] = js.undefined,
                 var xsrfCookieName: js.UndefOr[String] = js.undefined,
                 var transformResponse: js.UndefOr[js.Array[js.Function]] = js.undefined,
                 // js.Function2[js.Any = js.undefined, js.Any, js.Any]
                 var transformRequest: js.UndefOr[js.Array[js.Function]] = js.undefined,
                 // js.Function2[js.Any, js.Any, js.Any]
                 var cache: js.Any = js.undefined,
                 var withCredentials: js.UndefOr[Boolean] = js.undefined,
                 var timeout: js.UndefOr[Int | Double] = js.undefined,
                 var responseType: js.UndefOr[String] = js.undefined)
    extends js.Object
