package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Cursor Stream Options
  * @param transform A transformation method applied to each document emitted by the stream.
  * @author lawrence.daniels@gmail.com
  */
class CursorStreamOptions(var transform: js.UndefOr[js.Function] = js.undefined) extends js.Object

/**
  * Cursor Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorStreamOptions extends FlexibleOptions[CursorStreamOptions]