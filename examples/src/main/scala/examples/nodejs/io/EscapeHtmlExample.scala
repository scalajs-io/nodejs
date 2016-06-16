package examples.nodejs.io

import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.escapehtml.EscapeHtml

/**
  * Escape-Html Example
  * @author lawrence.daniels@gmail.com
  */
class EscapeHtmlExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  var escapeHtml = EscapeHtml()
  var html = escapeHtml("foo & bar")

  console.log("html =>", html)

}
