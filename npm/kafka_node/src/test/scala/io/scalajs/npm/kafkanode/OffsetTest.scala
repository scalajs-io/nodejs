package io.scalajs.npm.kafkanode

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Offset Tests
  * @author lawrence.daniels@gmail.com
  */
class OffsetTest extends FunSpec {

  describe("Offset") {

    it("can fetch(...)") {
      val client = new Client()
      val offset = new Offset(client)
      offset.fetch(js.Array(new Payload(topic = "t", partition = 0, time = js.Date.now(), maxNum = 1)),
                   (err, data) => {
                     // data
                     // { 't': { '0': [999] } }

                   })

    }

  }

}
