package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Index Options
  * @param w                  The write concern (number | string;	default: null).
  * @param wtimeout           The write concern timeout (default: null).
  * @param j                  Specify a journal write concern (default: false).
  * @param unique             Creates an unique index (default: false).
  * @param sparse             Creates a sparse index (default: false).
  * @param background         Creates the index in the background, yielding whenever possible (default: false).
  * @param dropDups           A unique index cannot be created on a key that has pre-existing duplicate values.
  *                           If you would like to create the index anyway keeping the first document the database
  *                           indexes and deleting all
  *                           subsequent documents that have duplicate value (default: false).
  * @param min                For geospatial indexes set the lower bound for the co-ordinates (default: null).
  * @param max                For geospatial indexes set the high bound for the co-ordinates (default: null).
  * @param v                  Specify the format version of the indexes (default: null).
  * @param expireAfterSeconds Allows you to expire data on indexes applied to a data (MongoDB 2.2 or higher) (default: null).
  * @param name               Override the auto-generated index name (useful if the resulting name is larger than
  *                           128 bytes) (default: null)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class IndexOptions(var w: js.Any = null,
                   var wtimeout: Integer = null,
                   var j: Boolean = false,
                   var unique: Boolean = false,
                   var sparse: Boolean = false,
                   var background: Boolean = false,
                   var dropDups: Boolean = false,
                   var min: Integer = null,
                   var max: Integer = null,
                   var v: Integer = null,
                   var expireAfterSeconds: Integer = null,
                   var name: Integer = null)
    extends js.Object
