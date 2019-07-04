package io.scalajs.npm.mkdirp

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * mkdirp - Recursively mkdir, like mkdir -p
  * @see https://www.npmjs.com/package/mkdirp
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Mkdirp extends js.Object {

  /**
    * Create a new directory and any necessary subdirectories at dir with octal permission string opts.mode.
    * If opts is a non-object, it will be treated as the opts.mode.
    *
    * If opts.mode isn't specified, it defaults to 0777 & (~process.umask()).
    *
    * cb(err, made) fires with the error or the first directory made that had to be created, if any.
    *
    * You can optionally pass in an alternate fs implementation by passing in opts.fs.
    * Your implementation should have opts.fs.mkdir(path, mode, cb) and opts.fs.stat(path, cb).
    * @param path     the directory path
    * @param callback the callback/error handler
    * @example {{{ mkdirp(dir, opts, cb) }}}
    */
  def apply(path: String, callback: MkdirpCallback): Unit = js.native

  /**
    * Create a new directory and any necessary subdirectories at dir with octal permission string opts.mode.
    * If opts is a non-object, it will be treated as the opts.mode.
    *
    * If opts.mode isn't specified, it defaults to 0777 & (~process.umask()).
    *
    * cb(err, made) fires with the error or the first directory made that had to be created, if any.
    *
    * You can optionally pass in an alternate fs implementation by passing in opts.fs.
    * Your implementation should have opts.fs.mkdir(path, mode, cb) and opts.fs.stat(path, cb).
    * @param path     the directory path
    * @param options  the optional settings
    * @param callback the callback/error handler
    * @example {{{ mkdirp(dir, opts, cb) }}}
    */
  def apply(path: String, options: MkdirpOptions, callback: MkdirpCallback): Unit = js.native

  /**
    * Synchronously create a new directory and any necessary subdirectories at dir with octal permission
    * string opts.mode. If opts is a non-object, it will be treated as the opts.mode.
    *
    * If opts.mode isn't specified, it defaults to 0777 & (~process.umask()).
    *
    * Returns the first directory that had to be created, if any.
    *
    * You can optionally pass in an alternate fs implementation by passing in opts.fs.
    * Your implementation should have opts.fs.mkdirSync(path, mode) and opts.fs.statSync(path).
    * @param path    the directory path
    * @param options the optional settings
    * @example {{{ mkdirp.sync(dir, options) }}}
    */
  def sync(path: String, options: MkdirpOptions = js.native): String = js.native

}

/**
  * Mkdirp Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mkdirp", JSImport.Namespace)
object Mkdirp extends Mkdirp

/**
  * Mkdirp Optional Settings
  * @param mode the given mode
  */

class MkdirpOptions(val mode: js.UndefOr[Int] = js.undefined) extends js.Object