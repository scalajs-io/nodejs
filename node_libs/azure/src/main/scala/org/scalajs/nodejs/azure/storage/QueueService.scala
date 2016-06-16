package org.scalajs.nodejs.azure.storage

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Queue Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait QueueService extends js.Object {

  def deleteMessage(queueName: String, messageID: String, receiptID: String, callback: js.Function): Unit = js.native

  def getMessages(queueName: String, callback: js.Function): Unit = js.native

}

/**
  * Queue Service Companion
  * @author lawrence.daniels@gmail.com
  */
object QueueService {

  /**
    * Queue Service Extensions
    * @param queueService the given [[QueueService queue service]]
    */
  implicit class QueueServiceServiceExtensions(val queueService: QueueService) extends AnyVal {

    @inline
    def deleteMessageFuture(queueName: String, messageID: String, receiptID: String) = {
      futureCallbackE1[errors.Error, js.Any](queueService.deleteMessage(queueName, messageID, receiptID, _))
    }

    @inline
    def getMessagesFuture(queueName: String) = {
      futureCallbackE1[errors.Error, js.Array[ServerMessage]](queueService.getMessages(queueName, _))
    }

  }

}