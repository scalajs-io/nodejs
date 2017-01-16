package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Update Write Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UpdateWriteResult extends js.Object {
  // Is 1 if the command executed correctly.
  def ok: Int = js.native

  // The total count of documents scanned.
  def n: Int = js.native

  // The total count of documents modified.
  def nModified: Int = js.native

}

/**
  * Update Write Result Companion
  * @author lawrence.daniels@gmail.com
  */
object UpdateWriteResult {

  /**
    * Update Write Result Extensions
    * @param result the given [[UpdateWriteResult update write result]]
    */
  implicit class UpdateWriteResultExtensions(val result: UpdateWriteResult) extends AnyVal {

    @inline
    def isOk = result.ok == 1

  }

}