package io.scalajs.nodejs.url

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class URLSearchParamsTest extends AnyFunSpec {
  describe("URLSearchParams") {
    it("should parse the string as a query string") {
      val params = new URLSearchParams("user=abc&query=xyz")
      assert(params.get("user") === "abc")
      assert(params.toString === "user=abc&query=xyz")
    }

    it("should parse the dictionary/object as a query string") {
      val params = new URLSearchParams(
        js.Dictionary(
          "user"  -> "abc",
          "query" -> js.Array("first", "second")
        )
      )
      assert(params.getAll("query").toSeq === Seq("first,second"))
    }

    it("should iterates over each name-value pair in the query and invokes the given function") {
      val myURL = new URL("https://example.org/?a=b&c=d")
      val array = js.Array[String]()
      myURL.searchParams.forEach((value, name, searchParams) => {
        array.push(s"${name}=${value}")
        assert(myURL.searchParams === searchParams)
      })
      assert(array(0) === "a=b")
      assert(array(1) === "c=d")
    }
  }
}
