package io.scalajs.npm.express.multer

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * A multer file object is a JSON object with the following properties.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MulterFile extends js.Object {

  /**
    * Field name specified in the form
    */
  var fieldname: String = js.native

  /**
    * Name of the file on the user's computer
    */
  var originalname: String = js.native

  /**
    * Renamed file name
    */
  var name: String = js.native

  /**
    * Encoding type of the file
    */
  var encoding: String = js.native

  /**
    * Mime type of the file
    */
  var mimetype: String = js.native

  /**
    * Location of the uploaded file
    */
  var path: String = js.native

  /**
    * Extension of the file
    */
  var extension: String = js.native

  /**
    * Size of the file in bytes
    */
  var size: Int = js.native

  /**
    * If the file was truncated due to size limitation
    */
  var truncated: Boolean = js.native

  /**
    * Raw data (is null unless the inMemory option is true)
    */
  var buffer: Buffer = js.native

}
