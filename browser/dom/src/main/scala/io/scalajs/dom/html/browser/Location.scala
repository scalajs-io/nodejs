package io.scalajs.dom.html.browser

import scala.scalajs.js

/**
  * Window Location object
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Location
  */
@js.native
class Location extends js.Object {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * Is a DOMString containing the entire URL. If changed, the associated document navigates to the new page.
    * It can be set from a different origin than the associated document.
    */
  var href: String = js.native

  /**
    * Is a DOMString containing the protocol scheme of the URL, including the final ':'.
    */
  var protocol: String = js.native

  /**
    * Is a DOMString containing the host, that is the hostname, a ':', and the port of the URL.
    */
  var host: String = js.native

  /**
    * Is a DOMString containing the domain of the URL.
    */
  var hostname: String = js.native

  /**
    * Is a DOMString containing the port number of the URL.
    */
  var port: String = js.native

  /**
    * Is a DOMString containing an initial '/' followed by the path of the URL.
    */
  var pathname: String = js.native

  /**
    * Is a DOMString containing a '?' followed by the parameters of the URL. Also known as "querystring".
    */
  var search: String = js.native

  /**
    * Is a DOMString containing a '#' followed by the fragment identifier of the URL.
    */
  var hash: String = js.native

  /**
    * Is a DOMString containing the username specified before the domain name.
    */
  var username: String = js.native

  /**
    * Is a DOMString containing the password specified before the domain name.
    */
  var password: String = js.native

  /**
    * Read-only: Returns a DOMString containing the canonical form of the origin of the specific location.
    */
  def origin: String = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Loads the resource at the URL provided in parameter.
    */
  def assign(url: String): Unit = js.native

  /**
    * Reloads the resource from the current URL. Its optional unique parameter is a Boolean, which, when it is true,
    * causes the page to always be reloaded from the server. If it is false or not specified, the browser may reload
    * the page from its cache.
    * @param forcedReload Optional: Is a Boolean flag, which, when it is true, causes the page to always be reloaded
    *                     from the server. If it is false or not specified, the browser may reload the page from its cache.
    */
  def reload(forcedReload: Boolean = js.native): Unit = js.native

  /**
    * Replaces the current resource with the one at the provided URL. The difference from the assign()
    * method is that after using replace() the current page will not be saved in session History, meaning
    * the user won't be able to use the back button to navigate to it.
    */
  def replace(url: String): Unit = js.native

}
