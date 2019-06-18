Oppressor API for Scala.js
================================
[oppressor](https://www.npmjs.com/package/oppressor) - streaming http compression response negotiator.
 
### Description
 
streaming http compression response negotiator 

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
import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.http._
import io.scalajs.npm.oppressor._

val server = Http.createServer((req: ClientRequest, res: ServerResponse) => {
Fs.createReadStream("./src/test/resources/data.txt")
  .pipe(Oppressor(req))
  .pipe(res)
})
server.listen(8000)
```

### Artifacts and Resolvers

To add the `Oppressor` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "oppressor" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
