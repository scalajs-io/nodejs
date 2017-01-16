package io.scalajs.npm.numeral

import org.scalatest.FunSpec

/**
  * Numeral Tests
  * @author lawrence.daniels@gmail.com
  */
class NumeralTest extends FunSpec {

  describe("Numeral") {

    it("supports '-76%'") {
      convert("-76%", -0.76)
    }

    it("supports '23rd'") {
      convert("23rd", 23)
    }

    it("supports number formats") {
      convert("1000", 1000)
      convert("1,000", 1000)
      format(1000, "0,0", "1,000")
    }

    it("supports currency formats") {
      format(1000.234, "$0,0.00", "$1,000.23")
    }

    it("supports byte formats") {
      convert("3.467TB", 3467000000000d)
      format(7884486213d, "0.00b", "7.88GB")
    }

    it("supports durations") {
      format(238, "00:00:00", "0:03:58")
    }

    it("supports math functions") {
      Seq("+", "-", "*", "/") foreach (math(_, 5, 2))
    }

  }

  private def convert(input: String, output: Double) {
    info(s"'$input' should become $output")
    assert(Numeral(input).value() == output)
  }

  private def format(value: Double, formatString: String, expected: String) {
    info(s"$value should become '$expected'")
    val actual = Numeral(value).format(formatString)
    assert(actual == expected)
  }

  private def math(operator: String, a: Double, b: Double) {
    val aa = Numeral(a)
    val bb = Numeral(b)
    val (expected, actual) = operator match {
      case "+" => (aa + bb, a + b)
      case "-" => (aa - bb, a - b)
      case "*" => (aa * bb, a * b)
      case "/" => (aa / bb, a / b)
      case _ =>
        throw new IllegalArgumentException(s"Unrecognized operator $operator")
    }
    info(s"Numeral($a) $operator Numeral($b) should equal $expected")
    assert(actual == expected)
  }

}
