ExpressWS API for Scala.js
================================
[express-ws](https://www.npmjs.com/package/express-ws) - WebSocket endpoints for [Express](https://github.com/scalajs-io/express) applications.

### Description

WebSocket endpoints for [Express](https://github.com/scalajs-io/express) applications. 
Lets you define WebSocket endpoints like any other type of route, 
and applies regular Express midddleware like for anything else.

Version 2.0 of this library contains a breaking change. 
Please make sure to read [CHANGELOG.md](https://github.com/HenningM/express-ws/blob/master/CHANGELOG.md) before upgrading.

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
import io.scalajs.npm.express._
import io.scalajs.npm.expressws._
import io.scalajs.util.JSONHelper._
import io.scalajs.util.ScalaJsHelper._
import scala.scalajs.js

val app = Express().withWsRouting
val expressWs = ExpressWS(app)

app.use((req: Request, res: Response, next: js.Function0[Unit]) => {
    println("middleware")
    req.dynamic.testing = "testing"
    next()
})

app.get("/", (ws: WS, req: Request, res: Response, next: js.Function0[Unit]) => {
    println(s"get route ${req.dynamic.testing}")
    res.end()
})

app.ws("/", (ws: WS, req: Request) => {
    ws.onMessage { msg =>
      println(msg.toJson)
    }
    println(s"socket: ${req.dynamic.testing}")
})

app.listen(3000)
 ```

### Artifacts and Resolvers

To add the `ExpressWS` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "express-ws" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```