package io.scalajs.npm.splitargs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Splits strings into tokens by given separator except treating quoted part as a single token.
  * @version 0.0.7
  * @see https://github.com/elgs/splitargs
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SplitArgs extends js.Object {

  def apply(string: String): js.Array[String] = js.native

}

/**
  * SplitArgs Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("splitargs", JSImport.Namespace)
object SplitArgs extends SplitArgs