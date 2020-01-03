package io.scalajs.nodejs.fs

import org.scalatest.funspec.AnyFunSpec

/**
  * File System (Fs) Tests
  *
  */
class FsClassesTest extends AnyFunSpec {
  describe("ReadStream") {
    it("supports pending added in v11.2.0") {
      assert(new ReadStream("package.json").pending)
    }
  }
}
