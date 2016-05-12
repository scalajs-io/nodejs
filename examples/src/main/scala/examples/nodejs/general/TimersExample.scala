package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs._
import org.scalajs.dom.console

import scala.concurrent.duration._

/**
  * Timers Example
  * @author lawrence.daniels@gmail.com
  */
class TimersExample(bootstrap: Bootstrap) {

  val immediate = setImmediate(() => console.log("Hello"))
  val delayed = setTimeout(() => console.log("World"), 1.second)

}
