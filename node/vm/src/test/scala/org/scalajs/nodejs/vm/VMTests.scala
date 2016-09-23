package org.scalajs.nodejs.vm

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.util.JSONHelper._
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

import scala.scalajs.js

/**
  * VM Tests
  * @author lawrence.daniels@gmail.com
  */
object VMTests extends TestSuite {

  override val tests = this {
    val vm = VM()
    val sandbox = Sandbox(animal = "cat", count = 2)

    "vm.createScript()" - {
      "createScript() should compile and execute JavaScript code" - {
        val expectedSet = Seq(
          """{"animal":"cat","count":3,"name":"kitty3"}""",
          """{"animal":"cat","count":4,"name":"kitty4"}""",
          """{"animal":"cat","count":5,"name":"kitty5"}""",
          """{"animal":"cat","count":6,"name":"kitty6"}""",
          """{"animal":"cat","count":7,"name":"kitty7"}""",
          """{"animal":"cat","count":8,"name":"kitty8"}""",
          """{"animal":"cat","count":9,"name":"kitty9"}""",
          """{"animal":"cat","count":10,"name":"kitty10"}""",
          """{"animal":"cat","count":11,"name":"kitty11"}""",
          """{"animal":"cat","count":12,"name":"kitty12"}"""
        )

        val script = vm.createScript("""count += 1; name = "kitty" + count""")
        val context = vm.createContext(sandbox)
        expectedSet foreach { expected =>
          script.runInContext(context)
          sandbox.toJson ==> expected
        }
      }
    }

    "vm.runInNewContext()" - {
      "runInNewContext() should compile and execute JavaScript code in a custom context" - {
        vm.runInNewContext("""count += 1; name = "kitty"""", sandbox)
        sandbox.toJson ==> """{"animal":"cat","count":3,"name":"kitty"}"""
      }
    }

  }

  /**
    * Sandbox Object
    */
  @js.native
  trait Sandbox extends js.Object {
    var animal: String = js.native
    var count: Int = js.native
  }

  object Sandbox {

    def apply(animal: String, count: Int) = {
      val sandbox = New[Sandbox]
      sandbox.animal = animal
      sandbox.count = count
      sandbox
    }
  }

}
