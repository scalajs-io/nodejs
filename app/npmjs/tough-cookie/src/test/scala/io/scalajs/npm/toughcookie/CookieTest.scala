package io.scalajs.npm.toughcookie

import io.scalajs.JSON
import org.scalatest.FunSpec

/**
  * Cookie Tests
  * @author lawrence.daniels@gmail.com
  */
class CookieTest extends FunSpec {

  describe("Cookie") {

    it("should parse cookie strings") {
      val cookie = Cookie.parse("key1=value1")
      info(s"cookie: ${JSON.stringify(cookie)}")
    }

  }

}
