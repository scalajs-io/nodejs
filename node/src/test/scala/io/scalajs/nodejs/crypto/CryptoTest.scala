package io.scalajs.nodejs.crypto

import org.scalatest.FunSpec

/**
  * Crypto Test
  * @author lawrence.daniels@gmail.com
  */
class CryptoTest extends FunSpec {

  describe("Crypto") {

    val text = "Hello World"

    it("should be able to create an MD5 hash from a string") {
      val hasher = Crypto.createHash("md5")
      hasher.update(text)
      val buffer = hasher.digest()
      assert(buffer.toHexString == "b10a8db164e0754105b7a99be72e3fe5")
    }

    it("should be able to create a SHA256 hash from a string") {
      val hasher = Crypto.createHash("sha256")
      hasher.update(text)
      val buffer = hasher.digest()
      assert(buffer.toHexString == "a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e")
    }

  }

}
