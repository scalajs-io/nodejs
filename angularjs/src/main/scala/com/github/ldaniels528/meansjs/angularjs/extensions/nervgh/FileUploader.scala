package com.github.ldaniels528.meansjs.angularjs.extensions.nervgh

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.Element

import scala.scalajs.js

/**
  * Angular File Uploader (nervgh/angular-js-upload)
  * @see https://github.com/nervgh/angular-file-upload/wiki/Module-API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploader extends js.Object {

  ///////////////////////////////////////////////////////////////////////////
  //      Properties
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Name of the field which will contain the file, default is file
    */
  var alias: String = js.native

  /**
    * Automatically upload files after adding them to the queue
    */
  var autoUpload: Boolean = js.native

  /**
    * Filters to be applied to the files before adding them to the queue.
    * If the filter returns true the file will be added to the queue
    */
  var filters: js.Array[FileFilter] = js.native

  /**
    * Data to be sent along with the files
    */
  var formData: js.Array[js.Object] = js.native

  /**
    * Headers to be sent along with the files. HTML5 browsers only.
    */
  var headers: FileUploadHeaders = js.native

  /**
    * if uploader is html5-uploader. Read only.
    */
  def isHTML5: Boolean = js.native

  /**
    * if an upload is in progress. Read only.
    */
  def isUploading: Boolean = js.native

  /**
    * It's a request method. By default POST. HTML5 browsers only.
    */
  var method: String = js.native

  /**
    * Upload queue progress percentage. Read only.
    */
  def progress: Double = js.native

  /**
    * Items to be uploaded
    */
  var queue: js.Array[FileItem] = js.native

  /**
    * Maximum count of files
    */
  var queueLimit: Double = js.native

  /**
    * Remove files from the queue after uploading
    */
  var removeAfterUpload: Boolean = js.native

  /**
    * Path on the server to upload files
    */
  var url: String = js.native

  /**
    * Enable CORS. HTML5 browsers only.
    */
  var withCredentials: Boolean = js.native

  ///////////////////////////////////////////////////////////////////////////
  //      Queue Management Functions
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Add items to the queue, where: files is a {FileList|File|HTMLInputElement}, options is an {Object}
    * and filters is a {String}
    */
  def addToQueue(files: js.Array[FileItem]): Unit = js.native

  def addToQueue(files: js.Array[FileItem], options: FileItem): Unit = js.native

  def addToQueue(files: js.Array[FileItem], options: FileItem, filters: String): Unit = js.native

  def addToQueue(file: FileItem): Unit = js.native

  def addToQueue(file: FileItem, options: FileItem): Unit = js.native

  def addToQueue(file: FileItem, options: FileItem, filters: String): Unit = js.native

  def addToQueue(element: Element): Unit = js.native

  def addToQueue(element: Element, options: FileItem): Unit = js.native

  def addToQueue(element: Element, options: FileItem, filters: String): Unit = js.native

  /**
    * Cancels all current uploads.
    */
  def cancelAll(): Unit = js.native

  /**
    * Cancels uploading of item, where value is {FileItem} or index of item.
    */
  def cancelItem(file: FileItem): Unit = js.native

  /**
    * Cancels uploading of item, where value is {FileItem} or index of item.
    */
  def cancelItem(index: Int): Unit = js.native

  /**
    * Cancels uploading of item, where value is {FileItem} or index of item.
    */
  def cancelItem(): Unit = js.native

  /**
    * Removes all elements from the queue.
    */
  def clearQueue(): Unit = js.native

  /**
    * Destroys a uploader.
    */
  def destroy(): Unit = js.native

  /**
    * Returns the index of the {FileItem} queue element.
    * @param file the given of the {FileItem}
    * @return the index of the {FileItem} queue element.
    */
  def getIndexOfItem(file: FileItem): Int = js.native

  /**
    * Return an array of all pending items on the queue
    * @return an array of all pending items on the queue
    */
  def getNotUploadedItems(): js.Array[FileItem] = js.native

  /**
    * Return items are ready to upload.
    * @return items are ready to upload.
    */
  def getReadyItems(): js.Array[FileItem] = js.native

  /**
    * Returns true if value is {File}.
    * @param value the given value
    * @return true if value is {File}.
    */
  def isFile(value: js.Any): Boolean = js.native

  /**
    * Returns true if value is {FileLikeObject}.
    * @param value the given value
    * @return true if value is {FileLikeObject}.
    */
  def isFileLikeObject(value: js.Any): Boolean = js.native

  /**
    * Remove an item from the queue, where value is {FileItem} or index of item.
    */
  def removeFromQueue(file: FileItem): Unit = js.native

  /**
    * Upload all pending items on the queue.
    */
  def uploadAll(): Unit = js.native

  /**
    * Uploads an item, where value is {FileItem} or index of item.
    */
  def uploadItem(file: FileItem): Unit = js.native

  /**
    * Uploads an item, where value is {FileItem} or index of item.
    */
  def uploadItem(index: Int): Unit = js.native

  ///////////////////////////////////////////////////////////////////////////
  //      Event Functions
  ///////////////////////////////////////////////////////////////////////////

  var onWhenAddingFileFailed: js.Function3[FileItem, FileFilter, FileItem, Unit] = js.native //(item /*{File|FileLikeObject}*/, filter, options)

  var onAfterAddingFile: js.Function1[FileItem, Unit] = js.native //(fileItem)

  var onAfterAddingAll: js.Function1[js.Array[FileItem], Unit] = js.native //(addedFileItems)

  var onBeforeUploadItem: js.Function1[FileItem, Unit] = js.native //(item)

  var onProgressItem: js.Function2[FileItem, FileUploadProgress, Unit] = js.native //(fileItem, progress)

  var onProgressAll: js.Function1[FileUploadProgress, Unit] = js.native //(progress)

  var onSuccessItem: js.Function4[FileItem, FileUploadResponse, js.Any, FileUploadHeaders, Unit] = js.native //(fileItem, response, status, headers)

  var onErrorItem: js.Function4[FileItem, FileUploadResponse, js.Any, FileUploadHeaders, Unit] = js.native //(fileItem, response, status, headers)

  var onCancelItem: js.Function4[FileItem, FileUploadResponse, js.Any, FileUploadHeaders, Unit] = js.native //(fileItem, response, status, headers)

  var onCompleteItem: js.Function4[FileItem, FileUploadResponse, js.Any, FileUploadHeaders, Unit] = js.native //(fileItem, response, status, headers)

  var onCompleteAll: js.Function0[Unit] = js.native

}

/**
  * File Uploader Companion
  * @author lawrence.daniels@gmail.com
  */
object FileUploader {

  def apply(jsClass: js.Any, config: FileUploaderConfig) = {
    val inst = js.Dynamic.newInstance(jsClass.asInstanceOf[js.Dynamic])(config)
    inst.asInstanceOf[FileUploader]
  }
}

/**
  * File Upload Filter
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileFilter extends js.Object {
  var name: String = js.native
  var fn: js.Function = js.native
}

object FileFilter {

  def apply(name: String, fn: js.Function) = {
    val filter = makeNew[FileFilter]
    filter.name = name
    filter.fn = fn
    filter
  }
}

/**
  * File Upload Headers
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploadHeaders extends js.Object {

}

/**
  * File Upload Progress
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploadProgress extends js.Object {

}

/**
  * File Upload Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploadResponse extends js.Object {

}