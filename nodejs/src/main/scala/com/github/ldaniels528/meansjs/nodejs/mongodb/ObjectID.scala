package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * MongoDB ObjectID Facade
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ObjectID extends js.Object {

  /**
    * Creates an ObjectID from a hex string representation of an ObjectID.
    * @param hexString the given 24-byte hex string.
    * @return the created ObjectID
    */
  def createFromHexString(hexString: String): ObjectID

  /**
    * Creates an ObjectID from a second based number, with the rest of the ObjectID zeroed out.
    * Used for comparisons or sorting the ObjectID.
    * @param time an integer number representing a number of seconds.
    * @return the created ObjectID
    */
  def createFromTime(time: Number): ObjectID

  /**
    * Compares the equality of this ObjectID with <code>otherID</code>.
    * @param otherID the ObjectID instance to compare against.
    * @return the result of comparing two ObjectID’s
    */
  def equals(otherID: ObjectID): Boolean

  /**
    * Returns the generation date (accurate up to the second) that this ID was generated.
    * @return the generation [[js.Date date]]
    */
  def getTimestamp(): js.Date

  /**
    * Checks if a value is a valid BSON ObjectId
    * @return true if the value is a valid BSON ObjectId; returns false otherwise.
    */
  def isValid(): Boolean

  /**
    * Returns the ObjectID id as a 24 byte hex string representation
    * @return a 24 byte hex string representation
    */
  def toHexString(): String

}

/**
  * MongoDB ObjectID Companion
  * @author lawrence.daniels@gmail.com
  */
object ObjectID {

  /**
    * Mongo Database Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoObjectIDEnrich(val objectID: ObjectID) extends AnyVal {

    def apply() = js.Dynamic.newInstance(objectID.asInstanceOf[js.Dynamic])().as[ObjectID]

    def apply(id: js.Any) = js.Dynamic.newInstance(objectID.asInstanceOf[js.Dynamic])(id).as[ObjectID]

  }

}