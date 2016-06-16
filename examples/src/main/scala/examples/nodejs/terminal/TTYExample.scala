package examples.nodejs.terminal

import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.tty.TTY

/**
  * TTY Example
  * @author lawrence.daniels@gmail.com
  */
class TTYExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val tty = require[TTY]("tty")

  val writer = tty.WriteStream
  console.log("", writer)

}
