package examples.nodejs.basics

import com.github.ldaniels528.meansjs.nodejs.Require
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/**
  * Classes
  * @author lawrence.daniels@gmail.com
  */
class Classes(require: Require) {

  val ralph = new Person()
  ralph.name = "Ralph"
  ralph.age = 32

  console.log("ralph = %j", ralph)

}

@ScalaJSDefined
@JSName("Person")
class Person extends js.Object {
  var name: String = _
  var age: Int = _
}

