package io.scalajs.npm.readablestream

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.process
import org.scalatest.FunSpec

/**
  * Readable Test
  * @author lawrence.daniels@gmail.com
  */
class ReadableTest extends FunSpec {

  describe("Readable") {

    it("provides a readable stream") {
      val bulk = new Readable()
      bulk._read = () => {}

      ('A' to 'F') foreach { ch =>
        bulk.push(Buffer.from(String.valueOf(ch)))
      }
      bulk.push(null)
      bulk.pipe(process.stdout)
    }

  }

}
