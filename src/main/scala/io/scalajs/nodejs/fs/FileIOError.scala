package io.scalajs.nodejs.fs

import io.scalajs.nodejs.Error

import scala.scalajs.js

/**
  * File I/O Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
class FileIOError(message: String = "") extends Error(message)