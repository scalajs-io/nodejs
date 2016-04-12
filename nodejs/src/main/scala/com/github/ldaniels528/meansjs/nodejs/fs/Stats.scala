package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js

/**
  * Objects returned from fs.stat(), fs.lstat() and fs.fstat() and their synchronous counterparts are of this type.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stats extends js.Object {

  def isFile(): Boolean

  def isDirectory(): Boolean

  def isBlockDevice(): Boolean

  def isCharacterDevice(): Boolean

  /**
    * (only valid with fs.lstat())
    */
  def isSymbolicLink(): Boolean

  def isFIFO(): Boolean

  def isSocket(): Boolean

}
