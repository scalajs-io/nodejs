package io.scalajs.nodejs.vm

import io.scalajs.nodejs.vm.VMTest.{ExpectedData, Sandbox}
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * VM Tests
  * @author lawrence.daniels@gmail.com
  */
class VMTest extends FunSpec {

  describe("VM") {

    it("should compile and execute JavaScript code") {
      val sandbox = new Sandbox(animal = "cat", count = 2, name = "kitty")
      val expectedSet = Seq(
        ExpectedData(animal = "cat", count = 3, name = "kitty3"),
        ExpectedData(animal = "cat", count = 4, name = "kitty4"),
        ExpectedData(animal = "cat", count = 5, name = "kitty5"),
        ExpectedData(animal = "cat", count = 6, name = "kitty6"),
        ExpectedData(animal = "cat", count = 7, name = "kitty7"),
        ExpectedData(animal = "cat", count = 8, name = "kitty8"),
        ExpectedData(animal = "cat", count = 9, name = "kitty9"),
        ExpectedData(animal = "cat", count = 10, name = "kitty10"),
        ExpectedData(animal = "cat", count = 11, name = "kitty11"),
        ExpectedData(animal = "cat", count = 12, name = "kitty12")
      )

      val script  = VM.createScript("""count += 1; name = "kitty" + count""")
      val context = VM.createContext(sandbox)
      expectedSet foreach {
        case ExpectedData(animal, count, name) =>
          script.runInContext(context)
          assert(sandbox.animal == animal && sandbox.count == count && sandbox.name == name)
      }
    }

    it("should compile and execute JavaScript code in a custom context") {
      val sandbox = new Sandbox(animal = "cat", count = 2, name = "kitty")
      VM.runInNewContext("""count += 1; name = "kitty"""", sandbox)
      assert(sandbox.animal == "cat" && sandbox.count == 3 && sandbox.name == "kitty")
    }

  }

}

/**
  * VM Test Companion
  * @author lawrence.daniels@gmail.com
  */
object VMTest {

  /**
    * Sandbox Object
    */
  @ScalaJSDefined
  class Sandbox(var animal: String, var count: Int, var name: String) extends js.Object

  case class ExpectedData(animal: String, count: Int, name: String)

}
