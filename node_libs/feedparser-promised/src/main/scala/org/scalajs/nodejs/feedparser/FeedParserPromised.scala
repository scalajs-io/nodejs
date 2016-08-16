package org.scalajs.nodejs.feedparser

import org.scalajs.nodejs._
import org.scalajs.nodejs.feedparser.FeedParserPromised.{ RSSFeed, RSSImage }

import scala.scalajs.js

/**
  * Wrapper around feedparser with promises
  * Installation: npm install --save feedparser-promised
  * @see [[https://www.npmjs.com/package/feedparser-promised]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FeedParserPromised extends NodeModule {

  def parse(url: String): js.Promise[js.Array[RSSFeed]] = js.native

}

/**
  * Feed Parser Promised Companion
  * @author lawrence.daniels@gmail.com
  */
object FeedParserPromised {

  /**
    * Convenience method for retrieving the 'filed' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Filed instance
    */
  def apply()(implicit require: NodeRequire) = require[FeedParserPromised]("feedparser-promised")

  /**
    * RSS Feed Item
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait RSSFeed extends js.Object {
    // article title
    var title: String = js.native

    // frequently, the full article content
    var description: String = js.native

    // frequently, an excerpt of the article content
    var summary: String = js.native

    // article link/url
    var link: String = js.native

    // when FeedBurner or Pheedo puts a special tracking url in the link property, origlink contains the original link
    var origlink: String = js.native

    // when an RSS feed has a guid field and the isPermalink attribute is not set to false, permalink contains the value of guid
    var permalink: String = js.native

    // most recent update
    var date: js.Date = js.native

    // original published date
    var pubdate: js.Date = js.native
    var pubDate: js.Date = js.native

    // article author
    var author: String = js.native

    // a unique identifier for the article
    var guid: String = js.native

    // a link to the article's comments section
    var comments: js.Array[String] = js.native

    // an Object containing url and title properties
    var image: RSSImage = js.native

    // an Array of Strings
    var categories: js.Array[String] = js.native

    // an Object containing url and title properties pointing to the original source for an article; see the RSS Spec for an explanation of this element
    var source: js.Object = js.native

    // an Array of Objects, each representing a podcast or other enclosure and having a url property and possibly type and length properties
    var enclosures: js.Array[js.Object] = js.native

    // an Object containing all the feed meta properties; especially handy when using the EventEmitter interface to listen to article emissions
    var meta: js.Object = js.native

  }

  @js.native
  trait RSSImage extends js.Object {
    var url: String = js.native
  }

}