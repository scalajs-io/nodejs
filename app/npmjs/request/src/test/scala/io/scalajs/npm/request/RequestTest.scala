package io.scalajs.npm.request

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.scalajs.js.JSConverters._

/**
  * Request Tests
  * @author lawrence.daniels@gmail.com
  */
class RequestTest extends FunSpec {

  describe("Request") {

    it("should support asynchronous execution") {
      Request("http://www.google.com", { (error, response, body) =>
        Assert.equal(error, null, JSON.stringify(error))
        Assert.equal(response.statusCode, 200, response.statusMessage)
      })
    }

    it("should support streaming execution") {
      Request
        .get("http://apache.org/img/asf_logo.png")
        .onResponse { response =>
          Assert.equal(response.statusCode, 200, response.statusMessage)
          Assert.equal(response.headers.get("content-type").orUndefined, "image/png", "Content type was not 'image/png'")
        }
        .pipe(Request.put("http://mysite.com/img.png"))
    }

    it("should create cookies") {
      val cookie = Request.cookie("key1=value1")
      info(s"cookie: ${JSON.stringify(cookie)}")
    }

    it("should create cookie jars") {
      val url = "http://scalajs-io"
      val cookieJar = Request.jar()
      cookieJar.setCookie(Request.cookie("key1=value1"), url)
      info(s"cookie string: ${cookieJar.getCookieString(url)}")
      info(s"cookies: ${JSON.stringify(cookieJar.getCookies(url))}")
    }

  }

}
