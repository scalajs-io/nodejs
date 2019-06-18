package io.scalajs.npm.mongodb

import io.scalajs.npm.mongodb.BulkWriteOpResultObject.MongnoIdRef

import scala.scalajs.js


/**
  * Bulk Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */

trait BulkWriteOpResultObject extends js.Object {
  // Number of documents inserted.
  val nInserted: Int

  // Number of documents matched for update.
  val nMatched: Int

  // Number of documents modified.
  val nModified: Int

  //  Number of documents deleted.
  val nRemoved: Int

  // Number of documents upserted.
  val nUpserted: Int

  // Inserted document generated Id's, hash key is the index of the originating operation
  val insertedIds: js.Array[MongnoIdRef]

  // Upserted document generated Id's, hash key is the index of the originating operation
  val upsertedIds: js.Array[MongnoIdRef]

  val upserted: js.Array[MongnoIdRef]

  val writeConcernErrors: js.Array[js.Any]

  val writeErrors: js.Array[js.Any]

}

/**
  * Bulk Write Operation Result Object Companion
  * @author lawrence.daniels@gmail.com
  */
object BulkWriteOpResultObject {

  @js.native
  trait MongnoIdRef extends js.Object {
    val index: Int
    val _id: ObjectID
  }

}