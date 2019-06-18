Cookie-parser API for Scala.js
================================
[cookie-parser](https://www.npmjs.com/package/cookie-parser) - cookie parsing with signatures.

### Description

Parse Cookie header and populate req.cookies with an object keyed by the cookie names. 
Optionally you may enable signed cookie support by passing a secret string, which assigns 
req.secret so it may be used by other middleware.

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
import io.scalajs.npm.cookieparser._
import io.scalajs.npm.express.{Express, Request, Response}

val app = Express()
app.use(CookieParser("test123"))

val results = CookieParser.JSONCookie("foo=bar; equation=E%3Dmc%5E2")
println(s"cookies => ${JSON.stringify(results.orNull)}")
```

### Artifacts and Resolvers

To add the `CookieParser` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "cookie-parser" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```