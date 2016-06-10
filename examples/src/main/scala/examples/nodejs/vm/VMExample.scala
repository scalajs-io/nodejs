package examples.nodejs.vm

import com.github.ldaniels528.meansjs.nodejs.util.Util
import com.github.ldaniels528.meansjs.nodejs.vm.VM
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import examples.nodejs.vm.VMExample.Sandbox

import scala.scalajs.js

/**
  * VM Example
  * @author lawrence.daniels@gmail.com
  */
class VMExample(bootstrap: Bootstrap) {
  import bootstrap._

  val util = require[Util]("util")
  val vm = require[VM]("vm")

  val sandbox = Sandbox(animal = "cat", count = 2)

  example1()

  def example1(): Unit = {
    val script = vm.createScript("""count += 1; name = "kitty" + count""")
    val context = vm.createContext(sandbox)
    for (i <- 0 until 10) {
      script.runInContext(context)
      console.log(util.inspect(sandbox))
    }
    /*
      { animal: 'cat', count: 3, name: 'kitty3' }
      { animal: 'cat', count: 4, name: 'kitty4' }
      { animal: 'cat', count: 5, name: 'kitty5' }
      { animal: 'cat', count: 6, name: 'kitty6' }
      { animal: 'cat', count: 7, name: 'kitty7' }
      { animal: 'cat', count: 8, name: 'kitty8' }
      { animal: 'cat', count: 9, name: 'kitty9' }
      { animal: 'cat', count: 10, name: 'kitty10' }
      { animal: 'cat', count: 11, name: 'kitty11' }
     */
  }

  def example2(): Unit = {
    vm.runInNewContext("""count += 1; name = "kitty"""", sandbox)
    console.log(util.inspect(sandbox))
    // { animal: "cat", count: 3, name: "kitty" }
  }

}

/**
  * VM Example Companion
  * @author lawrence.daniels@gmail.com
  */
object VMExample {

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
