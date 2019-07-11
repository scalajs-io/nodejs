package io.scalajs.npm.escapehtml

import io.scalajs.nodejs.Assert
import org.scalatest.funspec.AnyFunSpec

/**
  * Escape-Html Test
  * @author lawrence.daniels@gmail.com
  */
class EscapeHtmlTest extends AnyFunSpec {

  describe("EscapeHtml") {

    it("should encode URIs") {
      Assert.equal(EscapeHtml("foo & bar"), "foo &amp; bar")
    }

  }

}
