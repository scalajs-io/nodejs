package io.scalajs.npm.jsdom

import io.scalajs.dom.html.HTMLAnchorElement
import io.scalajs.nodejs.console
import io.scalajs.nodejs.fs.Fs
import org.scalatest._

import scala.scalajs.js

/**
  * JsDom Test
  * @author lawrence.daniels@gmail.com
  */
class JsDomTest extends FunSpec {

  describe("JsDom") {

    it("should parse an HTML snippet into a DOM instance") {
      val doc = JsDom.jsdom("""<p id="p1"><a class="the-link" href="https://github.com/tmpvar/jsdom">jsdom!</a></p>""")
      val elem = doc.getElementsByClassName("the-link").headOption.orNull
      assert(elem != null)

      val text = elem.asInstanceOf[HTMLAnchorElement].text
      assert(text == "jsdom!")
    }

    it("should initialize via a URL") {
      JsDom.env(
        content = "https://iojs.org/dist/",
        scripts = js.Array("http://code.jquery.com/jquery.js"),
        callback = (err, window) => {
          if (err != null) console.error(err)
          assert(err == null)

          import window.$
          assert($("a") != null)
        }
      )
    }

    it("should initialize via raw HTML") {
      JsDom.env(
        content = """<p><a class="the-link" href="https://github.com/tmpvar/jsdom">jsdom!</a></p>""",
        scripts = js.Array("http://code.jquery.com/jquery.js"),
        callback = (err, window) => {
          if (err != null) console.error(err)
          assert(err == null)

          import window.$
          assert($("a.the-link").text() == "jsdom!")
        }
      )
    }

    it("should initialize via a configuration object") {
      JsDom.env(
        new EnvironmentOptions(
          url = "http://news.ycombinator.com/",
          scripts = js.Array("http://code.jquery.com/jquery.js"),
          done = (err, window) => {
            if (err != null) console.error(err)
            assert(err == null)

            import window.$
            assert($("td.title:not(:last) a") != null)
          }
        ))
    }

    it("should initialize via a raw JavaScript source") {
      val jquery = Fs.readFileSync("./node_modules/jquery/dist/jquery.min.js", "utf-8")

      JsDom.env(
        new EnvironmentOptions(
          url = "http://news.ycombinator.com/",
          src = js.Array(jquery),
          done = (err, window) => {
            if (err != null) console.error(err)
            assert(err == null)

            import window.$
            assert($("td.title:not(:last) a") != null)
          }
        ))
    }

  }

}
