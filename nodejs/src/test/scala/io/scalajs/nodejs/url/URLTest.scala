package io.scalajs.nodejs.url

import io.scalajs.util.JSONHelper._
import io.scalajs.util.JsUnderOrHelper._
import org.scalatest._

/**
  * URL Tests
  * @author lawrence.daniels@gmail.com
  */
class URLTest extends FunSpec {

  describe("URL") {

    val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
    val parsedUrl   = URL.parse(originalUrl)

    it("should break down URLs into components") {
      assert(
        parsedUrl.toJson == """{"protocol":"https:","slashes":true,"auth":null,"host":"www.google.com","port":null,"hostname":"www.google.com","hash":"#q=node","search":"?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","query":"sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","pathname":"/webhp","path":"/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","href":"https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"}""")
    }

    it("should be properly extracted") {
      assert(parsedUrl.query ?== "sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8")
    }

    it("should properly extract the search query") {
      assert(parsedUrl.search ?== "?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8")
    }

    it("should reconstituted the URL to match the original") {
      assert(URL.format(parsedUrl) == originalUrl)
    }

  }

}
