package examples.nodejs.terminal

import org.scalajs.nodejs._
import org.scalajs.nodejs.net._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.net.{Net, Socket}
import org.scalajs.nodejs.repl.REPL

import scala.scalajs.js

/**
  * REPL Example
  * @author lawrence.daniels@gmail.com
  * @see https://docs.nodejitsu.com/articles/REPL/how-to-create-a-custom-repl
  */
class REPLExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val net = Net()
  val repl = REPL()

  val mood = () => {
    val m = js.Array("^__^", "-___-", ">.<", "<_>")
    m(Math.floor(Math.random() * m.length).toInt)
  }

  //A remote node repl that you can telnet to!
  net.createServer((socket: Socket) => {
    val remote = repl.start("node::remote> ", socket)
    //Adding "mood" and "bonus" to the remote REPL's context.
    remote.context.mood = mood
    remote.context.bonus = "UNLOCKED"
  }).listen(5001)

  console.log("Remote REPL started on port 5001.")

  //A "local" node repl with a custom prompt
  var local = repl.start("node::local> ")

  // Exposing the function "mood" to the local REPL's context.
  local.context.mood = mood
}
