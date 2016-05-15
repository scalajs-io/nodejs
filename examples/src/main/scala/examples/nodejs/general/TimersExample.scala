package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs._

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
