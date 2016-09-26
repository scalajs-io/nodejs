package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.mongodb.BulkWriteOpResultObject.MongnoIdRef

import scala.scalajs.js

/**
  * Bulk Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BulkWriteOpResultObject extends js.Object {
  // Number of documents inserted.
  val nInserted: Int = js.native

  // Number of documents matched for update.
  val nMatched: Int = js.native

  // Number of documents modified.
  val nModified: Int = js.native

  //  Number of documents deleted.
  val nRemoved: Int = js.native

  // Number of documents upserted.
  val nUpserted: Int = js.native

  // Inserted document generated Id's, hash key is the index of the originating operation
  val insertedIds: js.Array[MongnoIdRef] = js.native

  // Upserted document generated Id's, hash key is the index of the originating operation
  val upsertedIds: js.Array[MongnoIdRef] = js.native

  val upserted: js.Array[MongnoIdRef] = js.native

  val writeConcernErrors: js.Array[js.Any] = js.native

  val writeErrors: js.Array[js.Any] = js.native

}

/**
  * Bulk Write Operation Result Object Companion
  * @author lawrence.daniels@gmail.com
  */
object BulkWriteOpResultObject {

  @js.native
  trait MongnoIdRef extends js.Object {
    val index: Int = js.native
    val _id: ObjectID = js.native
  }

}