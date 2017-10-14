package io.scalajs.nodejs.url

import io.scalajs.nodejs.console
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * URLSearchParams Tests
  * @author lawrence.daniels@gmail.com
  */
class URLSearchParamsTest extends FunSpec {

  describe("URLSearchParams") {

    it("should parse the string as a query string") {
      val params = new URLSearchParams("user=abc&query=xyz")
      info(params.get("user")) // Prints "abc"
      assert(params.get("user") == "abc")

      info(params.toString) // Prints "user=abc&query=xyz"
      assert(params.toString == "user=abc&query=xyz")
    }

    it("should parse the dictionary/object as a query string") {
      val params = new URLSearchParams(js.Dictionary(
        "user" -> "abc",
        "query" -> js.Array("first", "second")
      ))
      info(params.getAll("query").mkString(", ")) // Prints [ "first,second" ]
      assert(params.getAll("query") == js.Array("first,second"))
    }

    it("should iterates over each name-value pair in the query and invokes the given function") {
      val myURL = new URL("https://example.org/?a=b&c=d")
      myURL.searchParams.forEach((value, name, searchParams) => {
        console.log(name, value, myURL.searchParams === searchParams)
      })
    }

  }

}
