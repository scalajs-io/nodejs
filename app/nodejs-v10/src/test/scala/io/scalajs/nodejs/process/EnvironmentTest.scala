package io.scalajs.nodejs.process

import org.scalatest.funspec.AnyFunSpec

class EnvironmentTest extends AnyFunSpec {
  describe("Environment") {
    it("have PATH as member") {
      assert(Process.env.PATH.nonEmpty)
    }

    it("have getter for arbitrary variables") {
      assert(Process.env.PATH === Process.env("PATH"))
    }

    it("have setter") {
      assert(Process.env("__NO_SUCH_ENV_VAR__").isEmpty)
      Process.env.update("__NO_SUCH_ENV_VAR__", "FOO")
      assert(Process.env("__NO_SUCH_ENV_VAR__").getOrElse("") === "FOO")
    }
  }
}
