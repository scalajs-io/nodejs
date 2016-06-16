package org.scalajs.angularjs

import scala.scalajs.js.JSON

/**
  * AngularJS Convenience Helper Functions
  * @author lawrence.daniels@gmail.com
  */
object AngularJsHelper {
  private val HttpError = "Failed to process HTTP request:"

  /**
    * Exception Extensions
    * @param cause the given [[Throwable exception]]
    * @author lawrence.daniels@gmail.com
    */
  implicit class ExceptionExtensions(val cause: Throwable) extends AnyVal {

    @inline
    def displayMessage = Option(cause.getMessage) match {
      case Some(s) if s.startsWith(HttpError) => cleanUp(s.drop(HttpError.length))
      case Some(s) => s
      case None => "Cause unknown"
    }

    private def cleanUp(s: String) = s.replaceAllLiterally("\"", "").replaceAllLiterally("'", "")

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

    @inline def isValidEmail: Boolean = {
      string.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    }

    @inline def parseAs[T] = JSON.parse(string).asInstanceOf[T]

  }

}
