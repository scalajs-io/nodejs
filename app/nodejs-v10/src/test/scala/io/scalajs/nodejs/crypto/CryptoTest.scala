package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.{FunSpec, MustMatchers}

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, _}

class CryptoTest extends FunSpec with MustMatchers {
  val spkacExample =
    "MIIBXjCByDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA3L0IfUijj7+A8CPC8EmhcdNoe5fUAog7OrBdhn7EkxFButUp40P7+LiYiygYG1TmoI/a5EgsLU3s9twEz3hmgY9mYIqb/rb+SF8qlD/K6KVyUORC7Wlz1Df4L8O3DuRGzx6/+3jIW6cPBpfgH1sVuYS1vDBsP/gMMIxwTsKJ4P0CAwEAARYkYzBkZjFlYjctMTU0NC00MWVkLWFmN2EtZDRkYjBkNDc5ZjZmMA0GCSqGSIb3DQEBBAUAA4GBALEiapUjaIPs5uEdvCP0gFK2qofo+4GpeK1A43mu28lirYPAvCWsmYvKIZIT9TxvzmQIxAfxobf70aSNlSm6MJJKmvurAK+Bpn6ZUKQZ6A1m927LvctVSYJuUi+WVmr0fGE/OfdQ+BqSm/eQ3jnm3fBPVx1uwLPgjC5g4EvGMh8M"

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
