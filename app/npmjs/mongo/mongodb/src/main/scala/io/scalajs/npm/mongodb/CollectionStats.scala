package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Collection Statistics
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CollectionStats extends js.Object with Okayable {
  var ns: String = js.native
  var size: Double = js.native
  var avgObjSize: Double = js.native
  var storageSize: Double = js.native
  var capped: Boolean = js.native
  var count: Int = js.native
  var nindexes: Int = js.native
  var totalIndexSize: Int = js.native
  var indexSizes: js.Any = js.native
  var wiredTiger: js.Object = js.native
}