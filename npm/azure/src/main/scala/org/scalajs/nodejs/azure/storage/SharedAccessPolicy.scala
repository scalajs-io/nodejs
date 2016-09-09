package org.scalajs.nodejs.azure.storage

import org.scalajs.nodejs.azure.storage.SharedAccessPolicy.AccessPolicy

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Shared Access Policy
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SharedAccessPolicy(var publicAccessLevel: js.UndefOr[String],
                         var AccessPolicy: js.UndefOr[AccessPolicy]) extends js.Object

/**
  * Shared Access Policy Companion
  * @author lawrence.daniels@gmail.com
  */
object SharedAccessPolicy {

  def apply(publicAccessLevel: js.UndefOr[String] = js.undefined,
            AccessPolicy: js.UndefOr[AccessPolicy] = js.undefined) = {
    new SharedAccessPolicy(publicAccessLevel, AccessPolicy)
  }

  /**
    * Access Policy
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class AccessPolicy(var Expiry: js.Date) extends js.Object

}