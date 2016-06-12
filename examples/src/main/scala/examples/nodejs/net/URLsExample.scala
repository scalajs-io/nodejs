package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.url.URL
import org.scalajs.dom.console

/**
  * URLs
  * @author lawrence.daniels@gmail.com
  */
class URLsExample(bootstrap: Bootstrap) {
  import bootstrap._

  val url = require[URL]("url")

  val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
  val parsedUrl = url.parse(originalUrl)

  console.log("url => %j", parsedUrl)
  console.log("parsedUrl => %j", parsedUrl)
  console.log("query =>", parsedUrl.query)
  console.log("search =>", parsedUrl.search)
  console.log("url => %j", url.format(parsedUrl))

}
