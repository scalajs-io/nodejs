package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Delete Write Operation Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DeleteWriteOpResult extends js.Object {

  /** The raw result returned from MongoDB, field will vary depending on server version. */
  var result: DeleteWriteOpResult.Outcome = js.native

  /** The connection object used for the operation. */
  var connection: Connection = js.native

  /** The number of documents deleted. */
  var deletedCount: Int = js.native

}

/**
  * Delete Write Operation Result Companion
  * @author lawrence.daniels@gmail.com
  */
object DeleteWriteOpResult {

  /**
    * Delete Outcome
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Outcome extends js.Object with Okayable {

    /** The total count of documents deleted. */
    var n: Int = js.native
  }

}
