package io.scalajs.npm.gzipuncompressedsize

import io.scalajs.nodejs.Error

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Gzip Uncompressed Size
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GzipUncompressedSize extends js.Object {

  /**
    * Determines the uncompressed size of the given file
    * @param path     the path to the compressed (.gz) file
    * @param callback the callback
    */
  def fromFile(path: String, callback: js.Function2[Error, Double, Any]): Unit = js.native

}

/**
  * Gzip Uncompressed Size Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport(module = "gzip-uncompressed-size", name = JSImport.Default)
object GzipUncompressedSize extends GzipUncompressedSize
