package examples.nodejs.http

import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.http.ServerResponse
import org.scalajs.nodejs.request.Request

/**
  * Client Request Streaming Example
  * @author lawrence.daniels@gmail.com
  */
class ClientRequestStreamingExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val request = Request()
  request
    .get("http://google.com/img.png")
    .on("response", (response: ServerResponse) => {
      console.log(response.statusCode) // 200
      console.log(response.headers("content-type")) // "image/png"
    })
    .pipe(request.put("http://mysite.com/img.png"))

}
