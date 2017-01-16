package io.scalajs

import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * JSON Test
  * @author lawrence.daniels@gmail.com
  */
class JSONTest extends FunSpec {

  describe("JSON") {

    it("""should parse '"true"'""") {
      assert(JSON.parseAs[Boolean]("true"))
    }

    it("""should parse '"foo"'""") {
      assert(JSON.parseAs[String]("\"foo\"") == "foo")
    }

    it("should parse '[1, 5, 7]'") {
      val values = JSON.parseAs[js.Array[Int]]("""[1, 5, 7]""")
      assert(values.sum == js.Array(1, 5, 7).sum)
    }

    it("""should parse 'null'""") {
      assert(JSON.parse("null") == null)
    }

    it("""should parse '{"name":"x", "value":5}'""") {
      val result = JSON.parseAs[KeyValuePair]("""{"name":"x", "value":5}""")
      assert(result.name == "x" && result.value == 5)
    }

    it("""should parse '{"x":5}' using a custom reviver""") {
      val result = JSON.parseAs[js.Object]("""{"x":5}""", { (key: js.Any, value: js.Any) => value }: js.Function)
      assert(JSON.stringify(result) == """{"x":5}""")
    }

    it("""should convert value 'true' to a JSON string""") {
      assert(JSON.stringify(true) == "true")
    }

    it("""should convert array '[1, "false", false]' to a JSON string""") {
      assert(JSON.stringify(js.Array(1, "false", false)) == """[1,"false",false]""")
    }

    it("""should convert object '{}' to a JSON string""") {
      assert(JSON.stringify(new js.Object()) == "{}")
    }

    it("""should convert object '{"x":5}' to a JSON string""") {
      val result = JSON.stringify(new js.Object {
        val x = 5
      })
      assert(result == """{"x":5}""")
    }

  }

  @ScalaJSDefined
  class KeyValuePair(val name: String, val value: Int) extends js.Object

}
