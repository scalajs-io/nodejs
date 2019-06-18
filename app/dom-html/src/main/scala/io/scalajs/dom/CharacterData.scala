package io.scalajs.dom

import scala.scalajs.js

/**
  * The CharacterData interface provides a set of properties and methods for working with
  * text content (referred to as character data) in the DOM. This interface doesn't represent
  * any actual object, but is inherited by other interfaces which do — Text, Comment and CDATASection.
  * @author lawrence.daniels@gmail.com
  * @see http://reference.sitepoint.com/javascript/CharacterData/deleteData
  */
@js.native
trait CharacterData extends Node {

  /**
    * Append a string to the end of this character data.
    * After a successful operation, the data and length properties of the node reflect the change.
    * @param string The string to append.
    */
  def appendData(string: String): Unit = js.native

  /**
    * The character data of a Text, Comment or CDATASection node, or the data in a ProcessingInstruction node.
    * This property is read/write.
    */
  def data: String = js.native

  /**
    * Delete a string from this character data, between specified offsets.
    * After a successful operation, the data and length properties of the node reflect the change.
    * @param offset The character offset from which to start removing.
    * @param count  The number of characters to delete. If offset plus count exceeds
    *               the length of the data then everything from offset to the end is deleted.
    */
  def deleteData(offset: Int, count: Int): Unit = js.native

  /**
    * Insert a string into this character data at a specified character offset.
    * After a successful operation, the data and length properties of the node reflect the change.
    * @param offset The character offset at which to insert.
    * @param string The string to insert.
    */
  def insertData(offset: Int, string: String): Unit = js.native

  /**
    * The number of items in a collection (a NamedNodeMap or NodeList), or the number of characters in
    * the string value of a character data node (CDATASection, Comment or Text).
    */
  def length: Int = js.native

  /**
    * Insert a string to replace the character data between specified offsets, equivalent to deleteData
    * and insertData in a single operation.
    * After a successful operation, the data and length properties of the node reflect the change.
    * @param offset The character offset from which to start replacing.
    * @param count  The number of characters to replace. If offset plus count exceeds the length of the
    *               data then everything from offset to the end is replaced (equivalent to calling
    *               deleteData with the specified offset and count, followed by appendData with
    *               the specified string).
    * @param string The string with which the specified range is to be replaced.
    */
  def replaceData(offset: Int, count: Int, string: String): Unit = js.native

  /**
    * Extract the character data between specified character offsets.
    * @param offset The character offset to start from.
    * @param count  The number of characters to return. If offset plus count
    *               exceeds the length of the data then everything from offset
    *               to the end is returned.
    * @return the character data between specified character offsets.
    */
  def substringData(offset: Int, count: Int): String = js.native

}
