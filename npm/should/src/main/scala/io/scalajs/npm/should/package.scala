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
  implicit class ShouldExtensionsA(val value: js.Any) extends AnyVal {

    @inline
    def should: Assertion = Should(value)

  }

  /**
    * Should Extensions
    * @param value the given value
    */
  implicit class ShouldExtensionsB(val value: Int) extends AnyVal {

    @inline
    def should: Assertion = Should(value)

  }

  /**
    * Should Extensions
    * @param value the given value
    */
  implicit class ShouldExtensionsC(val value: Double) extends AnyVal {

    @inline
    def should: Assertion = Should(value)

  }

  /**
    * Should Extensions
    * @param value the given value
    */
  implicit class ShouldExtensionsD(val value: String) extends AnyVal {

    @inline
    def should: Assertion = Should(value)

  }

}
