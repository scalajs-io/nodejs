package org.scalajs.nodejs.social

import org.scalajs.nodejs.social.linkedin.LinkedIn

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * LinkedIn package object
  * @author lawrence.daniels@gmail.com
  */
package object linkedin {

  /**
    * LinkedIn service instance
    */
  @js.native
  @JSName("IN")
  object IN extends LinkedIn

}
