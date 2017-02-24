package io.scalajs.nodejs.path

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * This module contains utilities for handling and transforming file paths. The file system is not consulted to
  * check whether paths are valid.
  * @see https://nodejs.org/docs/latest/api/path.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Path extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The platform-specific path delimiter, ';' or ':'.
    */
  def delimiter: String = js.native

  /**
    * Provide access to aforementioned path methods but always interact in a posix compatible way.
    */
  def posix: Path = js.native

  /**
    * The platform-specific file separator, '\\' or '/'.
    */
  def sep: String = js.native

  /**
    * Provide access to aforementioned path methods but always interact in a win32 compatible way.
    */
  def win32: Path = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Return the last portion of a path, similar to the Unix basename command.
    * @param path must be a string.
    * @param ext  optional, if given, must also be a string.
    * @return the last portion of a path
    */
  def basename(path: String, ext: String = js.native): String = js.native

  /**
    * Return the directory name of a path, similar to the Unix dirname command.
    * @param path must be a string.
    * @return the directory name of a path
    */
  def dirname(path: String): String = js.native

  /**
    * Return the extension of the path, from the last '.' to end of string in the last portion of the path.
    * If there is no '.' in the last portion of the path or the first character of it is '.', then it returns an empty string.
    * @param path must be a string.
    * @return the extension of the path (e.g. ".jpg")
    */
  def extname(path: String): String = js.native

  /**
    * Returns a path string from an object. This is the opposite of [[Path.parse path.parse]].
    * If pathObject has dir and base properties, the returned string will be a concatenation of the dir property,
    * the platform-dependent path separator, and the base property.
    * If the dir property is not supplied, the root property will be used as the dir property. However, it will be
    * assumed that the root property already ends with the platform-dependent path separator. In this case, the returned
    * string will be the concatenation of the root property and the base property.
    * If both the dir and the root properties are not supplied, then the returned string will be the contents of the base property.
    * If the base property is not supplied, a concatenation of the name property and the ext property will be used as the base property.
    * @param pathObject the given path object
    * @return a path string from an object
    */
  def format(pathObject: PathObject): String = js.native

  /**
    * Determines whether path is an absolute path. An absolute path will always resolve to the same location, regardless
    * of the working directory.
    * @param path must be a string.
    * @return true, if the path is an absolute path
    */
  def isAbsolute(path: String): Boolean = js.native

  /**
    * Join all arguments together and normalize the resulting path.
    * @param path1 the first portion of the path
    * @param path2 All arguments must be strings. In v0.8, non-string arguments were silently ignored. In v0.10 and up,
    *              an exception is thrown.
    * @return a composite path
    */
  def join(path1: String, path2: String*): String = js.native

  /**
    * Normalize a path, taking care of '..' and '.' parts. path must be a string.
    * When multiple slashes are found, they're replaced by a single one; when the path contains a trailing slash,
    * it is preserved. On Windows backslashes are used.
    * @param path the path to be normalized
    * @return the normalized path
    */
  def normalize(path: String): String = js.native

  /**
    * Returns an object from a path.
    * @param path must be a string.
    * @return an [[PathObject object]] from a path.
    */
  def parse(path: String): PathObject = js.native

  /**
    * Solve the relative path from from to to.
    *
    * At times we have two absolute paths, and we need to derive the relative path from one to the other.
    * This is actually the reverse transform of path.resolve, which means we see that:
    * {{{ path.resolve(from, path.relative(from, to)) == path.resolve(to) }}}
    * @param from must be a string.
    * @param to   must be a string.
    * @return the relative path
    */
  def relative(from: String, to: String): String = js.native

  /**
    * Resolves to to an absolute path.
    * If to isn't already absolute from arguments are prepended in right to left order, until an absolute path is found.
    * If after using all from paths still no absolute path is found, the current working directory is used as well.
    * The resulting path is normalized, and trailing slashes are removed unless the path gets resolved to the root directory.
    * Empty string from arguments are ignored.
    * @param args All arguments must be strings.
    * @return the absolute path
    * @example {{{ path.resolve([from ...], to) }}}
    */
  def resolve(args: String*): String = js.native

}

/**
  * Path Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("path", JSImport.Namespace)
object Path extends Path