package io.scalajs.nodejs.net

import io.scalajs.nodejs.repl.REPL
import io.scalajs.nodejs.{console, setTimeout, _}
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Network (Net) Tests
  * @author lawrence.daniels@gmail.com
  */
class NetTest extends FunSpec {

  describe("Net") {

    /*
    it("provides client-server connectivity") {
      val port = 53889

      // startup the server
      val server = Net.createServer((socket: Socket) => {
        socket.write("Echo server\r\n")
        socket.pipe(socket)
      })

      //server.listen(port, "127.0.0.1")
      //setTimeout(() => server.close(), 1.second)

      // startup the client
      val client = new Socket()
      client.connect(port, "127.0.0.1", { () =>
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
      val port = 53888

      val mood = () => {
        val m = js.Array("^__^", "-___-", ">.<", "<_>")
        m(Math.floor(Math.random() * m.length).toInt)
      }

      //A remote node repl that you can telnet to!
      val server = Net.createServer((socket: Socket) => {
        val remote = REPL.start("node::remote> ", socket)
        //Adding "mood" and "bonus" to the remote REPL's context.
        remote.context.mood = mood
        remote.context.bonus = "UNLOCKED"
      })

      //server.listen(port)
      //setTimeout(() => server.close(), 1.second)

      info(s"Remote REPL started on port $port.")

      //A "local" node repl with a custom prompt
      val local = REPL.start("node::local> ")

      // Exposing the function "mood" to the local REPL's context.
      local.context.mood = mood
    }*/

  }

}
