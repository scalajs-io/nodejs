package io.scalajs.npm.jsdom

import io.scalajs.dom.Document
import io.scalajs.nodejs.{Error, NodeOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * A JavaScript implementation of the WHATWG DOM and HTML standards, for use with Node.js.
  * @version 9.9.1
  * @see https://github.com/tmpvar/jsdom
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JsDom extends js.Object {

  def blobToBuffer: js.Function = js.native

  def createCookieJar(): CookieJar = js.native

  def created(callback: js.Function2[js.Any, JsDomWindowWithJQuery, Any]): Unit = js.native

  def defaultView: JsDomWindowWithJQuery = js.native

  /**
    * Creates a new DOM environment
    * @param content  may be a URL, file name, or HTML fragment
    * @param scripts  a string or array of strings, containing file names or URLs that will be inserted as <script> tags
    * @param config   the given configuration object
    * @param callback takes two arguments:
    *                 1. err: either null, if nothing goes wrong, or an error, if the window could not be created
    *                 2. window: a brand new window, if there wasn't an error
    * @return a new DOM environment
    */
  def env(content: String,
          scripts: js.Array[String],
          config: js.Any = js.native,
          callback: js.Function2[Error, JsDomWindowWithJQuery, Any]): js.Any = js.native

  /**
    * Creates a new DOM environment
    * @param config the given configuration object
    * @return a new DOM environment
    */
  def env(config: EnvironmentOptions | js.Any): js.Any = js.native

  def evalVMScript: js.Function = js.native

  def getVirtualConsole(window: JsDomWindowWithJQuery): VirtualConsole = js.native

  def jQueryify: js.Function = js.native

  def jsdom: JsDom = js.native

  def jsdom(html: String, options: EnvironmentOptions | NodeOptions = js.native): Document = js.native

  def nodeLocation: js.Function = js.native

  def sendTo(console: VirtualConsole): VirtualConsole = js.native

}

/**
  * JsDom Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("jsdom", JSImport.Namespace)
object JsDom extends JsDom