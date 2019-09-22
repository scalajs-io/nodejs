package io.scalajs.nodejs.util

import org.scalatest.FunSpec

import scala.scalajs.js

class UtilTest extends FunSpec {

  it("have formatWithOptions added in v10.0.0") {
    assert(Util.formatWithOptions(new InspectOptions(), "See object %O", new js.Object {
      val foo: Int = 42
    }) === "See object { foo: 42 }")
  }

  it("have getSystemErrorName added in v9.7.0") {
    assert(Util.getSystemErrorName(-1) === "EPERM")
  }

  it("have types added in v10.0.0") {
    assert(Util.types.isDate(new js.Date))
  }

  it("have inspect.custom added in v10.12.0") {
    assert(Util.inspect.custom != null)
  }

}
