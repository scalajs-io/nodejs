package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Frame/Object Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FrameObjectEvents extends js.Object {

  /**
    * The event occurs when the loading of a resource has been aborted
    */
  def onabort(callback: js.Function): Unit = js.native

  /**
    * The event occurs before the document is about to be unloaded
    */
  def onbeforeunload(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an error occurs while loading an external file
    */
  def onerror(callback: js.Function): Unit = js.native

  /**
    * The event occurs when there has been changes to the anchor part of a URL
    */
  def onhashchange(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an object has loaded
    */
  def onload(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user navigates to a webpage
    */
  def onpageshow(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user navigates away from a webpage
    */
  def onpagehide(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the document view is resized
    */
  def onresize(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element's scrollbar is being scrolled
    */
  def onscroll(callback: js.Function): Unit = js.native

  /**
    * The event occurs once a page has unloaded (for <body>)
    */
  def onunload(callback: js.Function): Unit = js.native

}
