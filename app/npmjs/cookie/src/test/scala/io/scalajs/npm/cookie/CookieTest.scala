package io.scalajs.npm.cookie

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Cookie Test Suite
  * @author lawrence.daniels@gmail.com
  */
class CookieTest extends FunSpec {

  describe("Cookie") {

    it("supports parsing cookies") {
      val cookies = Cookie.parse("foo=bar; equation=E%3Dmc%5E2")
      info(s"cookies => ${JSON.stringify(cookies)}")
      Assert.deepEqual(cookies, js.Dictionary("foo" -> "bar", "equation" -> "E=mc^2"))
    }

    it("supports serializing cookies") {
      val results = Cookie.serialize("foo", "bar")
      info(s"results => $results")
      Assert.equal(results, "foo=bar")
    }

  }

}
