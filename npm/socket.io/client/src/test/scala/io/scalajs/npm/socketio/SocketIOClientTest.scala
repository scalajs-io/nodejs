package io.scalajs.npm.socketio

import org.scalatest.FunSpec

/**
  * Socket.io Client Tests
  * @author lawrence.daniels@gmail.com
  */
class SocketIOClientTest extends FunSpec {

  describe("io") {

    it("should connect to a remote host") {
      val socket = SocketIOClient("http://localhost")
      socket.onConnect(() => {})
      socket.onEvent(data => {})
      socket.onDisconnect(() => {})
    }

  }

}
