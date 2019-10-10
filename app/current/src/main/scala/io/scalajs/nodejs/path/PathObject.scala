package io.scalajs.nodejs.path

import scala.scalajs.js

/**
  * Path Object
  */
class PathObject(var root: js.UndefOr[String] = js.undefined,
                 var dir: js.UndefOr[String] = js.undefined,
                 var base: js.UndefOr[String] = js.undefined,
                 var ext: js.UndefOr[String] = js.undefined,
                 var name: js.UndefOr[String] = js.undefined)
    extends js.Object
