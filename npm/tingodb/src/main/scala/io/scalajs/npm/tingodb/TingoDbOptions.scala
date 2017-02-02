package io.scalajs.npm.tingodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * TingoDB Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class TingoDbOptions(var memStore: js.UndefOr[Boolean] = js.undefined,
                     var nativeObjectID: js.UndefOr[Boolean] = js.undefined,
                     var cacheSize: js.UndefOr[Int] = js.undefined,
                     var cacheMaxObjSize: js.UndefOr[Int] = js.undefined,
                     var searchInArray: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
