package com.github.ldaniels528.meansjs.nodejs.datastax.datatypes

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cassandra Internet Address class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait InetAddressClass extends js.Object {

  override def toString(): String = js.native

}

/**
  * Internet Address Class Companion
  * @author lawrence.daniels@gmail.com
  */
object InetAddressClass {

  /**
    * Internet Address instance
    */
  @js.native
  trait InetAddress extends js.Any

  /**
    * Internet Address Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraInetAddressClassExtensions(val `class`: InetAddressClass) extends AnyVal {

    @inline
    def apply(buffer: Buffer) = `class`.New[InetAddress](buffer)

  }

}