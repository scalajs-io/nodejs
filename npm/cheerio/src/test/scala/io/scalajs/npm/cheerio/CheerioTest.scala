package io.scalajs.npm.cheerio

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

/**
  * Cheerio Test
  * @author lawrence.daniels@gmail.com
  */
class CheerioTest extends FunSpec {

  describe("Cheerio") {

    it("supports manipulating HTML") {
      val input = """<h2 class="title">Hello world</h2>"""
      val $ = Cheerio.load(input)

      $("h2.title").text("Hello there!")
      $("h2").addClass("welcome")

      val output = $.html()
      info(s"before: $input")
      info(s"after:  $output")
      Assert.equal(output, """<h2 class="title welcome">Hello there!</h2>""")
    }

    it("supports text extraction") {
      val $ = Cheerio.load("""<ul><li class="orange">Hello world</li></ul>""")
      val text = $("li[class=orange]").html()
      info(s"text: $text")
      Assert.equal(text, "Hello world")
    }

    it("supports reading component state") {
      val $ = Cheerio.load("""<input name="agree" type="checkbox">""")
      val value = $("input[type='checkbox']").prop("checked")
      info(s"isChecked: $value")
      Assert.equal(value, false)
    }

    it("supports updating component state") {
      val $ = Cheerio.load("""<input name="agree" type="checkbox">""")
      val value = $("input[type='checkbox']").prop("checked", true).`val`()
      info(s"setChecked: $value")
      Assert.equal(value, "on")
    }

    it("supports serialization") {
      val $ = Cheerio.load("""<input name="agree" type="checkbox">""")
      val value = $("""<form><input name="foo" value="bar" /></form>""").serializeArray()
      info(s"value: ${JSON.stringify(value)}")
      Assert(value, """[{"name":"foo","value":"bar"}]""")
    }

    it("supports $.root()") {
      val $ = Cheerio.load("""<input name="agree" type="checkbox">""")
      val value = $.root().append("""<ul id="vegetables"></ul>""").html()
      info(s"value: $value")
    }

  }

}
