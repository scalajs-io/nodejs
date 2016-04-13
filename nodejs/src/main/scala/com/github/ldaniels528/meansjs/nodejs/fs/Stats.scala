package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js

/**
  * Objects returned from fs.stat(), fs.lstat() and fs.fstat() and their synchronous counterparts are of this type.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stats extends js.Object {

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
