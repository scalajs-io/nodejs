package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/**
  * Classes
  * @author lawrence.daniels@gmail.com
  */
class Classes(bootstrap: Bootstrap) {

  val larry = new Person1()
  larry.name = "Larry"
  larry.age = 40
  console.log("Larry = %j", larry)

  val curly = new Person2("Curly", 41)
  console.log("Curly = %j", curly)

  val moe = new Person3("Moe")
  console.log("Moe = %j", moe)
}

@ScalaJSDefined
@JSName("Person")
class Person1 extends js.Object {
  var name: String = _
  var age: Int = _
}

@ScalaJSDefined
@JSName("Person")
class Person2(var name: String, var age: Int) extends js.Object

@ScalaJSDefined
@JSName("Person")
class Person3(var name: js.UndefOr[String] = js.undefined, var age: js.UndefOr[Int] = js.undefined) extends js.Object