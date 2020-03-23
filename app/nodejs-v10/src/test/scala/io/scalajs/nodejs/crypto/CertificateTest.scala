package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

class CertificateTest extends AnyFunSpec with Matchers {
  val spkacExample =
    "MIIBXjCByDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA3L0IfUijj7+A8CPC8EmhcdNoe5fUAog7OrBdhn7EkxFButUp40P7+LiYiygYG1TmoI/a5EgsLU3s9twEz3hmgY9mYIqb/rb+SF8qlD/K6KVyUORC7Wlz1Df4L8O3DuRGzx6/+3jIW6cPBpfgH1sVuYS1vDBsP/gMMIxwTsKJ4P0CAwEAARYkYzBkZjFlYjctMTU0NC00MWVkLWFmN2EtZDRkYjBkNDc5ZjZmMA0GCSqGSIb3DQEBBAUAA4GBALEiapUjaIPs5uEdvCP0gFK2qofo+4GpeK1A43mu28lirYPAvCWsmYvKIZIT9TxvzmQIxAfxobf70aSNlSm6MJJKmvurAK+Bpn6ZUKQZ6A1m927LvctVSYJuUi+WVmr0fGE/OfdQ+BqSm/eQ3jnm3fBPVx1uwLPgjC5g4EvGMh8M"

  describe("Certificate object") {
    it("exportChallenge") {
      assert(Certificate.exportChallenge(spkacExample).toString("utf8") === "c0df1eb7-1544-41ed-af7a-d4db0d479f6f")
    }

    it("exportPublicKey") {
      assert(
        Certificate.exportPublicKey(spkacExample).toString("utf8") ===
          """-----BEGIN PUBLIC KEY-----
          |MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcvQh9SKOPv4DwI8LwSaFx02h7
          |l9QCiDs6sF2GfsSTEUG61SnjQ/v4uJiLKBgbVOagj9rkSCwtTez23ATPeGaBj2Zg
          |ipv+tv5IXyqUP8ropXJQ5ELtaXPUN/gvw7cO5EbPHr/7eMhbpw8Gl+AfWxW5hLW8
          |MGw/+AwwjHBOwong/QIDAQAB
          |-----END PUBLIC KEY-----
          |""".stripMargin
      )
    }

    it("verifySpkac") {
      assert(Crypto.Certificate.verifySpkac(Buffer.from("foo")) === false)
    }
  }
}
