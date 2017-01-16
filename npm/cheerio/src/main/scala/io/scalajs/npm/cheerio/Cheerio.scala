package io.scalajs.npm.cheerio

import io.scalajs.npm.htmlparser2.ParserOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Tiny, fast, and elegant implementation of core jQuery designed specifically for the server
  * @version 0.22.0
  * @see https://www.npmjs.com/package/cheerio
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Cheerio extends js.Object {

  /**
    * Load in the HTML. (See the previous section titled "Loading" for more information.)
    */
  def load(html: String, options: ParserOptions = js.native): CheerioJQuery = js.native

}

/**
  * Cheerio Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cheerio", JSImport.Namespace)
object Cheerio extends Cheerio