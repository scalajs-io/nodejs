package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import com.github.ldaniels528.meansjs.nodejs.escapehtml.EscapeHtml

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
