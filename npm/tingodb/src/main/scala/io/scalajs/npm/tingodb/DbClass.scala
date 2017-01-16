package io.scalajs.npm.tingodb

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * TingoDb Db class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DbClass extends js.Object

/**
  * DbClass Companion
  * @author lawrence.daniels@gmail.com
  */
object DbClass {

  implicit class DbClassEnrichment(val `class`: DbClass) extends AnyVal {

    def apply(path: String, opts: js.Any = null): Db = `class`.New[Db](path, opts)

  }

}