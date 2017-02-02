package io.scalajs.npm.bcrypt

import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Bcrypt Tests
  * @author lawrence.daniels@gmail.com
  */
class BcryptTest extends FunSpec {

  describe("Bcrypt") {

    val saltRounds          = 13
    val myPlaintextPassword = "b@c0n"

    it("should encrypt data asynchronously via callbacks") {
      Bcrypt.hash(
        myPlaintextPassword,
        saltRounds,
        (_, hash) => {
          Bcrypt.compare(myPlaintextPassword, hash, (_, isMatch) => {
            info(s"callback: The password was a match: $isMatch")
            assert(isMatch)
          })
        }
      )
    }

    it("should encrypt data asynchronously via promises") {
      for {
        hash    <- Bcrypt.hash(myPlaintextPassword, saltRounds)
        isMatch <- Bcrypt.compare(myPlaintextPassword, hash)
      } {
        info(s"promise: The password was a match: $isMatch")
        assert(isMatch)
      }
    }

    it("should encrypt data synchronously") {
      val hash    = Bcrypt.hashSync(myPlaintextPassword, saltRounds)
      val isMatch = Bcrypt.compareSync(myPlaintextPassword, hash)
      info(s"The password was a match: $isMatch")
      assert(isMatch)
    }

  }

}
