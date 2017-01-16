package io.scalajs.dom.html

import io.scalajs.dom.html.browser.console
import org.scalatest.FunSpec

/**
  * URL Search Params Test
  * @author lawrence.daniels@gmail.com
  */
class URLSearchParamsTest extends FunSpec {

  describe("URLSearchParams") {

    it("should provide an iteration of values") {
      val searchParams = new URLSearchParams("key1=value1&key2=value2")

      // Display the key/value pairs
      for (value <- searchParams.values()) {
        console.log(value)
      }
    }

  }

}
