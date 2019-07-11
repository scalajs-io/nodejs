package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Collection Information
  * @example {{{
  *   {
  *     "name":"listing_activity",
  *     "type":"collection",
  *     "options":{},
  *     "info":{"readOnly":false},
  *     "idIndex":{"v":2,"key":{"_id":1},"name":"_id_","ns":"mi.listing_activity"}
  *   }
  * }}}
  * @author lawrence.daniels@gmail.com
  */
class CollectionInfo(var name: String,
                     var `type`: String,
                     var options: js.Any,
                     var info: CollectionInfo.Info,
                     var idIndex: CollectionInfo.IdIndex) extends js.Object

/**
  * Collection Information Companion
  */
object CollectionInfo extends FlexibleOptions[CollectionInfo] {

  /**
    * Collection Information: Info
    * @author lawrence.daniels@gmail.com
    */
  class Info(var readOnly: Boolean) extends js.Object

  /**
    * Collection Information: Info Companion
    * @author lawrence.daniels@gmail.com
    */
  object Info extends FlexibleOptions[Info]

  /**
    * Collection Information: IdIndex
    * @author lawrence.daniels@gmail.com
    */
  class IdIndex(var v: Int,
                var key: js.Any,
                var name: String,
                var ns: String) extends js.Object

  /**
    * Collection Information: IdIndex Companion
    * @author lawrence.daniels@gmail.com
    */
  object IdIndex extends FlexibleOptions[IdIndex]

}