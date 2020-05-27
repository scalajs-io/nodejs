package io.scalajs.nodejs.util

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class UtilTest extends AnyFunSpec {
  it("have inspect object") {
    assert(Util.inspect !== null)
    assert(Util.inspect(js.Array(1, 2, 3)) === "[ 1, 2, 3 ]")
    val inspectOptions = InspectOptions(maxArrayLength = 1)
    assert(Util.inspect(js.Array(1, 2, 3), inspectOptions) === "[ 1, ... 2 more items ]")
    assert(Util.inspect.defaultOptions !== null)
    assert(Util.inspect.styles !== null)
  }

  it("have promisify") {
    assert(js.typeOf(Util.promisify(() => "")) === "function")
    assert(js.typeOf(Util.promisify.custom) === "symbol")
  }

  it("have TextEncoder/TextDecoder") {
    val encoder = new TextEncoder()
    val decoder = new TextDecoder()
    val encoded = encoder.encode("foobar")
    val decoded = decoder.decode(encoded)
    assert(decoded === "foobar")
  }

  it("have formatWithOptions added in v10.0.0") {
    assert(
      Util.formatWithOptions(
        InspectOptions(compact = true),
        "See object %O",
        new js.Object {
          val foo: Int = 42
        }
      ) === "See object { foo: 42 }"
    )
  }

  it("have getSystemErrorName added in v9.7.0") {
    assert(Util.getSystemErrorName(-1) === "EPERM")
  }

  it("have types added in v10.0.0") {
    assert(Util.types.isDate(new js.Date))
  }

  it("have inspect.custom added in v10.12.0") {
    assert(Util.inspect.custom !== null)
  }
}
