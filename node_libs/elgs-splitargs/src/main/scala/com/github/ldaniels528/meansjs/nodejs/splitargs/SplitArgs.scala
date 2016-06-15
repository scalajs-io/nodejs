package com.github.ldaniels528.meansjs.nodejs.splitargs

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * Splits strings into tokens by given separator except treating quoted part as a single token.
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/elgs/splitargs]]
  * @version 0.0.7
  */
@js.native
trait SplitArgs extends NodeModule {

  def apply(string: String): js.Array[String] = js.native

}

/**
  * SplitArgs Companion
  * @author lawrence.daniels@gmail.com
  */
object SplitArgs {

  /**
    * Convenience method for retrieving the 'splitargs' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the SplitArgs instance
    */
  def apply()(implicit require: NodeRequire) = require[SplitArgs]("splitargs")

}