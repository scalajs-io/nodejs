package io.scalajs.dom.html

import io.scalajs.dom.DOMError

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The FileReader object lets web applications asynchronously read the contents of files (or raw data buffers) stored
  * on the user's computer, using [[File]] or [[Blob]] objects to specify the file or data to read.
  *
  * File objects may be obtained from a FileList object returned as a result of a user selecting files using the <input>
  * element, from a drag and drop operation's DataTransfer object, or from the mozGetAsFile() API on an HTMLCanvasElement.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/FileReader
  * @author lawrence.daniels@gmail.com
  */
@js.native
class FileReader extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A DOMError representing the error that occurred while reading the file.
    */
  def error: DOMError = js.native

  /**
    * A number indicating the state of the FileReader.
    * @see [[FileReader.EMPTY]]
    * @see [[FileReader.LOADING]]
    * @see [[FileReader.DONE]]
    */
  def readyState: Int = js.native

  /**
    * The file's contents. This property is only valid after the read operation is complete, and the format of the data
    * depends on which of the methods was used to initiate the read operation.
    */
  def result: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Event Handlers
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A handler for the abort event. This event is triggered each time the reading operation is aborted.
    */
  var onabort: js.Function = js.native

  /**
    * A handler for the error event. This event is triggered each time the reading operation encounter an error.
    */
  var onerror: js.Function = js.native

  /**
    * A handler for the load event. This event is triggered each time the reading operation is successfully completed.
    */
  var onload: js.Function = js.native

  /**
    * A handler for the loadstart event. This event is triggered each time the reading is starting.
    */
  var onloadstart: js.Function = js.native

  /**
    * A handler for the loadend event. This event is triggered each time the reading operation is completed
    * (either in success or failure).
    */
  var onloadend: js.Function = js.native

  /**
    * A handler for the progress event. This event is triggered while reading a Blob content.
    */
  var onprogress: js.Function = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Aborts the read operation. Upon return, the readyState will be DONE.
    */
  def abort(): Unit = js.native

  /**
    * The FileReader interface's readAsArrayBuffer() method is used to start reading the contents of a specified
    * [[Blob]] or [[File]]. When the read operation is finished, the readyState becomes DONE, and the loadend is triggered.
    * At that time, the result attribute contains an ArrayBuffer representing the file's data.
    * @param blob the [[Blob]] or [[File]] from which to read.
    */
  def readAsArrayBuffer(blob: Blob | File): Unit = js.native

  /**
    * The readAsBinaryString method is used to start reading the contents of the specified Blob or File. When the read
    * operation is finished, the readyState becomes DONE, and the loadend is triggered. At that time, the result
    * attribute contains the raw binary data from the file.
    * @param blob the [[Blob]] or [[File]] from which to read.
    */
  def readAsBinaryString(blob: Blob | File): Unit = js.native

  /**
    * The readAsDataURL method is used to read the contents of the specified Blob or File. When the read operation is
    * finished, the readyState becomes DONE, and the loadend is triggered. At that time, the result attribute contains
    * the data as a URL representing the file's data as a base64 encoded string.
    * @param blob the [[Blob]] or [[File]] from which to read.
    */
  def readAsDataURL(blob: Blob | File): Unit = js.native

  /**
    * The readAsText method is used to read the contents of the specified Blob or File. When the read operation is
    * complete, the readyState is changed to DONE, the loadend is triggered, and the result attribute contains the
    * contents of the file as a text string.
    * @param blob     the [[Blob]] or [[File]] from which to read.
    * @param encoding A string specifying the encoding to use for the returned data. By default, UTF-8 is assumed if
    *                 this parameter is not specified.
    */
  def readAsText(blob: Blob | File, encoding: String = js.native): Unit = js.native

}

/**
  * FileReader Companion
  * @author lawrence.daniels@gmail.com
  */
object FileReader {

  /**
    * No data has been loaded yet.
    */
  val EMPTY: Int = 0

  /**
    * Data is currently being loaded.
    */
  val LOADING: Int = 1

  /**
    * The entire read request has been completed.
    */
  val DONE: Int = 2

  /**
    * File Reader Extensions
    * @param reader the given [[FileReader file reader]]
    */
  final implicit class FileReaderExtensions(val reader: FileReader) extends AnyVal {

    def resultAs[T]: T = reader.result.asInstanceOf[T]

  }

}
