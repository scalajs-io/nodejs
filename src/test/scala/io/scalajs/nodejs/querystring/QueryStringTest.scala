package io.scalajs.nodejs.querystring

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import io.scalajs.nodejs.querystring.QueryStringTest.MyParams
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Query String Test
  * @author lawrence.daniels@gmail.com
  */
class QueryStringTest extends FunSpec {

  describe("QueryString") {

    it("should escape(...)") {
      val result = QueryString.escape("""https://www.google.com/#q=node?key=1234""")
      info(s"result: ${JSON.stringify(result)}")
      assert(QueryString
        .escape("""https://www.google.com/#q=node?key=1234""") == "https%3A%2F%2Fwww.google.com%2F%23q%3Dnode%3Fkey%3D1234")
    }

    it("should parse(...)") {
      val result = QueryString.parse("""https://www.google.com/#q=node?key=1234""")
      info(s"result: ${JSON.stringify(result)}")
      Assert.deepEqual(result, js.Dictionary("https://www.google.com/#q" -> "node?key=1234"))
    }

    it("should stringify(...)") {
      val result = QueryString.stringify(new MyParams(foo = "1", bar = "2"))
      info(s"result: ${JSON.stringify(result)}")
      assert(result == "foo=1&bar=2")
    }

    it("should unescape(...)") {
      val result = QueryString.unescape("https%3A%2F%2Fwww.google.com%2F%23q%3Dnode%3Fkey%3D1234")
      info(s"result: ${JSON.stringify(result)}")
      assert(QueryString
        .unescape("https%3A%2F%2Fwww.google.com%2F%23q%3Dnode%3Fkey%3D1234") == """https://www.google.com/#q=node?key=1234""")
    }

  }

}

/**
  * Query String Test Companion
  * @author lawrence.daniels@gmail.com
  */
object QueryStringTest {

  @ScalaJSDefined
  class MyParams(val foo: String, val bar: String) extends js.Object

}
