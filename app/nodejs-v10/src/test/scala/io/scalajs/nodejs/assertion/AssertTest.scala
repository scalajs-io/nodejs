package io.scalajs.nodejs.assertion

import io.scalajs.nodejs.{Assert => NodeAssert}

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class AssertTest extends AnyFunSpec {
  it("have strict from v9.9.0") {
    assert(NodeAssert.strict !== js.undefined)
  }

  it("have rejects/doesNotReject from v10.0.0") {
    assert(NodeAssert.strict.rejects _ !== js.undefined)
    assert(NodeAssert.strict.doesNotReject _ !== js.undefined)
  }
}
