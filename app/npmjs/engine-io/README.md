engine.io API for Scala.js
================================
[engine.io](https://www.npmjs.com/package/engine.io) - Engine.IO is the implementation of transport-based 
cross-browser/cross-device bi-directional communication layer for Socket.IO.

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

##### Listening on a port

```scala
import io.scalajs.npm.engineio._
import io.scalajs.nodejs.buffer.Buffer
import scala.scalajs.js

val server = EngineIO.listen(80)
server.on("connection", { socket: Socket =>
    socket.send("utf 8 string")
    socket.send(Buffer.from(js.Array(0, 1, 2, 3, 4, 5))); // binary data
})
```

##### Intercepting requests for a http.Server

```scala
import io.scalajs.npm.engineio._
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.http.Http 

val http = Http.createServer()
http.listen(3000)

val server = EngineIO.attach(http)
server.on("connection", { socket: Socket =>
    socket.on("message", (data: Buffer) => {})
    socket.on("close", () => {})
})
```

### Artifacts and Resolvers

To add the `engine.io` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "engine-io" % "0.4.1"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
