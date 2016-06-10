package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Builder Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BuilderOptions extends js.Object {

  /**
    * Root element name to be used in case explicitRoot is false or to override the root element name.
    * (default root or the root key name)
    */
  var rootName: js.UndefOr[String] = _

  /**
    * Rendering options for xmlbuilder-js.pretty: prettify generated XML.
    * (default { 'pretty': true, 'indent': ' ', 'newline': '\n' })
    */
  var renderOpts: js.UndefOr[RenderOptions] = _

  /** Whitespace for indentation (only when pretty) */
  var indent: js.UndefOr[String] = _

  /**
    * XML declaration attributes (default { 'version': '1.0', 'encoding': 'UTF-8', 'standalone': true }).
    * xmldec.version - A version number string, e.g. 1.0
    * xmldec.encoding - Encoding declaration, e.g. UTF-8
    * xmldec.standalone - Standalone document declaration: true or false
    */
  var xmldec: js.UndefOr[XmlDeclarationOptions] = _

  /**
    * Newline char (only when pretty)
    */
  var newline: js.UndefOr[String] = _

  /** Optional DTD. Eg. {'ext': 'hello.dtd'} (default null) */
  var doctype: js.UndefOr[String] = _

  /** Omit the XML header. Added in 0.4.3  (default: false) */
  var headless: js.UndefOr[Boolean] = _

  /** Allows using characters from the Unicode surrogate blocks (default: false) */
  var allowSurrogateChars: js.UndefOr[Boolean] = _

  /**
    * Wrap text nodes in <![CDATA[ ... ]]> instead of escaping when necessary (default: false).
    * Does not add <![CDATA[ ... ]]> if it is not required. Added in 0.4.5.
    */
  var cdata: js.UndefOr[Boolean] = _

}

/**
  * Builder Options
  * @author lawrence.daniels@gmail.com
  */
object BuilderOptions {

  def apply(rootName: js.UndefOr[String] = js.undefined,
            renderOpts: js.UndefOr[RenderOptions] = js.undefined,
            indent: js.UndefOr[String] = js.undefined,
            xmldec: js.UndefOr[XmlDeclarationOptions] = js.undefined,
            newline: js.UndefOr[String] = js.undefined,
            doctype: js.UndefOr[String] = js.undefined,
            headless: js.UndefOr[Boolean] = js.undefined,
            allowSurrogateChars: js.UndefOr[Boolean] = js.undefined) = {
    val options = new BuilderOptions()
    options.rootName = rootName
    options.renderOpts = renderOpts
    options.indent = indent
    options.xmldec = xmldec
    options.newline = newline
    options.doctype = doctype
    options.headless = headless
    options.allowSurrogateChars = allowSurrogateChars
    options
  }

}