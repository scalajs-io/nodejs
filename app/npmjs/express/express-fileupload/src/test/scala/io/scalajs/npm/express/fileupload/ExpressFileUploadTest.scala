package io.scalajs.npm.express.fileupload

import io.scalajs.nodejs.os.OS
import io.scalajs.npm.express._
import org.scalatest.FunSpec

/**
  * Express File Upload Test
  * @author lawrence.daniels@gmail.com
  */
class ExpressFileUploadTest extends FunSpec {

  describe("ExpressFileUpload") {

    it("supports uploading files") {

      val app = Express()
      app.use(ExpressFileUpload())

      app.post("/upload", (req: Request with UploadedFiles, res: Response) => {
        if (req.files.isEmpty) res.send("No files were uploaded.")
        else {
          // The name of the input field (i.e. "sampleFile") is used to retrieve the uploaded file
          req.files foreach { case (name, file) =>
            // Use the mv() method to place the file somewhere on your server
            file.mv(s"${OS.tmpdir()}/$name", { err =>
              if (err != null) res.status(500).send(err) else res.send("File uploaded!")
            })
          }
        }
      })

    }

  }

}
