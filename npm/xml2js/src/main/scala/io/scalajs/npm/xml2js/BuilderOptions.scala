package io.scalajs.npm.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Builder Options
  * @param rootName            Root element name to be used in case explicitRoot is false or to override the root element name.
  *                            (default root or the root key name)
  * @param renderOpts          Rendering options for xmlbuilder-js.pretty: prettify generated XML.
  *                            (default { 'pretty': true, 'indent': ' ', 'newline': '\n' })
  * @param indent              Whitespace for indentation (only when pretty)
  * @param xmldec              XML declaration attributes (default { 'version': '1.0', 'encoding': 'UTF-8', 'standalone': true }).
  *                            xmldec.version - A version number string, e.g. 1.0
  *                            xmldec.encoding - Encoding declaration, e.g. UTF-8
  *                            xmldec.standalone - Standalone document declaration: true or false
  * @param newline             Newline char (only when pretty)
  * @param doctype             Optional DTD. Eg. {'ext': 'hello.dtd'} (default null)
  * @param headless            Omit the XML header. Added in 0.4.3  (default: false)
  * @param allowSurrogateChars Allows using characters from the Unicode surrogate blocks (default: false)
  * @param cdata               Wrap text nodes in {{{<![CDATA[ ... ]]>}}} instead of escaping when necessary (default: false).
  *                            Does not add {{{<![CDATA[ ... ]]>}}} if it is not required. Added in 0.4.5.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BuilderOptions(var rootName: js.UndefOr[String] = js.undefined,
                     var renderOpts: js.UndefOr[RenderOptions] = js.undefined,
                     var indent: js.UndefOr[String] = js.undefined,
                     var xmldec: js.UndefOr[XmlDeclarationOptions] = js.undefined,
                     var newline: js.UndefOr[String] = js.undefined,
                     var doctype: js.UndefOr[String] = js.undefined,
                     var headless: js.UndefOr[Boolean] = js.undefined,
                     var allowSurrogateChars: js.UndefOr[Boolean] = js.undefined,
                     var cdata: js.UndefOr[Boolean] = js.undefined) extends js.Object