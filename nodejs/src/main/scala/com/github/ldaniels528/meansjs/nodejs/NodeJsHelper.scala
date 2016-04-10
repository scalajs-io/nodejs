package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * Node.js Helper
  * @author lawrence.daniels@gmail.com
  */
object NodeJsHelper {

  def require[T <: js.Object](moduleName: String): js.UndefOr[T] = {
    val module = js.Dynamic.global.require(moduleName)
    module.asInstanceOf[js.UndefOr[T]]
  }

}
