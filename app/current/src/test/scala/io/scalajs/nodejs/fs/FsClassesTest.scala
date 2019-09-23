package io.scalajs.nodejs.fs

import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

/**
  * File System (Fs) Tests
  *
  */
class FsClassesTest extends FunSpec {
  describe("ReadStream") {
    it("supports pending added in v11.2.0") {
      assert(new ReadStream("package.json").pending)
    }
  }

}
