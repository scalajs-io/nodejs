package examples.nodejs.terminal

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import com.github.ldaniels528.meansjs.nodejs.tty.TTY

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
