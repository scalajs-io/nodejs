package io.scalajs.npm.feedparser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Wrapper around feedparser with promises
  * @version 1.1.1
  * @see https://www.npmjs.com/package/feedparser-promised
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FeedParserPromised extends js.Object {

  def parse(url: String): js.Promise[js.Array[RSSFeed]] = js.native

}

/**
  * Feed Parser Promised Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("feedparser-promised", JSImport.Namespace)
object FeedParserPromised extends FeedParserPromised