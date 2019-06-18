package io.scalajs.npm.express.multer

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Multer is a node.js middleware for handling multipart/form-data.
  * @version 1.1.0
  * @see https://github.com/expressjs/multer
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Multer extends js.Object {

  def apply(options: MulterOptions | RawOptions): MulterInstance = js.native

  def diskStorage(option: DiskStorageOptions | RawOptions): DiskStorage = js.native

  def memoryStorage(option: MemoryStorageOptions | RawOptions): MemoryStorage = js.native

}

/**
  * Multer Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("multer", JSImport.Namespace)
object Multer extends Multer
