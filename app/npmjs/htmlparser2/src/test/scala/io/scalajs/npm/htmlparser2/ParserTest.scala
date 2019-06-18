package io.scalajs.npm.htmlparser2

import io.scalajs.nodejs.console
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * htmlparser2 Parser Test
  * @author lawrence.daniels@gmail.com
  */
class ParserTest extends FunSpec {

  describe("Parser") {

    it("should parse HTML documents") {

      val parser = new Parser(
        new ParserHandler {

          override def onopentag(name: String, attribs: js.Dictionary[String]) {
            if (name == "script" && attribs("type") == "text/javascript") {
              console.log("JS! Hooray!")
            }
          }

          override def ontext(text: String): Unit = console.log("-->", text)

          override def onclosetag(tagname: String) {
            if (tagname == "script") {
              console.log("That's it?!")
            }
          }
        },
        new ParserOptions(decodeEntities = true))
      parser.write("Xyz <script type='text/javascript'>var foo = '<<bar>>'</script>")
      parser.end()
    }

  }

}
