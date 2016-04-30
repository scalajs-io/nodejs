package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * Find And Modify Write Operation Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FindAndModifyWriteOpResult extends js.Object {

  /** Document returned from findAndModify command. */
  var value: js.Any = js.native

  /** The raw lastErrorObject returned from the command. */
  var lastErrorObject: js.Any = js.native

  /** Is 1 if the command executed correctly. */
  var ok: Int = js.native

}

/**
  * Find And Modify Write Operation Result Companion
  * @author lawrence.daniels@gmail.com
  */
object FindAndModifyWriteOpResult {

  /**
    * Find And Modify Write Operation Result Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class FindAndModifyWriteOpResultExtensions(val result: FindAndModifyWriteOpResult) extends AnyVal {

    def valueAs[T] = result.value.asInstanceOf[js.UndefOr[T]]

  }

}