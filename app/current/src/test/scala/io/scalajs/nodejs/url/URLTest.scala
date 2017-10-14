package io.scalajs.nodejs
package url

import org.scalatest._

/**
  * URL Tests
  * @author lawrence.daniels@gmail.com
  */
class URLTest extends FunSpec {

  describe("URL") {

    it("Gets and sets the serialized query portion of the URL") {
      val myURL = new URL("https://example.org/abc?123")
      info(myURL.search) // Prints ?123

      myURL.search = "abc=xyz"
      info(myURL.href)
    }

  }

}
