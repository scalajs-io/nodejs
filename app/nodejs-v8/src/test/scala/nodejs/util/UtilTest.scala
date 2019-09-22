package io.scalajs.nodejs.util

import org.scalatest.FunSpec

class UtilTest extends FunSpec {

  it("have inspect object") {
    assert(Util.inspect != null)
    assert(Util.inspect.defaultOptions != null)
    assert(Util.inspect.styles != null)
  }

  it("have promisify") {
    assert(Util.promisify.custom != null)
  }

  it("have TextEncoder/TextDecoder") {
    val encoder = new TextEncoder()
    val decoder = new TextDecoder()
    val encoded = encoder.encode("foobar")
    val decoded = decoder.decode(encoded)
    assert(decoded === "foobar")
  }
}
