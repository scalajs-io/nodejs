package io.scalajs.npm.express.multer

import io.scalajs.npm.express._
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Multer Tests
  * @author lawrence.daniels@gmail.com
  */
class MulterTest extends FunSpec {

  describe("MulterTest") {

    it("handles simple file uploads") {
      val app = Express()
      val upload = Multer(new MulterOptions(dest = "uploads/"))
      app.post("/profile", upload.array(), (req: Request, res: Response, next: js.Function) => {
        // req.body contains the text fields
      })
    }

    it("handles multi-part file uploads") {
      val upload = Multer(new MulterOptions(dest = "uploads/"))
      val app = Express()
      app.post("/profile", upload.single("avatar"), (req: Request, res: Response, next: js.Function) => {
        // req.file is the `avatar` file
        // req.body will hold the text fields, if there were any
      })

      app.post("/photos/upload", upload.array("photos", 12), (req: Request, res: Response, next: js.Function) => {
        // req.files is array of `photos` files
        // req.body will contain the text fields, if there were any
      })

      val cpUpload = upload.fields(js.Array(new MulterField(name = "avatar", maxCount = 1), new MulterField(name = "gallery", maxCount = 8)))
      app.post("/cool-profile", cpUpload, (req: Request, res: Response, next: js.Function) => {
        // req.files is an object (String -> Array) where fieldname is the key, and the value is array of files
        //
        // e.g.
        //  req.files["avatar"][0] -> File
        //  req.files["gallery"] -> Array
        //
        // req.body will contain the text fields, if there were any
      })
    }

  }

}
