package io.scalajs.util

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Maybe Test
  * @author lawrence.daniels@gmail.com
  */
class MaybeTest extends FunSpec {

  describe("Maybe[A]") {

    it("should mimic the behavior of js.UndefOr[A] for defined values") {
      val u: js.UndefOr[String] = "Hello"
      val m: Maybe[String] = "Hello"

      info("""val u: js.UndefOr[String] = "Hello"""")
      info("""val m: Maybe[String] = "Hello"""")
      info("u.toOption == m.toOption")
      assert(u.toOption == m.toOption)
    }

    it("should mimic the behavior of js.UndefOr[A] for undefined values") {
      val u: js.UndefOr[String] = js.undefined
      val m: Maybe[String] = js.undefined

      info("val u: js.UndefOr[String] = js.undefined")
      info("val m: Maybe[String] = js.undefined")
      info("u.toOption == m.toOption")
      assert(u.toOption == m.toOption)
    }

    it("should behavior differently than js.UndefOr[A] for null values") {
      val u: js.UndefOr[String] = null
      val m: Maybe[String] = null

      info("val u: js.UndefOr[String] = null")
      info("val m: Maybe[String] = null")
      info(s"u.toOption (${u.toOption}) != m.toOption (${m.toOption})")
      assert(u.toOption != m.toOption)
    }

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

    it("should be defined when a non-null value is referenced") {
      val maybe = Maybe(123456)
      info(s"Maybe(123456).get is 123456")
      assert(maybe.get == 123456)
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

    it("should support Maybe('A').isDefined is true") {
      assert(Maybe('A').isDefined)
    }

    it("""should support Maybe("S").isEmpty is false""") {
      assert(!Maybe("S").isEmpty)
    }

    it("should support Maybe(1.2).nonEmpty is true") {
      assert(Maybe(1.2).nonEmpty)
    }

    it("supports filter") {
      info("""Maybe("Hello").filter(_ == "Goodbye") == Empty""")
      assert(Maybe("Hello").filter(_ == "Goodbye") == Empty)

      info("""Maybe("Hello").filter(_ == "Goodbye") != Maybe("Hello")""")
      assert(Maybe("Hello").filter(_ == "Goodbye") != Maybe("Hello"))

      info("""Maybe("Hello").filter(_ == "Hello") == Maybe("Hello")""")
      assert(Maybe("Hello").filter(_ == "Hello") == Maybe("Hello"))
    }

    it("supports filterNot") {
      info("""Maybe("Hello").filterNot(_ == "Goodbye") == Maybe("Hello")""")
      assert(Maybe("Hello").filterNot(_ == "Goodbye") == Maybe("Hello"))

      info("""Maybe("Hello").filterNot(_ == "Goodbye") != Empty""")
      assert(Maybe("Hello").filterNot(_ == "Goodbye") != Empty)

      info("""Maybe("Hello").filterNot(_ == "Hello") == Empty""")
      assert(Maybe("Hello").filterNot(_ == "Hello") == Empty)
    }

  }

  def testMe(value: Maybe[String]): Unit = info(s"value is $value")

}
