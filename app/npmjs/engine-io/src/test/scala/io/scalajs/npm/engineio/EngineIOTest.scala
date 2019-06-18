package io.scalajs.npm.engineio

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.http.Http
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * EngineIO Tests
  * @author lawrence.daniels@gmail.com
  */
class EngineIOTest extends FunSpec {

  describe("engine.io") {

    it("can listen on a port") {
      val server = EngineIO.listen(80)
      server.on("connection", { socket: Socket =>
        socket.send("utf 8 string")
        socket.send(Buffer.from(js.Array(0, 1, 2, 3, 4, 5))) // binary data
      })
    }

    it("can intercept requests for a http.Server") {
      val http = Http.createServer()
      http.listen(3000)

      val server = EngineIO.attach(http)
      server.on("connection", { socket: Socket =>
        socket.on("message", (data: Buffer) => {})
        socket.on("close", () => {})
      })
    }

  }

}
