Express API for Scala.js
================================
[express](http://expressjs.com/en/4x/api.html) - Fast, unopinionated, minimalist web framework

### Description

Express is a minimal and flexible Node.js web application framework that provides a robust set of features 
for web and mobile applications.

#### Related Packages

The following npm packages are related to Express:

| Package                                                               | Version | Description                                                |
|-----------------------------------------------------------------------|---------|------------------------------------------------------------|
| [body-parser](https://github.com/scalajs-io/body-parser)              | 1.16.0  | Body parsing middleware.                                   |
| [cookie-parser](https://github.com/scalajs-io/cookie-parser)          | 1.4.3   | Cookie parsing with signatures                             |
| [express-csv](https://github.com/scalajs-io/express-csv)              | 0.6.0   | express-csv provides response csv easily to express.       |
| [express-fileupload](https://github.com/scalajs-io/express-fileupload)| 0.0.7   | Simple express file upload middleware that wraps around connect-busboy |
| [express-ws](https://github.com/scalajs-io/express-ws)                | 2.0.0   | WebSocket endpoints for Express applications               |
| [multer](https://github.com/scalajs-io/multer)                        | 1.3.0   | Multer is a node.js middleware for handling multipart/form-data. |

### Build Requirements

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

```scala
import io.scalajs.nodejs.http.{Http, RequestOptions, ServerResponse}
import io.scalajs.nodejs._
import io.scalajs.npm.express._
import scala.concurrent.duration._

// create the Express application instance
val app = Express()

// define a port
val port = 8080

// setup the server with routes
val server = app
  .get("/", (_: Request, res: Response) => res.send("Hello GET"))
  .post("/", (_: Request, res: Response) => res.send("Hello POST"))
  .delete("/:id", (req: Request, res: Response) => res.send(s"Hello DELETE - ${req.params.get("id").orNull}"))
  .get("/list_user", (_: Request, res: Response) => res.send("Page Listing"))
  .get("/ab*de", (_: Request, res: Response) => res.send("Page Pattern Match"))
  .listen(port)

Http.get(s"http://localhost:$port/", { response: ServerResponse =>
    response.onData { chunk =>
      println(chunk.toString()) // Hello GET
    }
})
```

### Artifacts and Resolvers

To add the `Express` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs" %%% "express" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
