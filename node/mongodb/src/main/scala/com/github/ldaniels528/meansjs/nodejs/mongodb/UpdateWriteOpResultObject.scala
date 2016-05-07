package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js

/**
  * Update Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UpdateWriteOpResultObject extends js.Object {
  // The raw result returned from MongoDB, field will vary depending on server version.
  var result: UpdateWriteOpResultObject.Result = js.native

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
  * Update Write Operation Result Object
  * @author lawrence.daniels@gmail.com
  */
object UpdateWriteOpResultObject {

  /**
    * Update Write Operation Result
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Result extends js.Object {
    // Is 1 if the command executed correctly.
    var ok: js.Any = js.native

    // The total count of documents scanned.
    var n: js.Any = js.native

    // The total count of documents modified.
    var nModified: js.Any = js.native
  }

}
