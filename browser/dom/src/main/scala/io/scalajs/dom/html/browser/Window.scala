package io.scalajs.dom.html.browser

import io.scalajs.dom.html.browser.Window._
import io.scalajs.dom.html.css.CSSStyleDeclaration
import io.scalajs.dom.ws.WebSocket
import io.scalajs.dom.{Document, Element, Performance}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess
import scala.scalajs.js.|

/**
  * Window object
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Window
  */
@js.native
class Window extends js.Object {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * Read-only: An OfflineResourceList object providing access to the offline resources for the window.
    */
  def applicationCache: OfflineResourceList = js.native

  /**
    * Read-only: Returns the CacheStorage object associated with the current origin. This object enables service
    * worker functionality such as storing assets for offline use, and generating custom responses to requests.
    */
  def caches: CacheStorage = js.native

  /**
    * Read-only: This property indicates whether the current window is closed or not.
    */
  def closed: Boolean = js.native

  /**
    * The entry point to many XPCOM features. Some properties, e.g. classes, are only available to sufficiently
    * privileged code. Web code should not use this property.
    */
  def Components: js.Object = js.native

  /**
    * Read-only: Returns a reference to the console object which provides access to the browser's debugging console.
    */
  def console: Console = js.native

  /**
    * Read-only: Returns a reference to the content element in the current window.
    * The obsolete variant with underscore is no longer available from Web content.
    */
  def content: js.Object = js.native

  def _content: js.Object = js.native

  /**
    * Read-only: Returns the XUL controller objects for the current chrome window.
    */
  def controllers: XULControllers = js.native

  /**
    * Read-only: Returns the browser crypto object.
    */
  def crypto: js.Object = js.native

  /**
    * Gets/sets the status bar text for the given window (Obsolete since Gecko 23).
    */
  def defaultStatus: String = js.native

  /**
    * Read-only: Returns the ratio between physical pixels and device independent pixels in the current display.
    */
  def devicePixelRatio: Double = js.native

  /**
    * Read-only: Gets the arguments passed to the window (if it's a dialog box) at the time window.showModalDialog()
    * was called. This is an nsIArray.
    */
  def dialogArguments: js.Object = js.native

  /**
    * Synonym of window.personalbar
    */
  def directories: js.Object = js.native

  /**
    * Read-only: Returns a reference to the document that the window contains.
    */
  def document: Document = js.native

  /**
    * Read-only: Returns the element in which the window is embedded, or null if the window is not embedded.
    */
  def frameElement: Element = js.native

  /**
    * Read-only: Returns an array of the subframes in the current window.
    */
  def frames: js.Array[Frame] = js.native

  /**
    * This property indicates whether the window is displayed in full screen or not.
    */
  def fullScreen: Boolean = js.native

  /**
    * Unsupported since Gecko 13 (Firefox 13). Use Window.localStorage instead.
    * Was: Multiple storage objects that are used for storing data across multiple pages (Obsolete since Gecko 13).
    */
  def globalStorage: LocalStorage = js.native

  /**
    * Read-only: Returns a reference to the history object.
    */
  def history: History = js.native

  /**
    * Gets the height of the content area of the browser window including, if rendered, the horizontal scrollbar.
    */
  def innerHeight: Int = js.native

  /**
    * Gets the width of the content area of the browser window including, if rendered, the vertical scrollbar.
    */
  def innerWidth: Int = js.native

  /**
    * Read-only: Indicates whether a context is capable of using features that require secure contexts.
    */
  def isSecureContext: Boolean = js.native

  /**
    * Read-only: Returns the number of frames in the window. See also window.frames.
    */
  def length: Int = js.native

  /**
    * Read-only: Gets/sets the location, or current URL, of the window object.
    */
  def location: Location = js.native

  /**
    * Read-only: Returns the locationbar object, whose visibility can be toggled in the window.
    */
  def locationbar: js.Any = js.native

  /**
    * Read-only: Returns a reference to the local storage object used to store data that may only be accessed by
    * the origin that created it.
    */
  def localStorage: LocalStorage = js.native

  /**
    * Read-only: Returns the menubar object, whose visibility can be toggled in the window.
    */
  def menubar: Menubar = js.native

  /**
    * Returns the message manager object for this window.
    */
  def messageManager: js.Any = js.native

  /**
    * Read-only: The time in milliseconds since epoch at which the current animation cycle began.
    */
  def mozAnimationStartTime: Int = js.native

  /**
    * Read-only: Returns the horizontal (X) coordinate of the top-left corner of the window's viewport,
    * in screen coordinates. This value is reported in CSS pixels. See mozScreenPixelsPerCSSPixel in
    * nsIDOMWindowUtils for a conversion factor to adapt to screen pixels if needed.
    */
  def mozInnerScreenX: Int = js.native

  /**
    * Read-only: Returns the vertical (Y) coordinate of the top-left corner of the window's viewport, in screen
    * coordinates. This value is reported in CSS pixels. See mozScreenPixelsPerCSSPixel for a conversion factor
    * to adapt to screen pixels if needed.
    */
  def mozInnerScreenY: Int = js.native

  /**
    * Read-only: Returns the number of times the current document has been rendered to the screen in this window.
    * This can be used to compute rendering performance.
    */
  def mozPaintCount: Int = js.native

  /**
    * TBD
    */
  var MozWebSocket: js.UndefOr[WebSocket] = js.native

  /**
    * Gets/sets the name of the window.
    */
  def name: String = js.native

  /**
    * Read-only: Returns a reference to the navigator object.
    */
  def navigator: Navigator = js.native

  /**
    * Returns a reference to the window that opened this current window.
    */
  def opener: js.Any = js.native

  /**
    * Read-only: Returns the orientation in degrees (in 90 degree increments) of the viewport relative to the device's natural orientation.
    */
  def orientation: js.Any = js.native

  /**
    * Read-only: Gets the height of the outside of the browser window.
    */
  def outerHeight: Int = js.native

  /**
    * Read-only: Gets the width of the outside of the browser window.
    */
  def outerWidth: Int = js.native

  /**
    * Read-only: An alias for window.scrollX.
    */
  def pageXOffset: Int = js.native

  /**
    * Read-only: An alias for window.scrollY
    */
  def pageYOffset: Int = js.native

  /**
    * Read-only: Returns a reference to the parent of the current window or subframe.
    */
  def parent: Frame = js.native

  /**
    * Read-only: Provides a hosting area for performance related attributes.
    */
  def performance: Performance = js.native

  /**
    * Read-only: Returns the personalbar object, whose visibility can be toggled in the window.
    */
  def personalbar: String = js.native

  /**
    * Formerly provided access to install and remove PKCS11 modules (Obsolete since Gecko 29)
    */
  def pkcs11: String = js.native

  /**
    * The return value to be returned to the function that called window.showModalDialog() to display the window as a modal dialog.
    */
  def returnValue: js.Any = js.native

  /**
    * Read-only: Returns a reference to the screen object associated with the window.
    */
  def screen: js.Any = js.native

  /**
    * Read-only: Returns the horizontal distance of the left border of the user's browser from the left side of the screen.
    */
  def screenX: Int = js.native

  /**
    * Read-only: Returns the vertical distance of the top border of the user's browser from the top side of the screen.
    */
  def screenY: Int = js.native

  /**
    * Read-only: Returns the scrollbars object, whose visibility can be toggled in the window.
    */
  def scrollbars: js.Any = js.native

  /**
    * Read-only: The maximum offset that the window can be scrolled to horizontally, that is the document width minus the viewport width.
    */
  def scrollMaxX: Int = js.native

  /**
    * Read-only: The maximum offset that the window can be scrolled to vertically (i.e., the document height minus the viewport height).
    */
  def scrollMaxY: Int = js.native

  /**
    * Read-only: Returns the number of pixels that the document has already been scrolled horizontally.
    */
  def scrollX: Int = js.native

  /**
    * Read only: Returns the number of pixels that the document has already been scrolled vertically.
    */
  def scrollY: Int = js.native

  /**
    * Read-only: Returns an object reference to the window object itself.
    */
  def self: this.type = js.native

  /**
    * Returns a storage object for storing data within a single page session.
    */
  def storageStorage: js.Any = js.native

  /**
    * Read-only: Returns a reference to the session storage object used to store data that may only be accessed by
    * the origin that created it.
    */
  def sessionStorage: SessionStorage = js.native

  /**
    * Read-only: Returns a reference to the window object of the sidebar.
    */
  def sidebar: this.type = js.native

  /**
    * Read-only: Returns a SpeechSynthesis object, which is the entry point into using Web Speech API
    * speech synthesis functionality.
    */
  def speechSynthesis: SpeechSynthesis = js.native

  /**
    * Gets/sets the text in the statusbar at the bottom of the browser.
    */
  var status: String = js.native

  /**
    * Read-only: Returns the statusbar object, whose visibility can be toggled in the window.
    */
  def statusbar: js.Any = js.native

  /**
    * Read-only: Returns the toolbar object, whose visibility can be toggled in the window.
    */
  def toolbar: js.Any = js.native

  /**
    * Read-only: Returns a reference to the topmost window in the window hierarchy. This property is read only.
    */
  def top: js.Any = js.native

  /**
   * returns an object that provides static methods used for creating and managing object URLs. 
   * It can also be called as a constructor to construct URL objects.
   */
  def URL: URL = js.native
  
  /**
    * TODO
    */
  var WebSocket: js.UndefOr[WebSocket] = js.native

  /**
    * Read-only: Returns a reference to the current window.
    */
  def window: this.type = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    *
    * Returns a reference to the window object in the frames. See Window.frames for more details.
    * @param index the window index
    * @return the window instance at the given index
    */
  @JSBracketAccess
  def apply(index: Int): Frame = js.native

  /**
    * Displays an alert box with a message and an OK button
    * @param message Optional. Specifies the text to display in the alert box, or an object converted into a string and displayed
    */
  def alert(message: String | js.Any = js.native): Unit = js.native

  /**
    * Decodes a base-64 encoded string
    * @param encodedStr Required. The string which has been encoded by the btoa() method
    */
  def atob(encodedStr: String): String = js.native

  /**
    * Removes focus from the current window
    */
  def blur(): Unit = js.native

  /**
    * Encodes a string in base-64
    * @param str Required. The string to be encoded
    * @return A String, representing the base-64 encoded string
    */
  def btoa(str: String): String = js.native

  /**
    * Clears a timer set with setInterval()
    * @param interval Required. The ID of the timer returned by the setInterval() method
    */
  def clearInterval(interval: Interval): Unit = js.native

  /**
    * Clears a timer set with setTimeout()
    * @param timeout Required. The ID value of the timer returned by the setTimeout() method
    */
  def clearTimeout(timeout: Timeout): Unit = js.native

  /**
    * Closes the current window
    */
  def close(): Unit = js.native

  /**
    * Displays a dialog box with a message and an OK and a Cancel button
    * @param message Optional. Specifies the text to display in the confirm box
    */
  def confirm(message: String | js.Any = js.native): Unit = js.native

  /**
    * Sets focus to the current window
    */
  def focus(): Unit = js.native

  /**
    * Gets the current computed CSS styles applied to an element
    * @param element       Required. The element to get the computed style for
    * @param pseudoElement Optional. A pseudo-element to get
    * @return A CSSStyleDeclaration object containing CSS declaration block of the element.
    */
  def getComputedStyle(element: Element, pseudoElement: Element = js.native): CSSStyleDeclaration = js.native

  /**
    * Returns a Selection object representing the range of text selected by the user
    */
  def getSelection(): Selection = js.native

  /**
    * Returns a MediaQueryList object representing the specified CSS media query string
    */
  def matchMedia(mediaQueryString: String): MediaQueryList = js.native

  /**
    * Moves a window relative to its current position
    */
  def moveBy(deltaX: Int, deltaY: Int): Unit = js.native

  /**
    * Moves a window to the specified position
    */
  def moveTo(x: Int, y: Int): Unit = js.native

  /**
    * Opens a new browser window
    */
  def open(url: String, windowName: String, windowFeatures: js.Any = js.native): this.type = js.native

  /**
    * Opens a new dialog window.
    */
  def openDialog(url: String, name: String, features: String, args: js.Any*): this.type = js.native

  /**
    * The Window.postMessage() method safely enables cross-origin communication. Normally, scripts on different pages
    * are allowed to access each other if and only if the pages that executed them are at locations with the same
    * protocol (usually both https), port number (443 being the default for https), and host (modulo Document.domain
    * being set by both pages to the same value). window.postMessage() provides a controlled mechanism to circumvent
    * this restriction in a way which is secure when properly used.
    * @param message      Data to be sent to the other window. The data is serialized using the structured clone algorithm.
    *                     This means you can pass a broad variety of data objects safely to the destination window without
    *                     having to serialize them yourself.
    * @param targetOrigin Specifies what the origin of otherWindow must be for the event to be dispatched, either as the
    *                     literal string "*" (indicating no preference) or as a URI. If at the time the event is scheduled
    *                     to be dispatched the scheme, hostname, or port of otherWindow's document does not match that
    *                     provided in targetOrigin, the event will not be dispatched; only if all three match will the
    *                     event be dispatched. This mechanism provides control over where messages are sent.
    * @param transfer     Optional: Is a sequence of Transferable objects that are transferred with the message.
    *                     The ownership of these objects is given to the destination side and they are no longer
    *                     usable on the sending side.
    */
  def postMessage(message: String, targetOrigin: String, transfer: Boolean = js.native): Unit = js.native

  /**
    * Prints the content of the current window
    */
  def print(): Unit = js.native

  /**
    * The Window.prompt() displays a dialog with an optional message prompting the user to input some text.
    * @return a string containing the text entered by the user, or null.
    */
  def prompt(): String = js.native

  /**
    * The Window.prompt() displays a dialog with an optional message prompting the user to input some text.
    * @param message is a string of text to display to the user. This parameter is optional and can be omitted
    *                if there is nothing to show in the prompt window.
    * @param default is a string containing the default value displayed in the text input field. It is an optional
    *                parameter. Note that in Internet Explorer 7 and 8, if you do not provide this parameter,
    *                the string "undefined" is the default value.
    * @return a string containing the text entered by the user, or null.
    */
  def prompt(message: String, default: String = js.native): String = js.native

  /**
    * Resizes the window by the specified pixels
    */
  def resizeBy(xDelta: Int, yDelta: Int): Unit = js.native

  /**
    * Resizes the window to the specified width and height
    */
  def resizeTo(aWidth: Int, aHeight: Int): Unit = js.native

  /**
    * Deprecated. This method has been replaced by the scrollTo() method.
    * @param x_coord is the pixel along the horizontal axis of the document that you want displayed in the upper left.
    * @param y_coord is the pixel along the vertical axis of the document that you want displayed in the upper left.
    */
  def scroll(x_coord: Int, y_coord: Int): Unit = js.native

  /**
    * Scrolls the document by the specified number of pixels
    * @param x is the offset in pixels to scroll horizontally.
    * @param y is the offset in pixels to scroll vertically.
    */
  def scrollBy(x: Int, y: Int): Unit = js.native

  /**
    * Scrolls the document to the specified coordinates
    * @param x_coord is the pixel along the horizontal axis of the document that you want displayed in the upper left.
    * @param y_coord is the pixel along the vertical axis of the document that you want displayed in the upper left.
    */
  def scrollTo(x_coord: Int, y_coord: Int): Unit = js.native

  /**
    * Calls a function or evaluates an expression at specified intervals (in milliseconds)
    */
  def setInterval(func: js.Function | String, delay: Int, params: js.Any*): Interval = js.native

  /**
    * Calls a function or evaluates an expression after a specified number of milliseconds
    */
  def setTimeout(func: js.Function | String, delay: Int, params: js.Any*): Timeout = js.native

  /**
    * Stops the window from loading
    */
  def stop(): Unit = js.native

}

/**
  * Window Companion
  * @author lawrence.daniels@gmail.com
  */
object Window {

  @js.native
  trait Interval extends js.Object

  @js.native
  trait Timeout extends js.Object

  @js.native
  trait CacheStorage extends js.Object

  @js.native
  trait History extends js.Object

  @js.native
  trait LocalStorage extends js.Object

  @js.native
  trait Menubar extends js.Object

  @js.native
  trait Navigator extends js.Object

  @js.native
  trait OfflineResourceList extends js.Object

  @js.native
  trait SessionStorage extends js.Object

  @js.native
  trait SpeechSynthesis extends js.Object
  
  /**
   * @see https://developer.mozilla.org/en-US/docs/Web/API/Window/URL
   */
  @js.native
  trait URL extends js.Object {

    def createObjectURL(value: js.Any): String = js.native

  }

  @js.native
  trait XULControllers extends js.Object

}
