package io.scalajs.nodejs.crypto

import org.scalatest.{FunSpec, MustMatchers}

/**
  * Crypto Test
  * @author lawrence.daniels@gmail.com
  */
class CryptoTest extends FunSpec with MustMatchers {

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

    it("should be able to hash passwords with pbkdf2Sync") {
      val computedHash =
        Crypto.pbkdf2Sync("this-is-a-password", "random-salt", 10000, 512, "sha512").toString("base64")
      val expectedHash =
        "nzaxkuDuglFxKDMtr566d1mlr7kZV5y1j5PWpU9E/R9cpZz5q8pyYgeuTWADj2DhBF6koAsikPOac81lOHgK+tgiIYy6YRBd0SylsewT3QR5CelagTY1nrKougkJi95TmyKplJIO9M2szDqMhX5eT0yY2eVLnv9R0SCjd3qunvbVJmOvfEOgetPCwu5oUfRGeX/2JUlE6g3l80b252tVhzKUATeFMAKKdl448FzYdt/vWJRq2dt1ActjDV/C9RpWMNHBw10cLS3/ivSVXnjNzANArDSOAdzIh2lnrauoEtIULqlKFImx4vk2B7Pt4Wg5+ouOGWbW8ZeU1zOqAQOlDSOggxEs+fOJvOrFZdVwyZ15UYX2gRnHc+aNT2gQd+HKwCJMrDbuxz9rYQe7SGfcgeT6vxz2ZLnZ2E5SIWP5QIhm+CboYypDCGh7O5FwBHoJCSEJW3mFu/pA01Hwz11ORS6UeD/z29k546YZRa0jrzD5dLJQE+Rc72cVJv05VLs+U30b4NHcmmjmdqoT/vfxto9XM+atN7D10+dNne59YmbL9TQyvDBnxwHIUoXXGDp5OLjjtlh2A/AFu4VtF/vhRolyvSnMfQznJnEBmDkIiW/V1qwI0TevOheG04ERHtFU5eGUYt7ofPAlkUrrJxEmuwSyVoApuI+lI5CaKD4dke0="

      computedHash mustEqual expectedHash
    }

    it("should be able to encrypt and decrypt text from a private key (AES-256-ctr)") {
      val alg             = "aes-256-ctr"
      val key             = "this-is-a-private-key"
      val stringToEncrypt = "text-to-encrypt"

      val cipher              = Crypto.createCipher(alg, key)
      val encrypted           = cipher.update(stringToEncrypt, "utf8", "base64")
      val finalEncryptedValue = encrypted + cipher.`final`("base64")

      val decipher            = Crypto.createDecipher(alg, key)
      val decrypted           = decipher.update(finalEncryptedValue, "base64", "utf8")
      val finalDecryptedValue = decrypted + decipher.`final`("utf8")

      finalEncryptedValue mustNot equal(stringToEncrypt)
      finalDecryptedValue must equal(stringToEncrypt)
    }

  }

}
