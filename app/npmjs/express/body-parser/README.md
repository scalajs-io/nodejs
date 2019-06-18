Body-parser API for Scala.js
================================
[body-parser](https://www.npmjs.com/package/body-parser) - Node.js body parsing middleware.

### Description

Parse incoming request bodies in a middleware before your handlers, available under the req.body property.

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

```scala
import io.scalajs.JSON
import io.scalajs.npm.bodyparser._
import io.scalajs.npm.express.{Express, Request, Response}

val app = Express()

// parse application/x-www-form-urlencoded 
app.use(BodyParser.urlencoded(new UrlEncodedBodyOptions(extended = false)))

// parse application/json 
app.use(BodyParser.json())

app.use((req: Request, res: Response) => {
    res.setHeader("Content-Type", "text/plain")
    res.write("you posted:\n")
    res.end(JSON.stringify(req.body, null, 2))
})
```

### Artifacts and Resolvers

To add the `BodyParser` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "body-parser" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```