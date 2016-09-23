package org.scalajs.nodejs.request

import org.scalajs.nodejs.console
import org.scalajs.nodejs.http.ServerResponse
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

/**
  * Request Tests
  * @author lawrence.daniels@gmail.com
  */
class RequestTests extends TestSuite {

  override val tests = this {
    val request = Request()

    "asynchronous" - {
      request("http://www.google.com", (error: String, response: ServerResponse, body: String) => {
        if (!isDefined(error) && response.statusCode == 200) {
          console.log(body) // Show the HTML for the Google homepage.
        }
      })
    }

    "streaming" - {
      request
        .get("http://google.com/img.png")
        .on("response", (response: ServerResponse) => {
          console.log(response.statusCode) // 200
          console.log(response.headers("content-type")) // "image/png"
        })
        .pipe(request.put("http://mysite.com/img.png"))
    }

  }

}
