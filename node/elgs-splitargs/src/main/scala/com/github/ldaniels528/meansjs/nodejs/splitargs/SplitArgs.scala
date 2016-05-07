package com.github.ldaniels528.meansjs.nodejs.splitargs

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Splits strings into tokens by given separator except treating quoted part as a single token.
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/elgs/splitargs]]
  */
@js.native
trait SplitArgs extends NodeModule {

  def apply(string: String): js.Array[String] = js.native

}
