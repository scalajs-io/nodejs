package io.scalajs.npm.formdata

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.http.{Http, ServerResponse}
import io.scalajs.npm.request.{Request => ClientRequest}
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

/**
  * FormData Tests
  * @author lawrence.daniels@gmail.com
  */
class FormDataTest extends FunSpec {

  describe("FormData") {

    it("supports string, buffer and readable values") {
      val form = FormData()
      form.append("my_field", "my value")
      form.append("my_buffer", new Buffer(10))
      form.append("my_file", Fs.createReadStream("/foo/bar.jpg"))
    }

    it("supports http-response stream") {
      val form = FormData()
      Http.request("http://nodejs.org/images/logo.png", (response: ServerResponse) => {
        form.append("my_field", "my value")
        form.append("my_buffer", new Buffer(10))
        form.append("my_logo", response)
      })
    }

    it("supports request-stream") {
      val form = FormData()
      form.append("my_field", "my value")
      form.append("my_buffer", new Buffer(10))
      form.append("my_logo", ClientRequest("http://nodejs.org/images/logo.png"))
    }

    it("supports form-submit / response-resume") {
      val form = FormData()
      form.submit("http://example.org/", (err, res) => {
        // res – response object (http.IncomingMessage)  // 
        res.resume()
      })
    }

    it("supports custom header and pre-known lengths") {
      val CRLF = "\r\n"
      val form = FormData()
      val buffer = new Buffer(10)
      val options = new FormOptions(
        header = CRLF + "--" + form.getBoundary() + CRLF + "X-Custom-Header: 123" + CRLF + CRLF,
        knownLength = 1
      )

      form.append("my_buffer", buffer, options)
      form.submit("http://example.com/", (err, res) => {
        if (isDefined(err)) throw err
        info("Done")
      })
    }

  }

}
