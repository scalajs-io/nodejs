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
  var dev: Int
  var mode: Int
  var nlink: Int
  var uid: Int
  var gid: Int
  var rdev: Int
  var blksize: Int
  var ino: Int
  var size: Int
  var blocks: Int
  var atime: js.Date
  var mtime: js.Date
  var ctime: js.Date
  var birthtime: js.Date
}
