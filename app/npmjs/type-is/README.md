TypeIs API for Scala.js
================================
[type-is](https://www.npmjs.com/package/type-is) - Infer the content-type of a request.

### Description

Infer the content-type of a request.

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
import io.scalajs.nodejs.http.Http
import io.scalajs.npm.typeis.TypeIs
import scalajs.js

Http.createServer( (req, res) => {
    // req.headers.content-type = 'application/json' 
    import TypeIs._
    is(req, js.Array("json"))               // 'json'
    is(req, js.Array("html", "json"))       // 'json'
    is(req, js.Array("application/*"))      // 'application/json'
    is(req, js.Array("application/json"))   // 'application/json'
})
```

### Artifacts and Resolvers

To add the `TypeIs` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "type-is" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```