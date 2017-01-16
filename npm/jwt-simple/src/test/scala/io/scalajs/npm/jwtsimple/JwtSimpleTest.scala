package io.scalajs
package npm
package jwtsimple

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Jwt-Simple Tests
  * @author lawrence.daniels@gmail.com
  */
class JwtSimpleTest extends FunSpec {

  describe("JwtSimple") {

    it("should create JWT tokens and encrypt JSON payloads") {
      val payload = js.Dictionary("foo" -> "bar")
      val secret = "scalajs"

      // encode
      val token = JwtSimple.encode(payload, secret)
      info(s"token: $token")
      assert(token == "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmb28iOiJiYXIifQ.GmVaWnUkI1glyMfggMz6u4T-8I5KPfk8Kmc4PxKJz50")

      // decode
      val decoded = JwtSimple.decode(token, secret)
      info(s"payload: ${JSON.stringify(decoded)}") //=> { foo: "bar" }
      assert(JSON.stringify(decoded) == """{"foo":"bar"}""")
    }

  }

}
