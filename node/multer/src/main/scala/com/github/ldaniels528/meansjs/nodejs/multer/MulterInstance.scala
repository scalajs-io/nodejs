package com.github.ldaniels528.meansjs.nodejs.multer

import scala.scalajs.js

/**
  * Multer Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MulterInstance extends js.Object {

  /**
    * Accepts all files that comes over the wire. An array of files will be stored in req.files.
    */
  def any(): Unit = js.native

  /**
    * Accept an array of files, all with the name fieldname. The array of files will be stored in req.files.
    * @param fieldname the name field name
    * @param maxCount  Optionally error out if more than maxCount files are uploaded.
    * @example array(fieldname[, maxCount])
    */
  def array(fieldname: String, maxCount: Int): Unit = js.native

  /**
    * Accept an array of files, all with the name fieldname. The array of files will be stored in req.files.
    * @param fieldname the name field name
    * @example array(fieldname[, maxCount])
    */
  def array(fieldname: String): Unit = js.native

  /**
    * Accept a mix of files, specified by fields. An object with arrays of files will be stored in req.files.
    * @param fields should be an array of objects with name and optionally a maxCount.
    * @example fields(fields)
    */
  def fields(fields: js.Array[MulterField]): Unit = js.native

  /**
    * Accept a single file with the name fieldname. The single file will be stored in req.file.
    * @param fieldname the name field name
    */
  def single(fieldname: String): Unit = js.native

}
