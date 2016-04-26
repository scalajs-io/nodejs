package examples.nodejs.basics

import com.github.ldaniels528.meansjs.nodejs.{Require, process}
import org.scalajs.dom.console

/**
  * Process Play
  * @author lawrence.daniels@gmail.com
  */
class ProcessPlay(require: Require) {

  console.log("argv = %j", process.argv)

  val arg = process.argv.drop(2).headOption getOrElse "No arguments"
  console.log("port = %s", arg)

}
