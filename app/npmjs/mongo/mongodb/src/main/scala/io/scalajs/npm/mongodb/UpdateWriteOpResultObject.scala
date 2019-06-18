package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Update Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UpdateWriteOpResultObject extends js.Object {
  // The raw result returned from MongoDB, field will vary depending on server version.
  var result: UpdateWriteResult = js.native

  // The total count of documents modified.
  var nModified: Int = js.native

  // The connection object used for the operation.
  var connection: Connection = js.native

  // The number of documents that matched the filter.
  var matchedCount: Int = js.native

  // The number of documents that were modified.
  var modifiedCount: Int = js.native

  // The number of documents upserted.
  var upsertedCount: Int = js.native

  // The upserted id.
  var upsertedId: String = js.native

}

/**
  * Update Write Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UpdateWriteResult extends js.Object with Okayable {

  // The total count of documents scanned.
  def n: Int = js.native

  // The total count of documents modified.
  def nModified: Int = js.native

}
