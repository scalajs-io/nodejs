express-fileupload API for Scala.js
================================
[express-fileupload](https://www.npmjs.com/package/express-fileupload) - Simple express file upload middleware that wraps around connect-busboy.

### Description

Simple express middleware for uploading files.

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

#### Example 

```scala
import io.scalajs.nodejs.os.OS
import io.scalajs.npm.express._
import io.scalajs.npm.express.fileupload._

val app = Express()
app.use(ExpressFileUpload())

app.post("/upload", (req: Request with UploadedFiles, res: Response) => {
    if (req.files.isEmpty) res.send("No files were uploaded.")
    else {
      // The name of the input field (i.e. "sampleFile") is used to retrieve the uploaded file
      req.files foreach { case (name, file) =>
          // Use the mv() method to place the file somewhere on your server
          file.mv(s"${OS.tmpdir()}/$name", { err => 
            if (err != null) res.status(500).send(err) else res.send(s"File '$name' uploaded!")
          })
      }
    }
})
```

### Artifacts and Resolvers

To add the `express-fileupload` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "express-fileupload" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```