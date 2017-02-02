package io.scalajs.jquery

import io.scalajs.jquery.JQuery.$
import org.scalajs.dom.html.browser.window
import org.scalatest._

import scala.scalajs.js

/**
  * JQuery Tests
  * @author lawrence.daniels@gmail.com
  */
class JQueryTest extends FunSpec {

  import window.document

  describe("JQuery") {

    it("should provide a add() method for adding elements to an existing group") {
      $("h1").add("p").add("span")
    }

    it("should provide a append() method") {
      $("p").append("Some appended text.")
    }

    it("should provide a attr() method for getting/setting attributed") {
      // case #1
      $("#w3s").attr("href")

      // case #2
      $("#greatphoto").attr(new js.Object {
        val alt: String   = "Beijing Brush Seller"
        val title: String = "photo by Kelly Clark"
      })

      // case #3
      $("#w3s").attr("href", "http://www.w3schools.com/jquery")

      // case #4
      $("#greatphoto").attr("title", (i, `val`) => `val` + " - photo by Kelly Clark")
    }

    it("should provide a change() method") {
      val element = $("input")
      element
        .change(_ => {
          val $input = $(element)
          $("p").html(
            ".attr( 'checked' ): <b>" + $input.attr("checked") + "</b><br>" +
              ".prop( 'checked' ): <b>" + $input.prop("checked") + "</b><br>" +
              ".is( ':checked' ): <b>" + $input.is(":checked") + "</b>"
          )
        })
        .change()
    }

    it("should provide a children() method") {
      $("ul.level-2").children().css("background-color", "red")
    }

    it("should provide a closest() method") {
      // case #1
      $("li.item-a").closest("ul").css("background-color", "red")

      // case #2
      val listItemII = document.getElementById("ii")
      $("li.item-a").closest("ul", listItemII).css("background-color", "red")
      $("li.item-a").closest("#one", listItemII).css("background-color", "green")
    }

    it("should provide a click() method") {
      // case #1
      $("p").click()

      // case #2
      $("#btn1").click { _ =>
        window.alert("Text: " + $("#test").text())
      }

      // case #3
      $("ul").click { event =>
        val target = $(event.target)
        if (target.is("li")) {
          target.css("background-color", "red")
        }
      }
    }

    it("should provide a $(document).ready() method") {
      $(document).ready { () =>
        println("The document is ready")
      }
    }

    it("should provide a fadeIn() method") {
      // case #1
      $("p").fadeIn(1000)

      // case #2
      $("p").fadeIn("slow")
    }

    it("should provide a fadeOut() method") {
      // case #1
      $("p").fadeOut(1000)

      // case #2
      $("p").fadeOut("slow")
    }

    it("should provide a find() method") {
      // case #1
      $("p").find("span").css("color", "red")

      // case #2
      val item1 = $("li.item-1")(0)
      $("li.item-ii").find(item1).css("background-color", "red")
    }

    it("should provide a next() method") {
      // case #1
      $("button[disabled]").next().text("this button is disabled")

      // case #2
      $("p").next(".selected").css("background", "yellow")
    }

    it("should provide a nextUntil() method") {
      // case #1
      $("#term-2").nextUntil("dt").css("background-color", "red")

      // case #2
      val term3 = document.getElementById("term-3")
      $("#term-1").nextUntil(term3, "dd").css("color", "green")
    }

    it("should provide a parent() method") {
      val element = $("div.foo")
      element.toggleClass { () =>
        val feeling = if ($(element).parent().is(".bar")) "happy" else "sad"
        println(feeling)
      }
    }

    it("should provide a prepend() method") {
      $("p").prepend("Some prepended text.")
    }

    it("should provide a text() method") {
      $("div").text($("img").attr("alt"))
    }

  }

}
