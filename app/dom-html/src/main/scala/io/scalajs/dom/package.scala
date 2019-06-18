package io.scalajs

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * dom package object
  * @author lawrence.daniels@gmail.com
  */
package object dom {

  type DOMString = String

  type RangeType = js.Any

  type UnsignedLong = Long

  type USVString = String

  /**
    * DOMHighResTimeStamp Enrichment
    * @param ts the given [[DOMHighResTimeStamp]]
    */
  implicit class DOMHighResTimeStampEnrichment(val ts: DOMHighResTimeStamp) extends AnyVal {

    @inline
    def +(ts0: DOMHighResTimeStamp): DOMHighResTimeStamp = (ts.dynamic + ts0.dynamic).asInstanceOf[DOMHighResTimeStamp]

    @inline
    def -(ts0: DOMHighResTimeStamp): DOMHighResTimeStamp = (ts.dynamic - ts0.dynamic).asInstanceOf[DOMHighResTimeStamp]

    @inline
    def *(ts0: DOMHighResTimeStamp): DOMHighResTimeStamp = (ts.dynamic * ts0.dynamic).asInstanceOf[DOMHighResTimeStamp]

    @inline
    def /(ts0: DOMHighResTimeStamp): DOMHighResTimeStamp = (ts.dynamic / ts0.dynamic).asInstanceOf[DOMHighResTimeStamp]

  }

}
