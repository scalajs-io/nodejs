package io.scalajs.npm.glob

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.EventEmitter
import io.scalajs.nodejs.fs.Stats

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * glob - a little globber.
  * @param pattern  the pattern to search for
  * @param options  the optional [[GlobOptions settings]]
  * @param callback the optional callback
  * @example {{{ new glob.Glob(pattern, [options], [cb]) }}}
  */
@js.native
@JSImport("glob", "Glob")
class Glob(val pattern: String, val options: GlobOptions, callback: GlobCallback) extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constructors
  /////////////////////////////////////////////////////////////////////////////////

  def this(pattern: String) = this(pattern, js.native, js.native)

  def this(pattern: String, options: GlobOptions) = this(pattern, options, js.native)

  def this(pattern: String, callback: GlobCallback) = this(pattern, js.native, callback)

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The minimatch object that the glob uses.
    */
  var minimatch: js.Any = js.native

  /**
    * is set to true when calling abort().
    * There is no way at this time to continue a glob search after aborting, but you can re-use
    * the statCache to avoid having to duplicate syscalls.
    */
  var aborted: js.UndefOr[Boolean] = js.native

  /**
    * Convenience object. Each field has the following possible values:
    * <ul>
    * <li>false - Path does not exist</li>
    * <li>true - Path exists</li>
    * <li>'FILE' - Path exists, and is not a directory</li>
    * <li>'DIR' - Path exists, and is a directory</li>
    * <li>[file, entries, ...] - Path exists, is a directory, and the array value is the results of fs.readdir</li>
    * </ul>
    */
  var cache: js.Any = js.native // Boolean | String | js.Array[String] = js.native

  /**
    * The filenames found matching the pattern
    */
  def found: js.Array[String] = js.native

  /**
    * Cache of fs.stat results, to prevent statting the same path multiple times.
    */
  var statCache: Stats = js.native

  /**
    * A record of which paths are symbolic links, which is relevant in resolving ** patterns.
    */
  var symlinks: js.Any = js.native

  /**
    * An optional object which is passed to fs.realpath to minimize unnecessary syscalls.
    * It is stored on the instantiated Glob object, and may be re-used.
    */
  var realpathCache: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Stop the search forever
    */
  def abort(): Unit = js.native

  /**
    * Temporarily stop the search
    */
  def pause(): Unit = js.native

  /**
    * Resume the search
    */
  def resume(): Unit = js.native

}

/**
  * Glob Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("glob", JSImport.Namespace)
object Glob extends GlobClass

/**
  * Glob Singleton Object definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GlobClass extends js.Object {

  /**
    * Perform an asynchronous glob search.
    * @param pattern  the pattern to be matched
    * @param options  the optional [[GlobOptions settings]]
    * @param callback the callback
    */
  def apply(pattern: String, options: GlobOptions | RawOptions, callback: GlobCallback): Unit = js.native

  /**
    * Perform an asynchronous glob search.
    * @param pattern  the pattern to be matched
    * @param callback the callback
    */
  def apply(pattern: String, callback: GlobCallback): Unit = js.native

  /**
    * Returns true if there are any special characters in the pattern, and false otherwise.
    * @param pattern the pattern to be matched
    * @param options the optional [[GlobOptions settings]]
    * @return true if there are any special characters in the pattern, and false otherwise.
    */
  def hasMagic(pattern: String, options: GlobOptions | RawOptions = js.native): Boolean = js.native

  /**
    * Perform a synchronous glob search.
    * @param pattern the pattern to be matched
    * @param options the optional [[GlobOptions settings]]
    * @return the filenames found matching the pattern
    */
  def sync(pattern: String, options: GlobOptions | RawOptions = js.native): js.Array[String] = js.native

}
