package io.scalajs.npm.bignum

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.language.existentials

/**
  * BigNum Tests
  * @author lawrence.daniels@gmail.com
  */
class BigNumTest extends FunSpec {

  describe("BigNum") {
    val v1 = "782910138827292261791972728324982"
    val v2 = "182373273283402171237474774728373"

    it("supports math functions") {
      val b = new BigNum(v1).add(500).sub(v2).div(8)

      info(s"new BigNum('$v1').add(500).sub('$v2').div(8) = $b")
      Assert.equal(b.toString, "75067108192986261319312244199638")
    }

    it("supports math functions via operators") {
      val b = (new BigNum(v1) + 500 - v2) / 8

      info(s"(new BigNum('$v1') + 500 - '$v2')/8 = $b")
      Assert.equal(b.toString, "75067108192986261319312244199638")
    }

    it("supports prime number detection") {
      for {
        n <- 0 to 100
        p = BigNum.pow(2, n) - 1 if p.probPrime(50)
      } {
        val perfect = p.mul(BigNum.pow(2, n - 1))
        info(perfect.toString)
      }
    }

  }

}
