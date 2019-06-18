package io.scalajs.npm.escapehtml

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

/**
  * Escape-Html Test
  * @author lawrence.daniels@gmail.com
  */
class EscapeHtmlTest extends FunSpec {

  describe("EscapeHtml") {

    it("should encode URIs") {
      Assert.equal(EscapeHtml("foo & bar"), "foo &amp; bar")
    }

  }

}
