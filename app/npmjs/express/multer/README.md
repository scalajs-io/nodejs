Multer API for Scala.js
================================
[multer](https://www.npmjs.com/package/multer) - Middleware for handling multipart/form-data.

### Description

Multer is a node.js middleware for handling multipart/form-data, which is primarily used for uploading files. 
It is written on top of busboy for maximum efficiency.

**NOTE**: Multer will not process any form which is not multipart (multipart/form-data).

### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

##### Simple file upload

```scala
import io.scalajs.npm.express._
import io.scalajs.npm.express.multer._
import scalajs.js

val app = Express()
val upload = Multer(new MulterOptions(dest = "uploads/"))
app.post("/profile", upload.array(), (req: Request, res: Response, next: js.Function) => {
  // req.body contains the text fields
})
```

##### Multi-part file upload

```scala
import io.scalajs.npm.express._
import io.scalajs.npm.express.multer._
import scalajs.js

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
```

### Artifacts and Resolvers

To add the `Multer` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "multer" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```