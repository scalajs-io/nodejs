package io.scalajs.nodejs.http2

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class Http2HeadersTest extends AnyFunSpec {
  describe("Http2Headers") {
    it("should treat JS name") {
      val headers = Http2Headers.forIncoming(
        status = "200",
        accessControlMaxAge = "1"
      )
      assert(headers.status === "200")
      assert(js.JSON.stringify(headers) === """{":status":"200","access-control-max-age":"1"}""")
    }

    it("should support user-defined keys") {
      val headers = Http2Headers.forIncoming(status = "300")
      headers.update("ABC", js.Array("X", "Y", "Z"))
      assert(js.JSON.stringify(headers) === """{":status":"300","ABC":["X","Y","Z"]}""")
      assert(headers("ABC").toString === "X,Y,Z")
    }
  }
}
