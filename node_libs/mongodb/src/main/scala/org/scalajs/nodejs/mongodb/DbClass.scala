package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Db Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DbClass extends js.Object

/**
  * Db Class Companion
  * @author lawrence.daniels@gmail.com
  */
object DbClass {

  /**
    * Db Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class DbClassExtensions(val `class`: DbClass) extends AnyVal {

    @inline
    def apply(name: String, server: Server) = `class`.New[Db](name, server)

    @inline
    def apply(name: String, replicaSet: ReplSetServers, options: DbOptions) = {
      `class`.New[Db](name, replicaSet, options)
    }

  }

}