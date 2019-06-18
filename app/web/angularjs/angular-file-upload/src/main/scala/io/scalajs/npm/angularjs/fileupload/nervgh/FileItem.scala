package io.scalajs.npm.angularjs.fileupload.nervgh

import scala.scalajs.js

/**
  * File Item
  * @see https://github.com/nervgh/angular-file-upload/wiki/Module-API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileItem extends js.Object {

  ///////////////////////////////////////////////////////////////////////////
  //      Properties
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Name of the field which will contain the file, default is file
    */
  var alias: String = js.native

  /**
    * The underlying file
    */
  var file: FileItemDetails = js.native

  /**
    * Data to be sent along with this file
    */
  var formData: js.Array[js.Object] = js.native

  /**
    * Headers to be sent along with this file. HTML5 browsers only.
    */
  var headers: FileUploadHeaders = js.native

  /**
    * true if uploading was canceled. Read only.
    */
  def isCancel: Boolean = js.native

  /**
    * true if occurred error while file uploading. Read only.
    */
  def isError: Boolean = js.native

  /**
    * File is ready to upload. Read only.
    */
  def isReady: Boolean = js.native

  /**
    * true if the file was uploaded successfully. Read only.
    */
  def isSuccess: Boolean = js.native

  /**
    * true if the file was uploaded. Read only.
    */
  def isUploaded: Boolean = js.native

  /**
    * true if the file is being uploaded. Read only.
    */
  def isUploading: Boolean = js.native

  /**
    * A sequence number upload. Read only.
    */
  def index: Int = js.native

  /**
    *  It's a request method. By default POST. HTML5 browsers only.
    */
  var method: String = js.native

  /**
    * File upload progress percentage. Read only.
    */
  def progress: Double = js.native

  /**
    * Remove this file from the queue after uploading
    */
  var removeAfterUpload: Boolean = js.native

  /**
    * Reference to the parent Uploader object for this file. Read only.
    */
  def uploader: FileUploader = js.native

  /**
    * Path on the server in which this file will be uploaded
    */
  var url: String = js.native

  /**
    * Enable CORS. HTML5 browsers only.
    */
  var withCredentials: Boolean = js.native

  ///////////////////////////////////////////////////////////////////////////
  //      Methods
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Cancels uploading of this file
    */
  def cancel(): Unit = js.native

  /**
    * Remove this file from the queue
    */
  def remove(): Unit = js.native

  /**
    * Upload this file
    */
  def upload(): Unit = js.native

  ///////////////////////////////////////////////////////////////////////////
  //      Callbacks
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Fires before uploading an item.
    */
  var onBeforeUpload: js.Function0[Unit] = js.native

  /**
    * On file upload progress.
    */
  var onProgress: js.Function1[Double, Unit] = js.native

  /**
    * On file successfully uploaded
    */
  var onSuccess: js.Function3[FileUploadResponse, js.Object, FileUploadHeaders, Unit] = js.native

  /**
    * On upload error
    */
  var onError: js.Function3[FileUploadResponse, js.Object, FileUploadHeaders, Unit] = js.native

  /**
    * On cancel uploading
    */
  var onCancel: js.Function3[FileUploadResponse, js.Object, FileUploadHeaders, Unit] = js.native

  /**
    * On file upload complete (independently of the sucess of the operation)
    */
  var onComplete: js.Function3[FileUploadResponse, js.Object, FileUploadHeaders, Unit] = js.native

}
