package io.scalajs.npm.should

import io.scalajs.npm.should.ShouldTest.UserWithPets
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Should Test
  * @author lawrence.daniels@gmail.com
  */
class ShouldTest extends FunSpec {

  describe("Should") {

    val user = new UserWithPets(name = "tj", pets = js.Array("tobi", "loki", "jane", "bandit"))

    it("should accept: Should(user)") {
      //Should(user).have.property("name", "tj")
    }

    it("should accept: user.should") {
      //user.should.have.property("name", "tj")
    }

    it("should determine the length of an array") {
      //Should(user).have.property("pets").`with`.lengthOf(4)
    }

    it("should detect null values") {
      //Should(null).not.be.ok()
    }

    it("should determine existence") {
      //Should.not.exist(null)
    }

    it("should allow expression chaining") {
      //5.should.be.exactly(5).and.be.a.Number()
    }

  }

}

/**
  * Should Test Companion
  * @author lawrence.daniels@gmail.com
  */
object ShouldTest {

  @ScalaJSDefined
  class UserWithPets(val name: String, val pets: js.Array[String]) extends js.Object

}
