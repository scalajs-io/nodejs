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

    it("""usage 1: should(user)""") {
      Should(user).have.property("name", "tj")
    }

    it("""usage 2: user.should""") {
      user.should.have.property("name", "tj")
    }

    it("verifies the length of an array") {
      Should(user).have.property("pets").`with`.lengthOf(4)
    }

    it("verifies null values") {
      Should(null).not.be.ok()
    }

    it("verifies existence") {
      Should.not.exist(null)
    }

    it("should allow expression chaining") {
      (5: js.Any).should.be.exactly(5).and.be.a.Number()
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
