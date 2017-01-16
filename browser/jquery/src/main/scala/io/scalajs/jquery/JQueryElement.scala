package io.scalajs.jquery

import io.scalajs.dom.Element

import scala.scalajs.js

/**
  * JQuery Element
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JQueryElement extends js.Array[Element]
  with Element with JQCss with JQEffects with JQEvents with JQHtml with JQTraversal