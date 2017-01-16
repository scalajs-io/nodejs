package io.scalajs.npm.angularjs.cookies

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
  def get[T](key: String): js.UndefOr[T] = js.native

  def getAll(): js.Any = js.native

  def getObject[T](key: String): js.UndefOr[T] = js.native

  def put[T](key: String, value: T): Unit = js.native

  def putObject[T](key: String, value: T, options: js.Any = js.native): Unit = js.native

  def remove(key: String, options: js.Any = js.native): js.Any = js.native

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

    @inline
    def getOrElse[T](key: String, defaultValue: T): T = cookies.get[T](key) getOrElse defaultValue

    @inline
    def getObjectOrElse[T](key: String, defaultValue: T): T = cookies.getObject[T](key) getOrElse defaultValue

  }

}
