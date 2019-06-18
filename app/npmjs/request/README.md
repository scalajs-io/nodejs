Request API for Scala.js
=======================
[request](https://www.npmjs.com/package/request) - A Simplified HTTP request client.

### Description

Request is designed to be the simplest way possible to make http calls. 
It supports HTTPS and follows redirects by default.

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

`Request` can perform HTTP requests via callbacks:

```scala
import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import io.scalajs.npm.request._

Request("http://www.google.com", { (error, response, body) => 
    Assert.equal(error, null, JSON.stringify(error))
    Assert.equal(response.statusCode, 200, response.statusMessage)
})
```

`Request` can perform streaming HTTP requests:

```scala
import io.scalajs.nodejs.Assert
import io.scalajs.nodejs.http.IncomingMessage
import io.scalajs.npm.request._

Request
    .get("http://google.com/img.png")
    .onResponse { response  => 
        Assert.equal(response.statusCode, 200, response.statusMessage)
        Assert.equal(response.headers.get("content-type").orNull, "image/png", response.headers.get("content-type").orNull)
    }
    .pipe(Request.put("http://mysite.com/img.png"))
```

### Artifacts and Resolvers

To add the `Request` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "request" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```