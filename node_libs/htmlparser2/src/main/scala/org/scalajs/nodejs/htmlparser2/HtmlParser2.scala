package org.scalajs.nodejs.htmlparser2

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * htmlparser2 - A forgiving HTML/XML/RSS parser. The parser can handle streams and provides a callback interface.
  * @version 3.9.1
  * @see [[https://www.npmjs.com/package/htmlparser2]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HtmlParser2 extends NodeModule {

  def Parser: ParserClass = js.native

}

/**
  * HtmlParser2 Companion
  * @author lawrence.daniels@gmail.com
  */
object HtmlParser2 {

  @inline
  def apply()(implicit require: NodeRequire) = {
    require[HtmlParser2]("htmlparser2")
  }

}