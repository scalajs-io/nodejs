package com.github.ldaniels528.nodesjs.angularjs.extensions

import scala.scalajs.js

/**
  * Cookies Service (requires: ngCookies) - Provides read/write access to browser's cookies.
  * @author lawrence.daniels@gmail.com
  * @see [[https://docs.angularjs.org/api/ngCookies/service/$cookies]]
  */
@js.native
trait Cookies extends js.Object {

  /**
    * Returns the value of given cookie key
    * @param key the given cookie key
    * @return the value of given cookie key
    */
  def get(key: String): js.Any

  def getAll(): js.Any

  def getObject[T](key: String): js.UndefOr[T]

  def put[T](key: String, value: T): Unit

  def putObject[T](key: String, value: T, options: js.Any = null): Unit

  def remove(key: String, options: js.Any = null): js.Any

}

/**
  * Cookies Service Singleton
  * @author lawrence.daniels@gmail.com
  */
object Cookies {

  /**
    * Cookie Extensions
    * @param cookies the given cookies instance
    */
  implicit class CookieExtensions(val cookies: Cookies) extends AnyVal {

    def getAsOpt[T](key: String) = {
      val value = cookies.get(key)
      value.asInstanceOf[js.UndefOr[T]]
    }

    @inline
    def getOrElse[T](key: String, defaultValue: T): T = cookies.get(key).asInstanceOf[js.UndefOr[T]].getOrElse(defaultValue)

    @inline
    def getObjectOrElse[T](key: String, defaultValue: T): T = (cookies.getObject(key) getOrElse defaultValue).asInstanceOf[T]

  }

}
