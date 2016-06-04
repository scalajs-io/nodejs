package com.github.ldaniels528.meansjs.angularjs.anchorscroll

import com.github.ldaniels528.meansjs.angularjs.Provider

import scala.scalajs.js

/**
  * AnchorScroll Provider
  * @see [[https://docs.angularjs.org/api/ng/provider/\$anchorScrollProvider]]
  */
@js.native
trait AnchorScrollProvider extends Provider[AnchorScroll] {

  def disableAutoScrolling(): js.Any = js.native

}
