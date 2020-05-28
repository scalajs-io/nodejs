package io.scalajs.nodejs.module

import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

class ModuleTest extends AnyFunSpec {
  describe("Module Object (module module)") {
    it("builtinModules") {
      assert(io.scalajs.nodejs.module.Module.builtinModules.length >= 30)
    }
  }

  describe("module Object") {
    it("children") {
      // contents vary on runtime
      assert(io.scalajs.nodejs.moduleObject.children.isInstanceOf[js.Array[_]])
    }
    it("filename") {
      // contents vary on runtime
      assert(io.scalajs.nodejs.moduleObject.filename.nonEmpty)
    }
  }
}
