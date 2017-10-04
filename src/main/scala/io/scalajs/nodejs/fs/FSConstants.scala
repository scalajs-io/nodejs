package io.scalajs.nodejs.fs

import scala.scalajs.js

/**
  * An object containing commonly used constants for file system operations
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FSConstants extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      File Access Constants
  //
  //      The following constants are meant for use with fs.access().
  /////////////////////////////////////////////////////////////////////////////////                         `

  /**
    * File is visible to the calling process. This is useful for determining if a file exists, but says
    * nothing about rwx permissions. Default if no mode is specified.
    */
  val F_OK: FileMode = js.native

  /**
    * File can be read by the calling process.
    */
  val R_OK: FileMode = js.native

  /**
    * File can be written by the calling process.
    */
  val W_OK: FileMode = js.native

  /**
    * File can be executed by the calling process. This has no effect on Windows (will behave like [[F_OK]]).
    */
  val X_OK: FileMode = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      File Open Constants
  //
  //      The following constants are meant for use with fs.open().
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Flag indicating to open a file for read-only access.
    */
  val O_RDONLY: Int = js.native

  /**
    * Flag indicating to open a file for write-only access.
    */
  val O_WRONLY: Int = js.native

  /**
    * Flag indicating to open a file for read-write access.
    */
  val O_RDWR: Int = js.native

  /**
    * Flag indicating to create the file if it does not already exist.
    */
  val O_CREAT: Int = js.native

  /**
    * Flag indicating that opening a file should fail if the O_CREAT flag is set and the file already exists.
    */
  val O_EXCL: Int = js.native

  /**
    * Flag indicating that if path identifies a terminal device, opening the path shall not cause that terminal to
    * become the controlling terminal for the process (if the process does not already have one).
    */
  val O_NOCTTY: Int = js.native

  /**
    * Flag indicating that if the file exists and is a regular file, and the file is opened successfully for write
    * access, its length shall be truncated to zero.
    */
  val O_TRUNC: Int = js.native

  /**
    * Flag indicating that data will be appended to the end of the file.
    */
  val O_APPEND: Int = js.native

  /**
    * Flag indicating that the open should fail if the path is not a directory.
    */
  val O_DIRECTORY: Int = js.native

  /**
    * Flag indicating reading accesses to the file system will no longer result in an update to the atime information
    * associated with the file. This flag is available on Linux operating systems only.
    */
  val O_NOATIME: Int = js.native

  /**
    * Flag indicating that the open should fail if the path is a symbolic link.
    */
  val O_NOFOLLOW: Int = js.native

  /**
    * Flag indicating that the file is opened for synchronous I/O.
    */
  val O_SYNC: Int = js.native

  /**
    * Flag indicating to open the symbolic link itself rather than the resource it is pointing to.
    */
  val O_SYMLINK: Int = js.native

  /**
    * When set, an attempt will be made to minimize caching effects of file I/O.
    */
  val O_DIRECT: Int = js.native

  /**
    * Flag indicating to open the file in nonblocking mode when possible.
    */
  val O_NONBLOCK: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      File Type Constants
  //
  //      The following constants are meant for use with the fs.Stats object's mode
  //      property for determining a file's type.
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Bit mask used to extract the file type code.
    */
  val S_IFMT: FileType = js.native

  /**
    * File type constant for a regular file.
    */
  val S_IFREG: FileType = js.native

  /**
    * File type constant for a directory.
    */
  val S_IFDIR: FileType = js.native

  /**
    * File type constant for a character-oriented device file.
    */
  val S_IFCHR: FileType = js.native

  /**
    * File type constant for a block-oriented device file.
    */
  val S_IFBLK: FileType = js.native

  /**
    * File type constant for a FIFO/pipe.
    */
  val S_IFIFO: FileType = js.native

  /**
    * File type constant for a symbolic link.
    */
  val S_IFLNK: FileType = js.native

  /**
    * File type constant for a socket.
    */
  val S_IFSOCK: FileType = js.native

}
