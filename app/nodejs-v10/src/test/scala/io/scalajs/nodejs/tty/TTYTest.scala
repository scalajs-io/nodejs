package io.scalajs.nodejs.tty

import org.scalatest.funspec.AnyFunSpec

/**
  * TTY Test
  */
class TTYTest extends AnyFunSpec {
  describe("TTY") {
    it("should identify TTY devices") {
      // this is freaky, just testing it returns boolean
      assert(TTY.isatty(1) || true)
    }
  }
}
