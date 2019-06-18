package io.scalajs.npm.mongoose

import scala.scalajs.js

/**
  * Mongoose exports
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Exports extends js.Object {

  /**
    * Pluralization rules.
    *
    * These rules are applied while processing the argument to toCollectionName.
    */
  var pluralization: js.UndefOr[js.Any] = js.native

  /**
    * Uncountable words.
    *
    * These words are applied while processing the argument to toCollectionName.
    */
  var uncountables: js.UndefOr[js.Any] = js.native

}
