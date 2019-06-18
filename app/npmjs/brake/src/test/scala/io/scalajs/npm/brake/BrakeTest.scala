package io.scalajs.npm.brake

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.process
import io.scalajs.npm.readablestream.Readable
import org.scalatest.FunSpec

/**
  * Brake Test
  * @author lawrence.daniels@gmail.com
  */
class BrakeTest extends FunSpec {

  describe("Brake") {

    it("supports throttling streams") {
      val bulk = new Readable()
      bulk._read = () => {}

      ('A' to 'F') foreach { ch =>
        bulk.push(Buffer.from(String.valueOf(ch)))
      }
      bulk.push(null)
      bulk.pipe(Brake(10)).pipe(process.stdout)
    }

  }

}

