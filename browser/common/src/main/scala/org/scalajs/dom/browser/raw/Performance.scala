package org.scalajs.dom.browser.raw

import org.scalajs.dom.browser.DOMHighResTimeStamp
import scala.scalajs.js

/**
  * The Performance.now() method returns a DOMHighResTimeStamp, measured in milliseconds, accurate to one thousandth of a millisecond.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Performance extends js.Object {

  /**
    * @return a DOMHighResTimeStamp, measured in milliseconds, accurate to one thousandth of a millisecond.
    */
  def now(): DOMHighResTimeStamp = js.native

}
