package io.scalajs.dom.html

import scala.scalajs.js

/**
  * HTMLMenuElement
  * @see https://docs.webplatform.org/wiki/dom/HTMLMenuElement
  * @see https://developer.blackberry.com/html5/documentation/v1_0/htmlmenuelement_569241_11.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HTMLMenuElement extends HTMLElement {

  /**
    * When true, indicates reduced spacing between list items.
    */
  var compact: Boolean = js.native

}
