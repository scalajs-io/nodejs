package io.scalajs.nodejs.fs

import scala.scalajs.js

/**
  * When [[Fs.readdir()]] or [[Fs.readdirSync()]] is called with the withFileTypes option set to true,
  * the resulting array is filled with fs.Dirent objects, rather than strings or Buffers.
  */
@js.native
trait Dirent extends js.Object {

  /**
    * The file name that this fs.Dirent object refers to. The type of this value is determined by
    * the options.encoding passed to [[Fs.readdir()]] or [[Fs.readdirSync()]].
    */
  def name: String = js.native

  /**
    * Returns true if the fs.Dirent object describes a block device.
    * @return true if the fs.Dirent object describes a block device.
    */
  def isBlockDevice(): Boolean = js.native

  /**
    * Returns true if the fs.Dirent object describes a character device.
    * @return true if the fs.Dirent object describes a character device.
    */
  def isCharacterDevice(): Boolean = js.native

  /**
    * Returns true if the fs.Dirent object describes a file system directory.
    * @return true if the fs.Dirent object describes a file system directory.
    */
  def isDirectory(): Boolean = js.native

  /**
    * Returns true if the fs.Dirent object describes a first-in-first-out (FIFO) pipe.
    * @return true if the fs.Dirent object describes a first-in-first-out (FIFO) pipe.
    */
  def isFIFO(): Boolean = js.native

  /**
    * Returns true if the fs.Dirent object describes a regular file.
    * @return true if the fs.Dirent object describes a regular file.
    */
  def isFile(): Boolean = js.native

  /**
    * Returns true if the fs.Dirent object describes a socket.
    * @return true if the fs.Dirent object describes a socket.
    */
  def isSocket(): Boolean = js.native


  /**
    * Returns true if the fs.Dirent object describes a symbolic link.
    * @return true if the fs.Dirent object describes a symbolic link.
    */
  def isSymbolicLink(): Boolean = js.native

}
