package io.scalajs.npm.jsdom

import io.scalajs.dom.html.browser.Window
import io.scalajs.jquery.JQuery

import scala.scalajs.js

/**
  * JsDom Window Implementation
  * @author lawrence.daniels@gmail.com
  */
@js.native
class JsDomWindowWithJQuery extends Window {
  val $: JQuery = js.native
}
