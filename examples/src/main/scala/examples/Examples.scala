package examples

import com.github.ldaniels528.meansjs.nodejs.Require
import examples.nodejs.timers.IntermediateTimers

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

/**
  * MEANS.js Examples
  * @author lawrence.daniels@gmail.com
  */
@JSExportAll
object Examples extends js.JSApp {

  override def main(): Unit = ()

  def timers(require: Require): Unit = {
    new IntermediateTimers()
  }

}
