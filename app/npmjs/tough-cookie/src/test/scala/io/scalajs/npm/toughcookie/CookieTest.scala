package io.scalajs.npm.toughcookie

import io.scalajs.JSON
import org.scalatest.funspec.AnyFunSpec

/**
  * Cookie Tests
  * @author lawrence.daniels@gmail.com
  */
class CookieTest extends AnyFunSpec {

  describe("Cookie") {

    it("should parse cookie strings") {
      val cookie = Cookie.parse("key1=value1")
      info(s"cookie: ${JSON.stringify(cookie)}")
    }

  }

}
