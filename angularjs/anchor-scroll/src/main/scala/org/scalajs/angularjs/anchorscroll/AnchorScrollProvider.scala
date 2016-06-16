package org.scalajs.angularjs.anchorscroll

import org.scalajs.angularjs.Provider

import scala.scalajs.js

/**
  * AnchorScroll Provider
  * @see [[https://docs.angularjs.org/api/ng/provider/\$anchorScrollProvider]]
  */
@js.native
trait AnchorScrollProvider extends Provider[AnchorScroll] {

  def disableAutoScrolling(): js.Any = js.native

}
