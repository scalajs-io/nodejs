package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * The URL interface represent an object providing static methods used for creating object URLs.
  *
  * When using a user agent where no constructor has been implemented yet, it is possible to access such an object
  * using the Window.URL properties (prefixed with Webkit-based browser as Window.webkitURL).
  * @param urlString     Is a DOMString representing an absolute or relative URL. If urlString is a relative URL,
  *                      baseURLstring or baseURLobject, whichever is present, will be used as the base URL.
  *                      If urlString is an absolute URL, baseURLstring and baseURLobject are ignored.
  * @param baseURLString Is a DOMString representing the base URL to use in case urlString is a relative URL.
  *                      If not specified, and no baseURLobject is passed in parameters, it default to 'about:blank'.
  *                      If it is an invalid absolute URL, the constructor will raise a DOMException of type SYNTAX_ERROR
  * @see https://developer.mozilla.org/en-US/docs/Web/API/URL
  * @author lawrence.daniels@gmail.com
  */
@js.native
class URL(urlString: String, baseURLString: String) extends js.Object {

  /**
    * The URL interface represent an object providing static methods used for creating object URLs.
    *
    * When using a user agent where no constructor has been implemented yet, it is possible to access such an object
    * using the Window.URL properties (prefixed with Webkit-based browser as Window.webkitURL).
    * @param urlString     Is a DOMString representing an absolute or relative URL. If urlString is a relative URL,
    *                      baseURLString or baseURLObject, whichever is present, will be used as the base URL.
    *                      If urlString is an absolute URL, baseURLstring and baseURLobject are ignored.
    */
  def this(urlString: String) = this(urlString, null: String)

  /**
    * The URL interface represent an object providing static methods used for creating object URLs.
    *
    * When using a user agent where no constructor has been implemented yet, it is possible to access such an object
    * using the Window.URL properties (prefixed with Webkit-based browser as Window.webkitURL).
    * @param urlString     Is a DOMString representing an absolute or relative URL. If urlString is a relative URL,
    *                      baseURLString or baseURLObject, whichever is present, will be used as the base URL.
    *                      If urlString is an absolute URL, baseURLstring and baseURLobject are ignored.
    * @param baseURLObject Is a URL object representing the base URL to use in case urlString is a relative URL.
    */
  def this(urlString: String, baseURLObject: URL) = this(urlString, null: String)

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Is a DOMString containing a '#' followed by the fragment identifier of the URL.
    */
  def hash: String = js.native

  /**
    * Is a DOMString containing the host, that is the hostname, a ':', and the port of the URL.
    */
  def host: String = js.native

  /**
    * Is a DOMString containing the whole URL.
    */
  def href: String = js.native

  /**
    * Returns a DOMString containing the origin of the URL, that is its scheme, its domain and its port.
    */
  def origin: String = js.native

  /**
    * Is a DOMString containing an initial '/' followed by the path of the URL.
    */
  def pathname: String = js.native

  /**
    * Is a DOMString containing the password specified before the domain name.
    */
  def password: String = js.native

  /**
    * Is a DOMString containing the port number of the URL.
    */
  def port: String = js.native

  /**
    * Is a DOMString containing the protocol scheme of the URL, including the final ':'.
    */
  def protocol: String = js.native

  /**
    * Is a DOMString containing a '?' followed by the parameters of the URL.
    */
  def search: String = js.native

  /**
    * Returns a URLSearchParams object allowing to access the GET query arguments contained in the URL.
    * @return a [[URLSearchParams]] object
    */
  def searchParams: URLSearchParams = js.native

  /**
    * Is a DOMString containing the username specified before the domain name.
    */
  def username: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////


}

@js.native
@JSName("URL")
object URL extends js.Object {

  /**
    * The URL.createObjectURL() static method creates a DOMString containing an URL representing the object
    * given in parameter. The URL lifetime is tied to the document in the window on which it was created.
    * The new object URL represents the specified File object or Blob object.
    * @param blob Is a File object or a Blob object to create a object URL for.
    */
  def createObjectURL(blob: Blob | File): URL = js.native

  /**
    * Revokes an object URL previously created using URL.createObjectURL().
    */
  def revokeObjectURL(): Unit = js.native

}