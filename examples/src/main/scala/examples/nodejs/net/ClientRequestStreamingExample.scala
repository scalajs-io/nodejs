package examples.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.http.ServerResponse
import com.github.ldaniels528.meansjs.nodejs.request.Request
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

/**
  * Client Request Streaming Example
  * @author lawrence.daniels@gmail.com
  */
class ClientRequestStreamingExample(bootstrap: Bootstrap) {
  import bootstrap._

  val request = require[Request]("request")
  request
    .get("http://google.com/img.png")
    .on("response", (response: ServerResponse) => {
      console.log(response.statusCode) // 200
      console.log(response.headers("content-type")) // "image/png"
    })
    .pipe(request.put("http://mysite.com/img.png"))

}
