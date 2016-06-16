package org.scalajs.nodejs.zookeeper

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * ACL Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ACLClass extends js.Object {

  def toRecord: js.Any = js.native

}

/**
  * ACL Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ACLClass {

  /**
    * ACL Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ACLClassExtensions(val `class`: ACLClass) extends AnyVal {

    /**
      * @example ACL(permission, id)
      */
    @inline
    def apply(permission: js.Any, id: js.Any) = `class`.New[ACL](permission, id)

  }

}