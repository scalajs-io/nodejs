package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js

/**
  * File Statistics
  * <pre>
  * {
  * "dev": 16777220,
  * "mode": 33188,
  * "nlink": 1,
  * "uid": 501,
  * "gid": 0,
  * "rdev": 0,
  * "blksize": 4096,
  * "ino": 203412817,
  * "size": 0,
  * "blocks": 0,
  * "atime": "2016-04-12T15:49:34.000Z",
  * "mtime": "2016-04-12T15:49:34.000Z",
  * "ctime": "2016-04-12T15:49:34.000Z",
  * "birthtime": "2016-04-12T15:49:34.000Z"
  * }
  * </pre>
  * @since v0.1.21
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stats extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  var dev: Int = js.native
  var mode: Int = js.native
  var nlink: Int = js.native
  var uid: Int = js.native
  var gid: Int = js.native
  var rdev: Int = js.native
  var blksize: Int = js.native
  var ino: Int = js.native
  var size: Int = js.native
  var blocks: Int = js.native

  /**
    * "Access Time" - Time when file data last accessed. Changed by the mknod(2), utimes(2), and read(2) system calls.
    */
  var atime: js.Date = js.native

  /**
    * "Modified Time" - Time when file data last modified. Changed by the mknod(2), utimes(2), and write(2) system calls.
    */
  var mtime: js.Date = js.native

  /**
    * "Change Time" - Time when file status was last changed (inode data modification). Changed by the chmod(2),
    * chown(2), link(2), mknod(2), rename(2), unlink(2), utimes(2), read(2), and write(2) system calls.
    */
  var ctime: js.Date = js.native

  /**
    * "Birth Time" - Time of file creation. Set once when the file is created. On filesystems where birthtime is not
    * available, this field may instead hold either the ctime or 1970-01-01T00:00Z (ie, unix epoch timestamp 0).
    * Note that this value may be greater than atime or mtime in this case. On Darwin and other FreeBSD variants,
    * also set if the atime is explicitly set to an earlier value than the current birthtime using the utimes(2) system call.
    */
  var birthtime: js.Date = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def isFile(): Boolean = js.native

  def isDirectory(): Boolean = js.native

  def isBlockDevice(): Boolean = js.native

  def isCharacterDevice(): Boolean = js.native

  /**
    * (only valid with fs.lstat())
    */
  def isSymbolicLink(): Boolean = js.native

  def isFIFO(): Boolean = js.native

  def isSocket(): Boolean = js.native

}
