package io.scalajs.npm.md5

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.funspec.AnyFunSpec

/**
  * MD5 Test
  * @author lawrence.daniels@gmail.com
  */
class MD5Test extends AnyFunSpec {

  describe("MD5") {

    it("should convert text to an MD5 string") {
      assert(MD5("Hello Wold") == "7e1c79bda939ad9f46a382a56df147e1")
    }

    it("should convert a Buffer to an MD5 string") {
      assert(MD5(Buffer.from("Hello Wold")) == "7e1c79bda939ad9f46a382a56df147e1")
    }

  }

}
