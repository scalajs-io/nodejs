package examples.nodejs.timers

import com.github.ldaniels528.meansjs.nodejs._
import org.scalajs.dom.console

/**
  * Intermediate Timers
  * @author lawrence.daniels@gmail.com
  */
class IntermediateTimers(require: Require) {

  val timer = setImmediate(() => console.log("Hello"))

}
