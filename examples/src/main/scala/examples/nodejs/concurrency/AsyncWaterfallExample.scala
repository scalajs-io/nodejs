package examples.nodejs.concurrency

import com.github.ldaniels528.meansjs.nodejs.async.Async
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, errors}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.console

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Async Waterfall Example
  * @author lawrence.daniels@gmail.com
  */
class AsyncWaterfallExample(bootstrap: Bootstrap) {
  import bootstrap._

  val async = require[Async]("async")

  exampleA()

  def exampleA(): Unit = {
    async.waterfall(js.Array(
      (callback: js.Function3[errors.Error, String, String, Unit]) => callback(null, "one", "two"),

      // arg1 now equals "one" and arg2 now equals "two"
      (arg1: String, arg2: String, callback: js.Function2[errors.Error, String, Unit]) => callback(null, "three"),

      // arg1 now equals "three"
      (arg1: String, callback: js.Function2[errors.Error, String, Unit]) => callback(null, "done")
    ),
      (err: errors.Error, result: String) => {
        // result now equals "done"
        console.log("result = %s", result)
      })
  }

  def exampleB(): Unit = {
    async.waterfallFuture[String](js.Array(
      // start with two args
      (callback: js.Function3[errors.Error, String, String, Unit]) => callback(null, "one", "two"),

      // arg1 now equals "one" and arg2 now equals "two"
      (arg1: String, arg2: String, callback: js.Function2[errors.Error, String, Unit]) => callback(null, "three"),

      // arg1 now equals "three"
      (arg1: String, callback: js.Function2[errors.Error, String, Unit]) => callback(null, "done")
    )) foreach (result => console.log("result = %s", result))
  }

  def exampleC() {
    async.waterfallFuture[Int](js.Array(
      // start with n = 1
      (callback: js.Function2[errors.Error, Int, Any]) => callback(null, 1),

      // multiply by 2: n = n * 2
      (n: Int, callback: js.Function2[errors.Error, Int, Any]) => callback(null, n * 2),

      // multiply by 10: n = n * 10
      (n: Int, callback: js.Function2[errors.Error, Int, Any]) => callback(null, n * 10)
    )) foreach (n => console.log("n = %d", n))
  }

}
