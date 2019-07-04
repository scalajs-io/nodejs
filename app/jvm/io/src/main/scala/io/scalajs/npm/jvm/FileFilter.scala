package io.scalajs.npm.jvm

import scala.scalajs.js

/**
  * Inspired by java.io.FileFilter
  * @see [[https://docs.oracle.com/javase/10/docs/api/java/io/File.html]]
  * @author lawrence.daniels@gmail.com
  */
trait FileFilter extends js.Object {

  /**
    * Tests whether or not the specified abstract pathname should be included in a pathname list.
    * @param pathname The abstract pathname to be tested
    * @return true if and only if pathname should be included
    */
  def accept​(pathname: File): Boolean

}
