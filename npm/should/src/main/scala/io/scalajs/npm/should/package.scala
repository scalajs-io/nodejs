package io.scalajs.npm

import scala.scalajs.js

/**
  * should package object
  * @author lawrence.daniels@gmail.com
  */
package object should {

  /**
    * Should Extensions
    * @param value the given value
    */
  implicit class ShouldExtensions(val value: js.Any) extends AnyVal {

    @inline
    def should(implicit _should: Should): Assertion = _should(value)

  }

}
