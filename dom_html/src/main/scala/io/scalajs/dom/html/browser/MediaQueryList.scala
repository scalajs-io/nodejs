package io.scalajs.dom.html.browser

import scala.scalajs.js

/**
  * A MediaQueryList object maintains a list of media queries on a document, and handles sending notifications to
  * listeners when the media queries on the document change.
  *
  * This makes it possible to observe a document to detect when its media queries change, instead of polling the values
  * periodically, if you need to programmatically detect changes to the values of media queries on a document.
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/MediaQueryList
  */
@js.native
class MediaQueryList extends js.Object {

  /**
    * @return true if the document currently matches the media query list; otherwise false.
    */
  def matches: Boolean = js.native

  /**
    * The serialized media query list.
    */
  def media: String = js.native

  /**
    * Adds a new listener to the media query list. If the specified listener is already in the list, this method has no effect.
    * @param listener the given listener function
    */
  def addListener(listener: js.Function): Unit = js.native

  /**
    * Removes a listener from the media query list. Does nothing if the specified listener isn't already in the list.
    * @param listener the given listener function
    */
  def removeListener(listener: js.Function): Unit = js.native

}
