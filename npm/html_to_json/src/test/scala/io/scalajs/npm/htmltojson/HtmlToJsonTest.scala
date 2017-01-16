package io.scalajs.npm
package htmltojson

import io.scalajs.JSON
import io.scalajs.jquery.JQueryElement
import io.scalajs.nodejs.http.ServerResponse
import io.scalajs.npm.htmltojson.HtmlToJsonTest.Content
import io.scalajs.npm.request.Request
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Html-to-Json Tests
  * @author lawrence.daniels@gmail.com
  */
class HtmlToJsonTest extends FunSpec {
  private val content =
    """<div>
      |<img src="http://some/server/image.jpg">
      |This is a test
      |</div>""".stripMargin

  describe("HtmlToJson") {

    it("supports batch") {
      Request("http://prolificinteractive.com/team", (error: String, response: ServerResponse, body: String) => {

        val sections = HtmlToJson.createParser(js.Array("#primary-nav a", js.Dictionary[js.Function](
          "name" -> (($section: JQueryElement) => $section.text()),
          "link" -> (($section: JQueryElement) => $section.attr("href"))
        )))
        info(s"sections => ${JSON.stringify(sections)}")

        val socialInfo = js.Array("#footer .social-link", js.Dictionary[js.Function](
          "name" -> (($link: JQueryElement) => $link.text()),
          "link" -> (($link: JQueryElement) => $link.attr("href"))
        ))
        info(s"socialInfo => ${JSON.stringify(socialInfo)}")

        val offices = HtmlToJson.createMethod(js.Array(".office", js.Dictionary[js.Function](
          "location" -> (($office: JQueryElement) => $office.find(".location").text()),
          "phone" -> (($office: JQueryElement) => $office.find(".phone").text())
        )))
        info(s"offices => ${JSON.stringify(offices)}")

        HtmlToJson.batch[Content](body, js.Dictionary(
          "sections" -> sections,
          "offices" -> offices,
          "socialInfo" -> socialInfo
        ))
      })
    }

    it("supports parsing results via callback") {
      val options = new FilterOptions().withText(_.find("div").text())
      HtmlToJson.parse(content, options, (err, result: Content) => info(s"result: ${JSON.stringify(result)}"))
    }

    it("supports parsing results via promise") {
      val options = new FilterOptions().withText(_.find("div").text())
      val promise = HtmlToJson.parse[Content](content, options)
      promise foreach (result => info(s"result: ${JSON.stringify(result)}"))
    }

    it("supports requesting results via callback") {
      val options = new FilterOptions().withText(_.find("div").text())
      HtmlToJson.request("http://www.google.com", options, (err, result: Content) => info(s"result: ${JSON.stringify(result)}"))
    }

    it("supports requesting results via promise") {
      val options = new FilterOptions().withText(_.find("div").text())
      val promise = HtmlToJson.request[Content]("http://www.google.com", options)
      promise foreach (result => info(s"result: ${JSON.stringify(result)}"))
    }

    it("supports custom parsers") {
      val linkParser = HtmlToJson.createParser(
        js.Array("a[href]", js.Dictionary(
          "text" -> (($a: JQueryElement) => $a.text()),
          "href" -> (($a: JQueryElement) => $a.attr("href"))
        )))

      info(s"linkParser = ${JSON.stringify(linkParser)}")
    }

  }

}

/**
  * Html-to-Json Test Companion
  * @author lawrence.daniels@gmail.com
  */
object HtmlToJsonTest {

  @ScalaJSDefined
  class Content(val text: String, val images: js.Object) extends js.Object

}