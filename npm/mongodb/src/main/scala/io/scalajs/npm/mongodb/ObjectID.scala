package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * MongoDB ObjectID
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "ObjectID")
class ObjectID() extends js.Object {

  def this(id: String) = this()

  /**
    * Creates an ObjectID from a hex string representation of an ObjectID.
    * @param hexString the given 24-byte hex string.
    * @return the created ObjectID
    */
  def createFromHexString(hexString: String): ObjectID = js.native

  /**
    * Creates an ObjectID from a second based number, with the rest of the ObjectID zeroed out.
    * Used for comparisons or sorting the ObjectID.
    * @param time an integer number representing a number of seconds.
    * @return the created ObjectID
    */
  def createFromTime(time: Integer): ObjectID = js.native

  /**
    * Compares the equality of this ObjectID with <code>otherID</code>.
    * @param otherID the ObjectID instance to compare against.
    * @return the result of comparing two ObjectID’s
    */
  def equals(otherID: ObjectID): Boolean = js.native

  /**
    * Returns the generation date (accurate up to the second) that this ID was generated.
    * @return the generation [[scala.scalajs.js.Date date]]
    */
  def getTimestamp(): js.Date = js.native

  /**
    * Checks if a value is a valid BSON ObjectId
    * @return true if the value is a valid BSON ObjectId; returns false otherwise.
    */
  def isValid(): Boolean = js.native

  /**
    * Returns the ObjectID id as a 24 byte hex string representation
    * @return a 24 byte hex string representation
    */
  def toHexString(): String = js.native

}
