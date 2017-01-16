package io.scalajs.npm.escapehtml

import org.scalatest.FunSpec

/**
  * Escape-Html Test
  * @author lawrence.daniels@gmail.com
  */
class EscapeHtmlTest extends FunSpec {

  describe("EscapeHtml") {

    it("should encode URIs") {
      assert(EscapeHtml("foo & bar") == "foo &amp; bar")
    }

  }

}
