package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * MongoDB Write Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteResult extends js.Object {
  var result: WriteResult.Details = js.native
  var ops: js.Array[js.Any] = js.native
  var insertedCount: Int = js.native
  var insertedIds: js.Array[String] = js.native
}

/**
  * Write Result Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteResult {

  /**
    * MongoDB Write Result Details
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Details extends js.Object {
    var ok: Int = js.native
    var n: Int = js.native
  }

  /**
    * Write Result Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WriteResultExtensions(val wr: WriteResult) extends AnyVal {

    @inline
    def opsAs[T]: js.Array[T] = wr.ops.asInstanceOf[js.Array[T]]

  }

}