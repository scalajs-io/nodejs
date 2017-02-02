package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Insert Write Operation Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait InsertWriteOpResult extends js.Object {

  /** The total amount of documents inserted. */
  var insertedCount: Int = js.native

  /**
    * All the documents inserted using insertOne/insertMany/replaceOne. Documents contain the _id field
    * if forceServerObjectId == false for insertOne/insertMany
    */
  var ops: js.Array[js.Any] = js.native

  /** All the generated id's for the inserted documents. */
  var insertedIds: js.Array[String] = js.native

  /** The connection object used for the operation. */
  var connection: Connection = js.native

  /** The raw command result object returned from MongoDB (content might vary by server version). */
  var result: InsertWriteOpResult.Result = js.native

}

/**
  * Insert Write Operation Result Companion
  * @author lawrence.daniels@gmail.com
  */
object InsertWriteOpResult {

  /**
    * Insert Write Operation Result Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WriteResultExtensions(val result: InsertWriteOpResult) extends AnyVal {

    @inline def isOk = result.insertedCount >= 1

    @inline def opsAs[T]: js.Array[T] = result.ops.asInstanceOf[js.Array[T]]

  }

  /**
    * Insert Write Operation Result
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Result extends js.Object {
    // ok == 1 when successful
    var ok: Int = js.native

    // Is 1 if the command executed correctly.
    var n: Int = js.native // The total count of documents inserted.
  }

}
