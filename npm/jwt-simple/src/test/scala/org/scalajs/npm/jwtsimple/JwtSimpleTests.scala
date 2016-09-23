package org.scalajs.npm
package jwtsimple

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import utest._

import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * Jwt-Simple Tests
  * @author lawrence.daniels@gmail.com
  */
object JwtSimpleTests extends TestSuite {

  override val tests = this {

    "jwt-simple should create JWT tokens and encrypt JSON payloads" - {
      val jwt = JwtSimple()
      val payload = js.Dictionary("foo" -> "bar")
      val secret = "scalajs"

      // encode
      val token = jwt.encode(payload, secret)
      console.log("token: ", token)
      assert(token == "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmb28iOiJiYXIifQ.GmVaWnUkI1glyMfggMz6u4T-8I5KPfk8Kmc4PxKJz50")

      // decode
      val decoded = jwt.decode(token, secret)
      console.log("payload: ", decoded) //=> { foo: "bar" }
      assert(JSON.stringify(decoded) == """{"foo":"bar"}""")
    }

  }

}
