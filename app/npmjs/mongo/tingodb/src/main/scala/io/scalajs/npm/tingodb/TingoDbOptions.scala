package io.scalajs.npm.tingodb

import scala.scalajs.js


/**
  * TingoDB Options
  * @param memStore        Enable in memory (no file access) mode. Can be useful for unit tests.
  *                        File path will be used as db identity (default: false).
  * @param nativeObjectID  Doing some experimentation we found that using integer keys we can get the
  *                        database to work faster and save some space. Additionally, for in-process
  *                        databases there are almost no drawbacks versus globally unique keys.
  *                        However, at the same time, it is relatively hard to keep unique integer keys
  *                        outside of the database engine, so we made it part of the database engine code.
  *                        Generated keys will be unique in the collection scope (default: false).
  * @param cacheSize       Maximum number of cached objects per collection (default: 1000).
  * @param cacheMaxObjSize Maximum size of objects that can be placed in the cache (default: 1024).
  * @param searchInArray   Globally enables support of search in nested arrays. MongoDB supports this
  *                        unconditionally. For TingoDB, searching arrays when there are no arrays incurs
  *                        a performance penalty. That's why this is switched off by default.
  *                        Additionally, and this might be a better approach, nested array support can be
  *                        enabled for individual indexes or search queries.
  */

class TingoDbOptions(var memStore: js.UndefOr[Boolean] = js.undefined,
                     var nativeObjectID: js.UndefOr[Boolean] = js.undefined,
                     var cacheSize: js.UndefOr[Int] = js.undefined,
                     var cacheMaxObjSize: js.UndefOr[Int] = js.undefined,
                     var searchInArray: js.UndefOr[Boolean] = js.undefined)
  extends js.Object
