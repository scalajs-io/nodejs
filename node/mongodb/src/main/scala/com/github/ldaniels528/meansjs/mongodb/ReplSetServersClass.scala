package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * MongoDB Replica Set Servers Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReplSetServersClass extends js.Object

/**
  * MongoDB Replica Set Servers Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ReplSetServersClass {

  /**
    * Replica Set Servers Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ReplSetServersClassExtensions(val `class`: ReplSetServersClass) extends AnyVal {

    /**
      * Constructor method
      */
    @inline
    def apply(replicas: js.Array[Server]) = `class`.New[ReplSetServers](replicas)

  }

}