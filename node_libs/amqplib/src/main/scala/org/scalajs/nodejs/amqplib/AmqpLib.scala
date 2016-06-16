package org.scalajs.nodejs.amqplib

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * AMQP Library for Node
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/amqplib
  * @version 0.4.1
  */
@js.native
trait AmqpLib extends NodeModule {

  /**
    * Connect to an AMQP 0-9-1 server, optionally given an AMQP URL (see AMQP URI syntax) and socket options.
    * The protocol part (amqp: or amqps:) is mandatory; defaults for elided parts are as given in
    * 'amqp://guest:guest@localhost:5672'. If the URI is omitted entirely, it will default to 'amqp://localhost',
    * which given the defaults for missing parts, will connect to a RabbitMQ installation with factory settings, on localhost.
    * @param url           the AMQP url
    * @param socketOptions the optional socket options
    * @return a promise of a connection
    */
  def connect(url: String, socketOptions: js.Any = null): js.Promise[AmqpConnection] = js.native

  /**
    * Connect to an AMQP 0-9-1 server, optionally given an AMQP URL (see AMQP URI syntax) and socket options.
    * The protocol part (amqp: or amqps:) is mandatory; defaults for elided parts are as given in
    * 'amqp://guest:guest@localhost:5672'. If the URI is omitted entirely, it will default to 'amqp://localhost',
    * which given the defaults for missing parts, will connect to a RabbitMQ installation with factory settings, on localhost.
    * @param url           the AMQP url
    * @param socketOptions the optional socket options
    * @param callback      the connection result callback
    */
  def connect(url: String, socketOptions: js.Any, callback: js.Function): Unit = js.native

  /**
    * Connect to an AMQP 0-9-1 server, optionally given an AMQP URL (see AMQP URI syntax) and socket options.
    * The protocol part (amqp: or amqps:) is mandatory; defaults for elided parts are as given in
    * 'amqp://guest:guest@localhost:5672'. If the URI is omitted entirely, it will default to 'amqp://localhost',
    * which given the defaults for missing parts, will connect to a RabbitMQ installation with factory settings, on localhost.
    * @param url      the AMQP url
    * @param callback the connection result callback
    */
  def connect(url: String, callback: js.Function): Unit = js.native

}

/**
  * AmqpLib Companion
  * @author lawrence.daniels@gmail.com
  */
object AmqpLib {

  /**
    * Convenience method for retrieving the amqplib module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AmqpLib instance
    */
  def apply()(implicit require: NodeRequire) = require[AmqpLib]("amqplib")

}