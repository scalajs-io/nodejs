package org.scalajs.dom.browser

import scala.scalajs.js

/**
  * The File interface provides information about files and allows JavaScript in a web page to access their content.
  *
  * File objects are generally retrieved from a FileList object returned as a result of a user selecting files using
  * the <input> element, from a drag and drop operation's DataTransfer object, or from the mozGetAsFile() API on an
  * HTMLCanvasElement. In Gecko, privileged code can create File objects representing any local file without user
  * interaction (see Gecko notes for more information.)
  *
  * A File object is a specific kind of a Blob, and can be used in any context that a Blob can. In particular,
  * FileReader, URL.createObjectURL(), createImageBitmap(), and XMLHttpRequest.send() accept both Blobs and Files.
  * @see [[https://developer.mozilla.org/en-US/docs/Web/API/File]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
class File(path: String) extends BlobLike {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the name of the file referenced by the File object.
    */
  def name: String = js.native

  /**
    * Returns the last modified time of the file, in millisecond since the UNIX epoch (January 1st, 1970 at Midnight).
    */
  def lastModified: Double = js.native

  /**
    * Returns the last modified date of the file. Files without a known last modified date returns the current date.
    */
  def lastModifiedDate: js.Date = js.native

  /**
    * The File.webkitRelativePath is a read-only property that contains a DOMString with the path relative to the
    * directory selected when the webkitdirectory has been set on the <input> element.
    */
  def webkitRelativePath: File = js.native

}
