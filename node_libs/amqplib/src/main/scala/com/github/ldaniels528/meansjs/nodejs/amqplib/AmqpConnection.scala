package com.github.ldaniels528.meansjs.nodejs.amqplib

import com.github.ldaniels528.meansjs.nodejs.errors

import scala.scalajs.js

/**
  * AMQP Connection
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmqpConnection extends js.Object {

  /**
    * Resolves to an open Channel (The callback version returns the channel; but it is not usable before the callback
    * has been invoked). May fail if there are no more channels available (i.e., if there are already channelMax channels open).
    * @return a promise of an opened channel
    */
  def createChannel(): js.Promise[AmqpChannel] = js.native

  /**
    * Close the connection cleanly. Will immediately invalidate any unresolved operations, so it's best to make sure
    * you've done everything you need to before calling this. Will be resolved once the connection, and underlying socket,
    * are closed. The model will also emit 'close' at that point.
    * @return a promise of the closed status
    */
  def close(): js.Promise[errors.Error] = js.native

  /**
    * Close the connection cleanly. Will immediately invalidate any unresolved operations, so it's best to make sure
    * you've done everything you need to before calling this. Will be resolved once the connection, and underlying socket,
    * are closed. The model will also emit 'close' at that point.
    * @param callback the close result callback
    */
  def close(callback: js.Function): Unit = js.native

}
