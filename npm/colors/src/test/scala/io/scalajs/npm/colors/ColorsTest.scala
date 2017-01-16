package io.scalajs.npm.colors

import io.scalajs.nodejs.console
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Colors Test Suite
  * @author lawrence.daniels@gmail.com
  */
class ColorsTest extends FunSpec {

  describe("Colors") {

    it("should detect whether the console supports ANSI colors") {
      info(s"supports color? ${Colors.supportsColor}")
    }

    it("should indicate whether colors (module) is enabled") {
      info(s"is colors enabled? ${Colors.enabled}")
    }

    it("should support direct method calls") {
      console.log(Colors.green("hello")) // outputs green text
      console.log(Colors.red.underline("i like cake and pies")) // outputs red underlined text
      console.log(Colors.inverse("inverse the color")) // inverses the color
      console.log(Colors.rainbow("OMG Rainbows!")) // rainbow
      console.log(Colors.trap("Run the trap")) // Drops the bass
    }

    it("should support implicit method calls") {
      console.log("hello".green) // outputs green text
      console.log("i like cake and pies".underline.red) // outputs red underlined text
      console.log("inverse the color".inverse) // inverses the color
      console.log("OMG Rainbows!".rainbow) // rainbow
      console.log("Run the trap".trap) // Drops the bass
    }

    it("should support themes") {
      Colors.setTheme(js.Dictionary(
        "silly" -> "rainbow",
        "input" -> "grey",
        "verbose" -> "cyan",
        "prompt" -> "grey",
        "info" -> "green",
        "data" -> "grey",
        "help" -> "cyan",
        "warn" -> "yellow",
        "debug" -> "blue",
        "error" -> "red"
      ))

      // outputs red text
      console.log("this is an error" <<= "error")

      // outputs yellow text
      console.log("this is a warning" <<= "warn")
    }

  }

}
