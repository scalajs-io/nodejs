package examples.nodejs.timers

import com.github.ldaniels528.meansjs.nodejs._
import org.scalajs.dom.console

import scala.concurrent.duration._

/**
  * Intermediate Timers
  * @author lawrence.daniels@gmail.com
  */
class IntermediateTimers(require: Require) {

  val immediate = setImmediate(() => console.log("Hello"))
  val delayed = setTimeout(() => console.log("World"), 1.second)

}
