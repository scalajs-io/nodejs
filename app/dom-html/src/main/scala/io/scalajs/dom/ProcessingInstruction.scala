package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Processing Instruction
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("ProcessingInstruction")
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
