package io.scalajs.npm.request

import io.scalajs.nodejs.http.ServerResponse
import org.scalatest.FunSpec

/**
  * Request Tests
  * @author lawrence.daniels@gmail.com
  */
class RequestTest extends FunSpec {

  describe("Request") {

    it("should support asynchronous execution") {
      Request("http://www.google.com", (error: String, response: ServerResponse, body: String) => {
        assert(error == null)
        assert(response.statusCode == 200)
      })
    }

    it("should support streaming execution") {
      Request
        .get("http://google.com/img.png")
        .on("response", (response: ServerResponse) => {
          assert(response.statusCode == 200)
          assert(response.headers.get("content-type").contains("image/png"))
        })
        .pipe(Request.put("http://mysite.com/img.png"))
    }

  }

}
