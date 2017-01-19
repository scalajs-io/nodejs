package io.scalajs.npm.cookieparser

import io.scalajs.JSON
import io.scalajs.npm.express.Express
import org.scalatest.FunSpec

/**
  * Cookie-Parser Test Suite
  * @author lawrence.daniels@gmail.com
  */
class CookieParserTest extends FunSpec {

  describe("CookieParser") {

    it("supports processing cookies") {
      val app = Express()
      app.use(CookieParser("test123"))

      val results = CookieParser.JSONCookie("foo=bar; equation=E%3Dmc%5E2")
      info(s"cookies => ${JSON.stringify(results.orNull)}")
      //Assert.deepEqual(results, js.Dictionary("foo" -> "bar", "equation" -> "E=mc^2"))
    }

  }

}
