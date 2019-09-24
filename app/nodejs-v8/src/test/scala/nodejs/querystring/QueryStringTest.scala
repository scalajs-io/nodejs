package io.scalajs.nodejs.querystring

import io.scalajs.nodejs.Assert
import io.scalajs.nodejs.querystring.QueryStringTest.MyParams
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Query String Test
  */
class QueryStringTest extends FunSpec {

  describe("QueryString") {

    it("should escape(...)") {
      val result = QueryString.escape("""https://www.google.com/#q=node?key=1234""")
      assert(result === "https%3A%2F%2Fwww.google.com%2F%23q%3Dnode%3Fkey%3D1234")
    }

    it("should parse(...)") {
      val result = QueryString.parse("""https://www.google.com/#q=node?key=1234""")
      Assert.deepEqual(result, js.Dictionary("https://www.google.com/#q" -> "node?key=1234"))
    }

    it("should stringify(...)") {
      val result = QueryString.stringify(new MyParams(foo = "1", bar = "2"))
      assert(result === "foo=1&bar=2")
    }

    it("should unescape(...)") {
      val result = QueryString.unescape("https%3A%2F%2Fwww.google.com%2F%23q%3Dnode%3Fkey%3D1234")
      assert(result === """https://www.google.com/#q=node?key=1234""")
    }
  }

  describe("QueryStringEnrichment") {
    it("parseAs") {
      val result: MyParams = QueryString.parseAs("foo=1&bar=2")
      assert(result.foo === "1")
      assert(result.bar === "2")
    }
  }
}

/**
  * Query String Test Companion
  */
object QueryStringTest {

  class MyParams(val foo: String, val bar: String) extends js.Object

}
