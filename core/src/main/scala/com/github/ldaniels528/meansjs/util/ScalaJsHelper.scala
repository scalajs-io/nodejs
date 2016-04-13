package com.github.ldaniels528.meansjs.util

import org.scalajs.dom.console

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSON
import scala.util.{Failure, Success, Try}

/**
  * Scala.js Convenience Helper Functions
  * @author lawrence.daniels@gmail.com
  */
object ScalaJsHelper {
  private val HttpError = "Failed to process HTTP request:"

  ////////////////////////////////////////////////////////////////////////
  //    Convenience Functions
  ////////////////////////////////////////////////////////////////////////

  @inline
  def emptyArray[T] = js.Array[T]()

  @inline
  def makeNew[T] = new js.Object().asInstanceOf[T]

  def params(values: (String, Any)*): String = {
    val queryString = values map { case (k, v) => s"$k=${g.encodeURI(String.valueOf(v))}" } map (_.replaceAllLiterally("&", "%26")) mkString "&"
    if (queryString.nonEmpty) "?" + queryString else queryString
  }

  ////////////////////////////////////////////////////////////////////////
  //    Error-Handling Functions
  ////////////////////////////////////////////////////////////////////////

  /**
    * Exception Enrichment
    * @param cause the given [[Throwable exception]]
    * @author lawrence.daniels@gmail.com
    */
  implicit class ExceptionEnrichment(val cause: Throwable) extends AnyVal {

    def displayMessage = Option(cause.getMessage) match {
      case Some(s) if s.startsWith(HttpError) => cleanUp(s.drop(HttpError.length))
      case Some(s) => s
      case None => "Cause unknown"
    }

    private def cleanUp(s: String) = s.replaceAllLiterally("\"", "").replaceAllLiterally("'", "")

  }

  ////////////////////////////////////////////////////////////////////////
  //    Monitoring Functions
  ////////////////////////////////////////////////////////////////////////

  def time[T](action: String, task: => Future[T], showHeader: Boolean = true)(implicit ec: ExecutionContext): Future[T] = {
    if (showHeader) console.info(s"$action...")
    val startTime = System.currentTimeMillis()
    task onComplete {
      case Success(_) =>
        console.info(s"$action took ${System.currentTimeMillis() - startTime} msecs")
      case Failure(e) =>
        console.warn(s"$action failed after ${System.currentTimeMillis() - startTime} msecs")
    }
    task
  }

  /**
    * Time Measurement Enrichment
    * @param task the given [[Future task]]
    * @tparam T the return type of the task
    */
  implicit class TimeEnrichment[T](val task: Future[T]) extends AnyVal {

    def withTimer(action: String, showHeader: Boolean = true)(implicit ec: ExecutionContext) = time(action, task, showHeader)

  }

  ////////////////////////////////////////////////////////////////////////
  //    Validation Functions
  ////////////////////////////////////////////////////////////////////////

  @inline
  def die[T](message: String): T = throw new IllegalStateException(message)

  @inline
  def isDefined(obj: js.Any) = obj != null && !js.isUndefined(obj)

  @inline
  def isDefined(fx: js.Function) = fx != null && !js.isUndefined(fx)

  @inline
  def isFalse(obj: js.Dynamic) = !isTrue(obj)

  @inline
  def isTrue(obj: js.Dynamic) = isDefined(obj) && obj.as[Boolean]

  @inline
  def required(name: String, value: String) = if (value == null || value.trim.isEmpty) die(s"Required property '$name' is missing")

  @inline
  def required(name: String, value: js.Any) = if (!isDefined(value)) die(s"Required property '$name' is missing")

  @inline
  def required[T](name: String, value: js.Array[T], allowEmpty: Boolean = false) = {
    if (value == null || (allowEmpty && value.isEmpty)) die(s"Required property '$name' is missing")
  }

  ////////////////////////////////////////////////////////////////////////
  //    Implicit Definitions and Classes
  ////////////////////////////////////////////////////////////////////////

  /**
    * js.Dynamic to Value Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit class JsAnyExtensions(val obj: js.Any) extends AnyVal {

    def New[T <: js.Any](args: js.Any*): T = {
      js.Dynamic.newInstance(obj.asInstanceOf[js.Dynamic])(args).asInstanceOf[T]
    }

    def ===[T](value: T): Boolean = {
      if (value == null) !isDefined(obj)
      else {
        Try(obj.asInstanceOf[T]) match {
          case Success(converted) => converted == value
          case Failure(e) =>
            console.log(s"JsDynamicExtensionsA: value '$value': ${e.getMessage}")
            false
        }
      }
    }

    @inline def as[T] = if (isDefined(obj)) obj.asInstanceOf[T] else null.asInstanceOf[T]

    @inline def asOpt[T] = obj.asInstanceOf[js.UndefOr[T]].toOption

    @inline def asArray[T] = obj.asInstanceOf[js.Array[T]]

    @inline def isTrue = isDefined(obj) && Try(obj.asInstanceOf[Boolean]).toOption.contains(true)

    @inline def toUndefOr[T]: js.UndefOr[T] = obj.asInstanceOf[js.UndefOr[T]]

  }

  /**
    * js.Array Extensions
    * @param array the given [[js.Array array]]
    */
  implicit class JsArrayExtensions[A](val array: js.Array[A]) extends AnyVal {

    @inline def removeAll(): Unit = array.remove(0, array.length)

    @inline def replaceWith(items: A*) = {
      array.remove(0, array.length)
      array.push(items: _*)
    }
  }

  /**
    * js.Dictionary Extensions
    * @param dict the given [[js.Dictionary dictionary]]
    */
  implicit class JsDictionaryExtensions[A](val dict: js.Dictionary[A]) extends AnyVal {

    @inline def replaceWith(items: (String, A)*) = {
      dict.clear()
      items foreach { case (key, value) => dict(key) = value }
    }
  }

  /**
    * Value to js.Dynamic Extensions
    * @param value the given [[String value]]
    */
  implicit class JsDynamicExtensions(val value: String) extends AnyVal {

    @inline
    def ===(obj: js.Dynamic): Boolean = {
      if (!isDefined(obj)) value == null
      else {
        Try(obj.asInstanceOf[String]) match {
          case Success(converted) => converted == value
          case Failure(e) =>
            console.log(s"JsDynamicExtensionsB: value '$value': ${e.getMessage}")
            false
        }
      }
    }
  }

  /**
    * js.Object Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit class JsObjectExtensions(val obj: js.Object) extends AnyVal {

    @inline def dynamic = obj.asInstanceOf[js.Dynamic]

  }

  /**
    * Option Extensions
    * @param valueA the given [[Option option]]
    */
  implicit class OptionExtensions[T](val valueA: Option[T]) extends AnyVal {

    @inline def ?==(valueB: T): Boolean = valueA.contains(valueB)

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(v => valueB.exists(_ == v))

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ??(optB: => Option[T]): Option[T] = if (valueA.isDefined) valueA else optB

    @inline def orDie(message: String): Option[T] = if (valueA.isDefined) valueA else throw new IllegalArgumentException(message)

  }

  /**
    * Convenience methods for strings
    * @param string the given host string
    */
  implicit class StringExtensions(val string: String) extends AnyVal {

    @inline
    def indexOfOpt(substring: String): Option[Int] = Option(string).map(_.indexOf(substring)) flatMap {
      case -1 => None
      case index => Some(index)
    }

    @inline def isBlank: Boolean = string == null || string.trim.isEmpty

    @inline def nonBlank: Boolean = string != null && string.trim.nonEmpty

    @inline def isValidEmail: Boolean = string.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

    @inline def parseAs[T] = JSON.parse(string).asInstanceOf[T]

  }

  /**
    * UndefOr Extensions
    * @param valueA the given [[js.UndefOr undefined or otherwise value]]
    */
  implicit class UndefOrExtensions[T](val valueA: js.UndefOr[T]) extends AnyVal {

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ??(optB: => js.UndefOr[T]): js.UndefOr[T] = if (valueA.isDefined) valueA else optB

    @inline def contains(value: T): Boolean = valueA.exists(_ == value)

    @inline def orDie(message: String): js.UndefOr[T] = if (valueA.isDefined) valueA else throw new IllegalArgumentException(message)

  }

}

