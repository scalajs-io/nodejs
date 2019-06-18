package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Okay Verification
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Okayable extends js.Object {

  def ok: Int = js.native

}

/**
  * Okayable Companion
  * @author lawrence.daniels@gmail.com
  */
object Okayable {

  /**
    * Okay Enrichment
    * @param okayable the given[[Okayable]]
    */
  implicit class OkayEnrichment(val okayable: Okayable) extends AnyVal {

    @inline
    def isOk: Boolean = okayable.ok == 1

  }

}