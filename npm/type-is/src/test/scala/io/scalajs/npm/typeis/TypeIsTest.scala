package io.scalajs.npm.typeis

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * TypeIs Test Suite
  * @author lawrence.daniels@gmail.com
  */
class TypeIsTest extends FunSpec {

  describe("TypeIs") {
    val mediaType = "application/json"

    it(s"""should resolve: is('$mediaType', ['json'])""") {
      test(mediaType, js.Array("json"), "json")
    }

    it(s"""should resolve: is('$mediaType', ['html', 'json'])""") {
      test(mediaType, js.Array("html", "json"), "json")
    }

    it(s"""should resolve: is('$mediaType', ['application/*'])""") {
      test(mediaType, js.Array("application/*"), "application/json")
    }

    it(s"""should resolve: is('$mediaType', ['application/json'])""") {
      test(mediaType, js.Array("application/json"), "application/json")
    }

    it(s"""should NOT resolve: is('$mediaType', ['html'])""") {
      test(mediaType, js.Array("html"), false)
    }

  }

  def test(mediaType: String, types: js.Array[String], expected: js.Any) {
    val actual = TypeIs.is(mediaType, types)
    info(s"""is("$mediaType", [${types.mkString(", ")}]) should be "$expected" ("$actual")""")
    Assert.equal(actual, expected)
  }

}
