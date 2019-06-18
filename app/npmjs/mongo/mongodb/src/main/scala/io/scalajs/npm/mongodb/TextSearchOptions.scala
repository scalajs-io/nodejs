package io.scalajs.npm.mongodb

import scala.scalajs.js


/**
  * Text Search Options
  * @author lawrence.daniels@gmail.com
  */

class TextSearchOptions(var $search: js.UndefOr[String] = js.undefined,
                        var $language: js.UndefOr[String] = js.undefined,
                        var $caseSensitive: js.UndefOr[Boolean] = js.undefined,
                        var $diacriticSensitive: js.UndefOr[Boolean] = js.undefined) extends js.Object
