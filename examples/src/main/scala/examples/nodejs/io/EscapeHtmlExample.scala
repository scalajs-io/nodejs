package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import com.github.ldaniels528.meansjs.nodejs.escapehtml.EscapeHtml

/**
  * Escape-Html Example
  * @author lawrence.daniels@gmail.com
  */
class EscapeHtmlExample(bootstrap: Bootstrap) {
  import bootstrap._

  var escapeHtml = require[EscapeHtml]("escape-html")
  var html = escapeHtml("foo & bar")

  console.log("html =>", html)

}
