package io.scalajs.npm.jvm

import scala.scalajs.js

/**
  * Inspired by java.io.FilenameFilter
  * @see [[https://docs.oracle.com/javase/10/docs/api/java/io/FilenameFilter.html]]
  * @author lawrence.daniels@gmail.com
  */
trait FilenameFilter extends js.Object {

  /**
    * Tests if a specified file should be included in a file list.
    * @param dir  the directory in which the file was found.
    * @param name the name of the file.
    * @return true if and only if the name should be included in the file list; false otherwise.
    */
  def accept​(dir: File, name: String): Boolean

}
