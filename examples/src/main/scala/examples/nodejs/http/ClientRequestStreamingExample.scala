package examples.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.http.ServerResponse
import com.github.ldaniels528.meansjs.nodejs.request.Request
import com.github.ldaniels528.meansjs.nodejs.{Require, console}

/**
  * Client Request Streaming Example
  * @author lawrence.daniels@gmail.com
  */
class ClientRequestStreamingExample(require: Require) {

  val request = require[Request]("request")
  request
    .get("http://google.com/img.png")
    .on("response", (response: ServerResponse) => {
      console.log(response.statusCode) // 200
      console.log(response.headers("content-type")) // "image/png"
    })
    .pipe(request.put("http://mysite.com/img.png"))

}
