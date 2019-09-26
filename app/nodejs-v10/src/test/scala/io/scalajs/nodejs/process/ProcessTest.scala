package io.scalajs.nodejs.process

import org.scalatest.FunSpec

class ProcessTest extends FunSpec{

  describe("Process") {
    it("hrtime.bigint") {
      // TODO: js.BigInt
      val value = Process.hrtime.bigint()
      assert(value.toString().matches("^\\d+$"))
    }
  }

}
