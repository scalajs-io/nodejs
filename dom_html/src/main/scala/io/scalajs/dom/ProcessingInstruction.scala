package io.scalajs.dom

import scala.scalajs.js

/**
  * Processing Instruction
  * @author lawrence.daniels@gmail.com
  */
@js.native
class ProcessingInstruction extends js.Object {

  /**
    * The character data of a [[Text]], [[Comment]] or [[CDATASection]] node,
    * or the data in a ProcessingInstruction node.
    */
  var data: String = js.native

  /**
    * The target of a ProcessingInstruction node, ie. the token immediately
    * after the opening delimiter.
    */
  def target: Node = js.native

}
