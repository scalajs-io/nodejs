package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Database Statistics Options
  * @param scale Divide the returned sizes by scale value.
  */
class DbStatsOptions(var scale: js.UndefOr[Double] = js.undefined) extends js.Object

/**
  * Database Statistics Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DbStatsOptions extends FlexibleOptions[DbStatsOptions]