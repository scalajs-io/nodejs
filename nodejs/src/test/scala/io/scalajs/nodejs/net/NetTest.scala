package io.scalajs.nodejs.net

import io.scalajs.nodejs.console
import io.scalajs.nodejs.repl.REPL
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Network (Net) Tests
  * @author lawrence.daniels@gmail.com
  */
class NetTest extends FunSpec {

  describe("Net") {

    it("provides client-server connectivity") {
      // startup the server
      val server = Net.createServer((socket: Socket) => {
        socket.write("Echo server\r\n")
        socket.pipe(socket)
      })

      server.listen(4889, "127.0.0.1")

      // startup the client
      val client = new Socket()
      client.connect(4889, "127.0.0.1", { () =>
        console.log("Connected")
        client.write("Hello, server! Love, Client.")
      })

      client.onData { data =>
        console.log("Received: " + data)
        client.destroy() // kill client after server"s response

      } onClose { hadError =>
        console.log("Connection closed: state =>", hadError)
      }
    }

    it("can provide REPL-like functionality") {
      val mood = () => {
        val m = js.Array("^__^", "-___-", ">.<", "<_>")
        m(Math.floor(Math.random() * m.length).toInt)
      }

      //A remote node repl that you can telnet to!
      Net
        .createServer((socket: Socket) => {
          val remote = REPL.start("node::remote> ", socket)
          //Adding "mood" and "bonus" to the remote REPL's context.
          remote.context.mood = mood
          remote.context.bonus = "UNLOCKED"
        })
        .listen(5001)

      info("Remote REPL started on port 5001.")

      //A "local" node repl with a custom prompt
      val local = REPL.start("node::local> ")

      // Exposing the function "mood" to the local REPL's context.
      local.context.mood = mood
    }

  }

}
