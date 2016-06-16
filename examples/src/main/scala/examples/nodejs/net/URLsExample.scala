package examples.nodejs.net

import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.url.URL

/**
  * URLs
  * @author lawrence.daniels@gmail.com
  */
class URLsExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val url = require[URL]("url")

  val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
  val parsedUrl = url.parse(originalUrl)

  console.log("url => %j", parsedUrl)
  console.log("parsedUrl => %j", parsedUrl)
  console.log("query =>", parsedUrl.query)
  console.log("search =>", parsedUrl.search)
  console.log("url => %j", url.format(parsedUrl))

}
