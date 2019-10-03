package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait ClientHttp2Session extends Http2Session {

  def request(headers: Http2Headers, options: Http2RequestOptions = js.native): ClientHttp2Stream = js.native
}
