package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.buffer.Buffer
import utest._

import scala.scalajs.js

/**
  * Crypto Tests
  * @author lawrence.daniels@gmail.com
  */
object CryptoTests extends TestSuite {

  override val tests = this {
    val crypto = Crypto()

    "crypto should be able to create an MD5 hash from a string" - {
      val hasher = crypto.createHash("md5")
      val text = "Hello World"

      hasher.update(text)
      val md5sum = hasher.digest()
      val bytes = Buffer.from(js.Array(0xb1, 0x0a, 0x8d, 0xb1, 0x64, 0xe0, 0x75, 0x41, 0x05, 0xb7, 0xa9, 0x9b, 0xe7, 0x2e, 0x3f, 0xe5))
      assert(0 == Buffer.compare(md5sum, bytes))
    }

  }

}
