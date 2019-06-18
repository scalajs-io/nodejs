package io.scalajs.dom

/**
  * Node Type Constants
  * +---------------------------+----+
  * | Element                   |  1 |
  * | Attr                      |  2 |
  * | Text                      |  3 |
  * | CDATASection              |  4 |
  * | EntityReference           |  5 |
  * | Entity                    |  6 |
  * | ProcessingInstruction	    |  7 |
  * | Comment                   |  8 |
  * | Document                  |  9 |
  * | DocumentType              | 10 |
  * | DocumentFragment          | 11 |
  * | Notation                  | 12 |
  * +---------------------------+----+
  */
object NodeTypes {

  type NodeType = Int

  val ELEMENT: NodeType                = 1
  val ATTR: NodeType                   = 2
  val TEXT: NodeType                   = 3
  val CDATA_SECTION: NodeType          = 4
  val ENTITY_REFERENCE: NodeType       = 5
  val ENTITY: NodeType                 = 6
  val PROCESSING_INSTRUCTION: NodeType = 7
  val COMMENT: NodeType                = 8
  val DOCUMENT: NodeType               = 9
  val DOCUMENT_TYPE: NodeType          = 10
  val DOCUMENT_FRAGMENT: NodeType      = 11
  val NOTATION: NodeType               = 12

}
