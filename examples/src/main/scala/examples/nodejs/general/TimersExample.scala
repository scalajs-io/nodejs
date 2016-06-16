package examples.nodejs.general

import org.scalajs.nodejs._
import org.scalajs.nodejs.Bootstrap

import scala.concurrent.duration._

/**
  * Timers Example
  * @author lawrence.daniels@gmail.com
  */
class TimersExample(bootstrap: Bootstrap) {

  setImmediate(() => console.log("Hello"))

  setTimeout(() => console.log("\tWorld"), 0.5.second)

  setTimeout(() => console.log("\t\tfrom MEANS.js"), 1.second)

}
