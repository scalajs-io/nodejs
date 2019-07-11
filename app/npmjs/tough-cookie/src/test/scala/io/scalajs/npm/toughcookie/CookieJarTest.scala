package io.scalajs.npm.toughcookie

import io.scalajs.JSON
import org.scalatest.funspec.AnyFunSpec

/**
  * CookieJar Tests
  * @author lawrence.daniels@gmail.com
  */
class CookieJarTest extends AnyFunSpec {

  describe("CookieJar") {

    it("should create cookie jars") {
      val url = "http://scalajs-io"
      val cookieJar = new CookieJar()
      cookieJar.setCookie(Cookie.parse("key1=value1"), url, (err, cookie) => info(s"cookie1: ${JSON.stringify(cookie)}"))
      cookieJar.setCookie(Cookie.parse("key2=value2"), url, (err, cookie) => info(s"cookie2: ${JSON.stringify(cookie)}"))
      cookieJar.getCookieString(url, (err, cookieString) => info(s"cookieString: $cookieString"))
      cookieJar.getCookies(url, (err, cookies) => info(s"cookies: ${JSON.stringify(cookies)}"))
    }

  }

}
