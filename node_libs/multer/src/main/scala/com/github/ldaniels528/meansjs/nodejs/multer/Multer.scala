package com.github.ldaniels528.meansjs.nodejs.multer

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Multer is a node.js middleware for handling multipart/form-data.
  * @author lawrence.daniels@gmail.com
  * @see https://github.com/expressjs/multer
  * @version 1.1.0
  */
@js.native
trait Multer extends NodeModule {

  def apply(options: MulterOptions): MulterInstance = js.native

  def diskStorage(option: DiskStorageOptions): DiskStorage = js.native

  def memoryStorage(option: MemoryStorageOptions): MemoryStorage = js.native

}

/**
  * Multer Companion
  * @author lawrence.daniels@gmail.com
  */
object Multer {

  /**
    * Multer Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MulterExtensions(val multer: Multer) extends AnyVal {

    /**
      * @example multer.withOptions(dest = "/tmp")
      */
    def withOptions(dest: js.UndefOr[String] = js.undefined,
                    limits: js.UndefOr[MulterLimits] = js.undefined,
                    includeEmptyFields: js.UndefOr[Boolean] = js.undefined,
                    inMemory: js.UndefOr[Boolean] = js.undefined,
                    rename: js.UndefOr[js.Function] = js.undefined,
                    onFileUploadStart: js.UndefOr[js.Function] = js.undefined,
                    onFileUploadData: js.UndefOr[js.Function] = js.undefined,
                    onFileUploadComplete: js.UndefOr[js.Function] = js.undefined,
                    onParseStart: js.UndefOr[js.Function] = js.undefined,
                    onParseEnd: js.UndefOr[js.Function] = js.undefined,
                    onError: js.UndefOr[js.Function] = js.undefined,
                    onFileSizeLimit: js.UndefOr[js.Function] = js.undefined,
                    onFilesLimit: js.UndefOr[js.Function] = js.undefined,
                    onFieldsLimit: js.UndefOr[js.Function] = js.undefined,
                    onPartsLimit: js.UndefOr[js.Function] = js.undefined) = {
      multer.apply(new MulterOptions(
        dest, limits, includeEmptyFields, inMemory, rename,
        onFileUploadStart, onFileUploadData, onFileUploadComplete, onParseStart, onParseEnd, onError,
        onFileSizeLimit, onFilesLimit, onFieldsLimit, onPartsLimit
      ))
    }

  }

}