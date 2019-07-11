package io.scalajs.npm.mysql

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * MySQL Stream Options
  * @param highWaterMark
  */
class MySQLStreamOptions(var highWaterMark: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * MySQL Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object MySQLStreamOptions extends FlexibleOptions[MySQLStreamOptions]