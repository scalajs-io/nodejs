package io.scalajs.dom

import scala.scalajs.js

/**
  * The Performance.now() method returns a DOMHighResTimeStamp, measured in milliseconds, accurate to
  * one thousandth of a millisecond.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Performance
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Performance extends js.Object {

  /**
    * The measure() method creates a named timestamp in the browser's performance entry buffer between two specified
    * marks (known as the start mark and end mark, respectively). The named timestamp is referred to as a measure.
    *
    * The measure can be retrieved by one of the Performance interface's getEntries*() methods (getEntries(),
    * getEntriesByName() or getEntriesByType()).
    * @param name      A DOMString representing the name of the measure.
    * @param startMark A DOMString representing the name of the measure's starting mark.
    *                  May also be the name of a PerformanceTiming property.
    * @param endMark   A DOMString representing the name of the measure's ending mark.
    *                  May also be the name of a PerformanceTiming property.
    */
  def measure(name: String, startMark: String = js.native, endMark: String = js.native): Unit = js.native

  /**
    * @return a DOMHighResTimeStamp, measured in milliseconds, accurate to one thousandth of a millisecond.
    */
  def now(): DOMHighResTimeStamp = js.native

}
