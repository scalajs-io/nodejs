package io.scalajs.npm.angularjs.cookies

import scala.scalajs.js

/**
  * CookieStore Service (requires: ngCookies) - Provides read/write access to browser's cookies.
  * @author lawrence.daniels@gmail.com
  * @see [[https://docs.angularjs.org/api/ngCookies/service/$cookies]]
  */
@js.native
trait CookieStore extends js.Object {

  /**
    * Returns the value of given cookie key
    * @param key the given cookie key
    * @tparam T the cookie value's type
    * @return the value of given cookie key
    */
  def get[T](key: String): js.UndefOr[T] = js.native

  /**
    * Sets a value for given cookie key
    * @param key the given cookie key
    * @param value the value of given cookie key
    * @tparam T the cookie value's type
    */
  def put[T](key: String, value: T): Unit = js.native

  /**
    * Removes given cookie
    * @param key the given cookie key
    * @return
    */
  def remove(key: String): js.Any = js.native

}

/**
  * CookieStore Service Singleton
  * @author lawrence.daniels@gmail.com
  */
object CookieStore {

  /**
    * CookieStore Extensions
    * @param cookieStore the given cookies instance
    */
  implicit class CookieStoreExtensions(val cookieStore: CookieStore) extends AnyVal {

    @inline
    def getOrElse[T](key: String, defaultValue: T): T = cookieStore.get[T](key) getOrElse defaultValue

  }

}
