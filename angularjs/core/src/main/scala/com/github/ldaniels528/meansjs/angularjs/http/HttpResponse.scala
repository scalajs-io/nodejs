package com.github.ldaniels528.meansjs.angularjs.http

import scala.scalajs.js

/**
  * HTTP Response
  * The response object has these properties:
  * <ul>
  * <li>data – {string|Object} – The response body transformed with the transform functions.</li>
  * <li>status – {number} – HTTP status code of the response.</li>
  * <li>headers – {function([headerName])} – Header getter function.</li>
  * <li>config – {Object} – The configuration object that was used to generate the request.</li>
  * <li>statusText – {string} – HTTP status text of the response.</li>
  * </ul>
  */
@js.native
trait HttpResponse[T] extends js.Object {
  var status: Int = js.native
  var statusText: String = js.native
  var data: T = js.native
  var config: HttpConfig = js.native

  def headers(name: String): String = js.native

}
