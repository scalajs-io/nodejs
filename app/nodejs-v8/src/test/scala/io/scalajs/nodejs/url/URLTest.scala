package io.scalajs.nodejs
package url

import org.scalatest._

class URLTest extends FunSpec {

  describe("URL") {

    it("Gets and sets the serialized query portion of the URL") {
      val myURL = new URL("https://example.org/abc?123")
      assert(myURL.search === "?123")

      myURL.search = "abc=xyz"
      assert(myURL.href === "https://example.org/abc?abc=xyz")
    }

  }

}
