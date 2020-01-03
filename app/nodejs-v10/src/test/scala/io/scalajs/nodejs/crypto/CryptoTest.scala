package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, _}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

class CryptoTest extends AnyFunSpec with Matchers {
  val spkacExample =
    "MIIBXjCByDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA3L0IfUijj7+A8CPC8EmhcdNoe5fUAog7OrBdhn7EkxFButUp40P7+LiYiygYG1TmoI/a5EgsLU3s9twEz3hmgY9mYIqb/rb+SF8qlD/K6KVyUORC7Wlz1Df4L8O3DuRGzx6/+3jIW6cPBpfgH1sVuYS1vDBsP/gMMIxwTsKJ4P0CAwEAARYkYzBkZjFlYjctMTU0NC00MWVkLWFmN2EtZDRkYjBkNDc5ZjZmMA0GCSqGSIb3DQEBBAUAA4GBALEiapUjaIPs5uEdvCP0gFK2qofo+4GpeK1A43mu28lirYPAvCWsmYvKIZIT9TxvzmQIxAfxobf70aSNlSm6MJJKmvurAK+Bpn6ZUKQZ6A1m927LvctVSYJuUi+WVmr0fGE/OfdQ+BqSm/eQ3jnm3fBPVx1uwLPgjC5g4EvGMh8M"

  describe("Crypto") {
    val text = "Hello World"

    it("should be able to create an MD5 hash from a string") {
      val hasher = Crypto.createHash("md5")
      hasher.update(text)
      val buffer = hasher.digest()
      assert(buffer.toHexString === "b10a8db164e0754105b7a99be72e3fe5")
    }

    it("should be able to create a SHA256 hash from a string") {
      val hasher = Crypto.createHash("sha256")
      hasher.update(text)
      val buffer = hasher.digest()
      assert(buffer.toHexString === "a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e")
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

  describe("Crypto module") {
    it("has constants") {
      assert(Crypto.constants.ENGINE_METHOD_DSA === 2)
    }
  }

  describe("Crypto object") {
    describe("randomFillSync") {
      it("should accept Buffer and return value in type as received") {
        val buffer  = Buffer.alloc(5)
        val result1 = Crypto.randomFillSync(buffer)
        assert(result1.length === 5)
        assert(result1.isInstanceOf[Buffer])
      }

      it("should accept DataView and return value in type as received") {
        val view    = new DataView(new ArrayBuffer(4))
        val result1 = Crypto.randomFillSync(view)
        assert(result1.isInstanceOf[DataView])
      }

      it("should accept any TypedArray and return value in type as received") {
        val array1  = Uint8Array.from(js.Array[Short](1, 2, 3))
        val result1 = Crypto.randomFillSync(array1)
        assert(result1.length === 3)
        assert(result1.isInstanceOf[Uint8Array])

        val array2  = Uint16Array.from(js.Array[Int](1, 2, 3, 4))
        val result2 = Crypto.randomFillSync(array2)
        assert(result2.length === 4)
        assert(result2.isInstanceOf[Uint16Array])
      }
    }
  }
}
