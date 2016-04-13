package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js

/**
  * Stat Time
  * <pre>
  * {
  * "dev": 16777220,
  * "mode": 33188,
  * "nlink": 1,
  * "uid": 501,
  * "gid": 0,
  * "rdev": 0,
  * "blksize": 4096,
  * "ino": 203412817,
  * "size": 0,
  * "blocks": 0,
  * "atime": "2016-04-12T15:49:34.000Z",
  * "mtime": "2016-04-12T15:49:34.000Z",
  * "ctime": "2016-04-12T15:49:34.000Z",
  * "birthtime": "2016-04-12T15:49:34.000Z"
  * }
  * </pre>
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StatTime extends js.Object {
  var dev: Int = js.native
  var mode: Int = js.native
  var nlink: Int = js.native
  var uid: Int = js.native
  var gid: Int = js.native
  var rdev: Int = js.native
  var blksize: Int = js.native
  var ino: Int = js.native
  var size: Int = js.native
  var blocks: Int = js.native
  var atime: js.Date = js.native
  var mtime: js.Date = js.native
  var ctime: js.Date = js.native
  var birthtime: js.Date = js.native
}
