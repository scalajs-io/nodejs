package io.scalajs.nodejs.fs

import scala.scalajs.js

/**
  * fs.Stats (Stat Time Values) - Objects returned from fs.stat(), fs.lstat() and fs.fstat() and their synchronous
  * counterparts are of this type.
  * @since 0.1.21
  */
@js.native
trait Stats extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def dev: Int = js.native

  def mode: Int = js.native

  def nlink: Int = js.native

  def uid: Int = js.native

  def gid: Int = js.native

  def rdev: Int = js.native

  def blksize: Int = js.native

  def ino: Int = js.native

  def size: Double = js.native

  def blocks: Double = js.native

  /**
    * "Access Time" - Time when file data last accessed. Changed by the mknod(2), utimes(2), and read(2) system calls.
    */
  def atime: js.Date = js.native

  /**
    * "Modified Time" - Time when file data last modified. Changed by the mknod(2), utimes(2), and write(2) system calls.
    */
  def mtime: js.Date = js.native

  /**
    * "Change Time" - Time when file status was last changed (inode data modification). Changed by the chmod(2),
    * chown(2), link(2), mknod(2), rename(2), unlink(2), utimes(2), read(2), and write(2) system calls.
    */
  def ctime: js.Date = js.native

  /**
    * "Birth Time" - Time of file creation. Set once when the file is created. On filesystems where birthtime is not
    * available, this field may instead hold either the ctime or 1970-01-01T00:00Z (ie, unix epoch timestamp 0).
    * Note that this value may be greater than atime or mtime in this case. On Darwin and other FreeBSD variants,
    * also set if the atime is explicitly set to an earlier value than the current birthtime using the utimes(2) system call.
    */
  def birthtime: js.Date = js.native

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
