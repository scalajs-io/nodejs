package io.scalajs.npm.minimist

import io.scalajs.nodejs.Assert
import io.scalajs.util.JSONHelper._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

/**
  * Minimist Tests
  * @author lawrence.danils@gmail.com
  */
class MinimistTest extends AnyFunSpec {

  describe("Minimist") {

    it("supports") {
      val result = Minimist("-a beep -b boop".split(' '))
      info(s"result: ${result.toJson}")
      //=> result: {"_":[],a:"beep",b:"boop"}

      Assert.deepEqual(result, js.Dictionary("_" -> js.Array(), "a" -> "beep", "b" -> "boop"))
    }

    it("supports flag arguments with values") {
      val result = Minimist("-x 3 -y 4 -n5 -abc --beep=boop foo bar baz".split(' '))
      info(s"result: ${result.toJson}")
      //=> result: {"_":["foo","bar","baz"],"x":3,"y":4,"n":5,"a":true,"b":true,"c":true,"beep":"boop"}

      Assert.deepEqual(result, js.Dictionary("_" -> js.Array("foo", "bar", "baz"), "x" -> 3, "y" -> 4, "n" -> 5, "a" -> true, "b" -> true, "c" -> true, "beep" -> "boop"))
    }

    it("supports parsing arguments with a grouping delimiter") {
      val result = Minimist("one two three -- four five --six".split(' '), new MinimistOptions().withDelimiter())
      info(s"result: ${result.toJson}")
      //=> {"_":["one","two","three"],"--":["four","five","--six"]}

      Assert.deepEqual(result, js.Dictionary("_" -> js.Array("one", "two", "three"), "--" -> js.Array("four", "five", "--six")))
    }
  }

}
