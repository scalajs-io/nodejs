package io.scalajs.npm.chalk

import org.scalatest.FunSpec

/**
  * Chalk Tests
  * @author lawrence.daniels@gmail.com
  */
class ChalkTest extends FunSpec {

  describe("Chalk") {

    it("should style a string") {
      info(Chalk.blue("Hello world!"))
    }

    it("should compose multiple styles using the chainable API") {
      info(Chalk.blue.bgRed.bold("Hello world!"))
    }

    it("should support passing in multiple arguments") {
      info(Chalk.blue("Hello", "World!", "Foo", "bar", "biz", "baz"))
    }

    it("should support nested styles") {
      info(Chalk.red("Hello", Chalk.underline.bgBlue("World") + "!"))
    }

    it("should support usage as a function") {
      val error = Chalk.bold.red
      info(error("Error!"))
    }

  }

}