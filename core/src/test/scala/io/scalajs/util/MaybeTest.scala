package io.scalajs.util

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Maybe Test
  * @author lawrence.daniels@gmail.com
  */
class MaybeTest extends FunSpec {

  describe("Maybe") {

    it("should allow passing undefined as Maybe[A]") {
      testMe(js.undefined)
    }

    it("should allow passing a value as Maybe[A]") {
      testMe("Hello World")
    }

    it("should implicitly convert Option[A] to Maybe[A]") {
      val value: Maybe[Int] = None
      info(s"value is $value")
    }

    it("should implicitly convert js.UndefOr[A] to Maybe[A]") {
      val value: Maybe[Int] = js.undefined
      info(s"value is $value")
    }

    it("should be Full when a non-null defined value is referenced") {
      val maybe = Maybe(123456)
      info(s"Maybe(123456) is $maybe")
      assert(maybe == Full(123456))
    }

    it("should be Empty when a null value is referenced") {
      val maybe = Maybe(null)
      info(s"Maybe(null) is $maybe")
      assert(maybe == Empty)
    }

    it("should be Empty when an undefined value is referenced") {
      val maybe = Maybe(js.undefined)
      info(s"Maybe(undefined) is $maybe")
      assert(maybe == Empty)
    }

    it("should enforce Empty.isEmpty is true") {
      assert(Empty.isEmpty)
    }

    it("should enforce Empty.nonEmpty is false") {
      assert(!Empty.nonEmpty)
    }

    it("should enforce Full.isDefined is true") {
      assert(Full('A').isDefined)
    }

    it("should enforce Full.isEmpty is false") {
      assert(!Full("S").isEmpty)
    }

    it("should enforce Full.nonEmpty is true") {
      assert(Full(1.2).nonEmpty)
    }

  }

  def testMe(value: Maybe[String]): Unit = info(s"value is $value")

}
