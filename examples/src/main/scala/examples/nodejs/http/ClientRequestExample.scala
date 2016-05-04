package examples.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.http.ServerResponse
import com.github.ldaniels528.meansjs.nodejs.request.Request
import com.github.ldaniels528.meansjs.nodejs.{Require, console}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

/**
  * Client Request Example
  * @author lawrence.daniels@gmail.com
  */
class ClientRequestExample(require: Require) {

  val request = require[Request]("request")
  request("http://www.google.com", (error: String, response: ServerResponse, body: String) => {
    if (!isDefined(error) && response.statusCode == 200) {
      console.log(body) // Show the HTML for the Google homepage.
    }
  })

}

