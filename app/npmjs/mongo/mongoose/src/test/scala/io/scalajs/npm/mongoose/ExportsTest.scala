package io.scalajs.npm.mongoose

import io.scalajs.JSON
import org.scalatest.FunSpec

/**
  * Exports Test Suite
  * @author lawrence.daniels@gmail.com
  */
class ExportsTest extends FunSpec {

  describe("exports") {

    it("supports pluralization") {
      info(s"pluralization: ${JSON.stringify(exports.pluralization.orNull)}")
    }

    it("supports uncountables") {
      info(s"uncountables: ${JSON.stringify(exports.uncountables.orNull)}")
    }

  }

}
