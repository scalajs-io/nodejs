package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.util.Util
import examples.nodejs.general.ClassesExample._
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Classes Example
  * @author lawrence.daniels@gmail.com
  */
class ClassesExample(bootstrap: Bootstrap) {
  import bootstrap._

  val util = require[Util]("util")

  val larry = new Person1()
  larry.name = "Larry"
  //larry.age = 40
  console.log("larry: %j, inspect: %s, type: %s", larry, util.inspect(larry), js.typeOf(larry))

  val curly = new Person2("Curly", 41)
  console.log("curly: %j, inspect: %s, type; %s", curly, util.inspect(curly), js.typeOf(curly))

  val moe = new Person3("Moe")
  console.log("moe: %j, inspect: %s, type; %s", moe, util.inspect(moe), js.typeOf(moe))

  val shemp = new Person4 {
    override val name = "Shemp"
    override val age = 48
  }
  console.log("shemp: %j, inspect: %s, type; %s", shemp, util.inspect(shemp), js.typeOf(shemp))
}

/**
  * Classes Example Companion
  * @author lawrence.daniels@gmail.com
  */
object ClassesExample {

  @ScalaJSDefined
  class Person1 extends js.Object {
    var name: String = _
    var age: Integer = _
  }

  @ScalaJSDefined
  class Person2(val name: String, val age: Int) extends js.Object

  @ScalaJSDefined
  class Person3(val name: js.UndefOr[String] = js.undefined, val age: js.UndefOr[Int] = js.undefined) extends js.Object

  @ScalaJSDefined
  trait Person4 extends js.Object {

    def name: String

    def age: Int

  }

}