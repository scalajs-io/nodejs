package io.scalajs.npm.jsdom

import io.scalajs.dom.html.HTMLAnchorElement
import org.scalatest._

/**
  * JsDom Test
  * @author lawrence.daniels@gmail.com
  */
class JsDomTest extends FunSpec {

  describe("JsDom") {

    it("should parse an HTML snippet and extract a value via querySelector") {
      val dom = new JsDom.JSDOM("""<!DOCTYPE html><p>Hello world</p>""")
      val text = dom.window.document.querySelector("p").textContent
      assert(text == "Hello world")
    }

    it("should parse an HTML snippet and extract a value via getElementsByClassName") {
      val dom = new JsDom.JSDOM("""<p id="p1"><a class="the-link" href="https://github.com/tmpvar/jsdom">jsdom!</a></p>""")
      val text = dom.window.document.getElementsByClassName("the-link").headOption.map(_.asInstanceOf[HTMLAnchorElement].text).orNull
      assert(text == "jsdom!")
    }

    it("should accurately identify the number of elementd within the <body> tag") {
      val dom = new JsDom.JSDOM("""<body><script>document.body.appendChild(document.createElement("hr"));</script></body>""")
      assert(dom.window.document.body.children.length === 1)
    }

    it("should extract a DOM instance from an URL") {
      val dom = new JsDom.JSDOM(options = new JsDomOptions(
        url = "https://github.com/scalajs-io/nodejs",
        referrer = "https://github.com/ldaniels528",
        contentType = "text/html",
        includeNodeLocations = true,
        storageQuota = 10000000d
      ))
      val doc = dom.window.document
      assert(doc != null)
    }

  }

}
