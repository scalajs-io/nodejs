package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
  * nvd3 package object
  * @author lawrence.daniels@gmail.com
  */
package object nvd3 {

  type Legend = js.Any

  @inline
  def legend(margin: js.UndefOr[Margin] = js.undefined): Legend = js.Dictionary(
    "margin" -> margin
  )

}
