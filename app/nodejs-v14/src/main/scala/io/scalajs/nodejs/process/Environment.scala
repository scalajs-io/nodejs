package io.scalajs.nodejs.process

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

@js.native
trait Environment extends js.Object {
  // common for unix-like and windows
  def PATH: String = js.native

  // unix-like
  def `_` : js.UndefOr[String]            = js.native
  def HOME: js.UndefOr[String]            = js.native
  def PWD: js.UndefOr[String]             = js.native
  def LD_LIBRARY_PATH: js.UndefOr[String] = js.native
  def LIBPATH: js.UndefOr[String]         = js.native
  def SHLIB_PATH: js.UndefOr[String]      = js.native
  def LANG: js.UndefOr[String]            = js.native
  def TZ: js.UndefOr[String]              = js.native
  def DISPLAY: js.UndefOr[String]         = js.native
  def PS1: js.UndefOr[String]             = js.native
  def OSTYPE: js.UndefOr[String]          = js.native
  def TERM: js.UndefOr[String]            = js.native
  def SHELL: js.UndefOr[String]           = js.native
  def USER: js.UndefOr[String]            = js.native
  def EDITOR: js.UndefOr[String]          = js.native
  def SHLVL: js.UndefOr[String]           = js.native
  def LOGNAME: js.UndefOr[String]         = js.native

  @JSBracketAccess
  def apply(key: String): js.UndefOr[String] = js.native

  @JSBracketAccess
  def update(key: String, value: String): Unit = js.native
}
