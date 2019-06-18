package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * The CDATASection interface inherits from CharacterData through Text, and represents a CDATA section in XML.
  *
  * CDATA sections are used to escape blocks of text that would otherwise be treated as markup.
  * In web development they're often used for including unpredictable HTML inside another form of XML,
  * or for programmatic code like scripts and style information.
  *
  * A CDATASection node cannot have children.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("CDATASection")
class CDATASection extends Text