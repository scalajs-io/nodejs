package examples.nodejs.http

import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.http.ServerResponse
import org.scalajs.nodejs.request.Request
import org.scalajs.nodejs.util.ScalaJsHelper

/**
  * Client Request Example
  * @author lawrence.daniels@gmail.com
  */
class ClientRequestExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val request = Request()
  request("http://www.google.com", (error: String, response: ServerResponse, body: String) => {
    if (!isDefined(error) && response.statusCode == 200) {
      console.log(body) // Show the HTML for the Google homepage.
    }
  })

}

