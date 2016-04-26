package examples.nodejs.basics

import com.github.ldaniels528.meansjs.nodejs.Require
import com.github.ldaniels528.meansjs.nodejs.url.URL
import org.scalajs.dom.console

/**
  * URLs
  * @author lawrence.daniels@gmail.com
  */
class URLs(require: Require) {

  val url = require[URL]("url")
  val parsedUrl = url.parse("https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node")

  console.log("parsedUrl = %j", parsedUrl)
  console.log("query = %j", parsedUrl.query)
  console.log("search = %j", parsedUrl.search)
  console.log("url = %j", url.format(parsedUrl))

}
