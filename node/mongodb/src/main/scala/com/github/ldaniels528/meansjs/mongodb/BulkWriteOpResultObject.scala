package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * Bulk Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BulkWriteOpResultObject extends js.Object {
  // Number of documents inserted.
  var insertedCount: Int = js.native

  // Number of documents matched for update.
  var matchedCount: Int = js.native

  // Number of documents modified.
  var modifiedCount: Int = js.native

  //  Number of documents deleted.
  var deletedCount: Int = js.native

  // Number of documents upserted.
  var upsertedCount: Int = js.native

  // Inserted document generated Id's, hash key is the index of the originating operation
  var insertedIds: js.Array[String] = js.native

  // Upserted document generated Id's, hash key is the index of the originating operation
  var upsertedIds: js.Array[String] = js.native

  // The command result object.
  var result: js.Any = js.native

}
