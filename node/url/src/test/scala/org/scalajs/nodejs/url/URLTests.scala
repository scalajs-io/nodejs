package org.scalajs.nodejs.url

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.util.JSONHelper._
import utest._

/**
  * URL Tests
  * @author lawrence.daniels@gmail.com
  */
object URLTests extends TestSuite {

  override val tests = this {
    val url = URL()

    "url.parse()" - {
      val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
      val parsedUrl = url.parse(originalUrl)

      "the URL should be broken down into the expected components" - {
        parsedUrl.toJson ==> """{"protocol":"https:","slashes":true,"auth":null,"host":"www.google.com","port":null,"hostname":"www.google.com","hash":"#q=node","search":"?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","query":"sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","pathname":"/webhp","path":"/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","href":"https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"}"""
      }

      "the query should be properly extracted" - {
        parsedUrl.query ==> "sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8"
      }

      "the search query should be properly extracted" - {
        parsedUrl.search ==> "?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8"
      }

      "the reconstituted URL should match the original" - {
        url.format(parsedUrl) ==> originalUrl
      }
    }

  }

}
