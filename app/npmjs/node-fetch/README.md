node-fetch type-safe binding for Scala.js
==========================================
[node-fetch](https://www.npmjs.com/package/node-fetch) - A light-weight module that brings window.fetch to Node.js.

#### Description

Instead of implementing XMLHttpRequest in Node.js to run browser-specific Fetch polyfill, 
why not go from native http to Fetch API directly? Hence node-fetch, minimal code for a window.fetch 
compatible API on Node.js runtime.

#### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

#### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

#### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

#### Examples

##### Asynchronously retrieve an image

```scala
import io.scalajs.JSON
import io.scalajs.nodejs.console
import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.nodefetch._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

NodeFetch("https://assets-cdn.github.com/images/modules/logos_page/Octocat.png").toFuture onComplete {
    case Success(resp) =>
      val dest = Fs.createWriteStream("./octocat.png")
      resp.body.pipe(dest)
    case Failure(e) =>
      console.error(e.getMessage)
}
```

##### Make asynchronously calls via promises:

```scala
import io.scalajs.JSON
import io.scalajs.nodejs.console
import io.scalajs.npm.nodefetch._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

NodeFetch("https://github.com/").toFuture onComplete {
    case Success(res) =>
      println(s"ok => ${res.ok}")
      println(s"status => ${res.status}")
      println(s"statusText => ${res.statusText}")
      println(s"headers.raw() => ${JSON.stringify(res.headers.raw())}")
      println(s"headers.get('content-type') => ${res.headers.get("content-type").orNull}")
    case Failure(e) =>
      console.error(e.getMessage)
}
```

##### The output

```
ok => true
status => 200
statusText => OK
headers.raw() => {"server":["GitHub.com"],"date":["Tue, 18 Apr 2017 00:22:11 GMT"],"content-type":["text/html; charset=utf-8"],
"transfer-encoding":["chunked"],"connection":["close"],"status":["200 OK"],"cache-control":["no-cache"],
"vary":["X-PJAX, Accept-Encoding"],"x-ua-compatible":["IE=Edge,chrome=1"],
"set-cookie":["logged_in=no; domain=.github.com; path=/; expires=Sat, 18 Apr 2037 00:22:11 -0000; secure; HttpOnly",
"_gh_sess=eyJzZXNzaW9uX2lkIjoiNjhkYjMyYjRmYWU2ZDg1Yjc4OGM2OTkyNjllNzIwYjkiLCJfY3NyZl90b2tlbiI6Im5QSUJJMkdCcjdyYStqMlkrSTJGcHozZUVRd0RCMThySzNjdEhXQXNNNE09In0%3D--af107b896d3c356f4c9562a8165d4a0ba48fc759; path=/; secure; HttpOnly"],
"x-request-id":["a3fdd8ec9f4ed16cef269de7386a6a88"],"x-runtime":["0.032675"],
"content-security-policy":["default-src 'none'; base-uri 'self'; block-all-mixed-content; child-src render.githubusercontent.com; connect-src 'self' uploads.github.com status.github.com collector.githubapp.com api.github.com www.google-analytics.com github-cloud.s3.amazonaws.com wss://live.github.com; font-src assets-cdn.github.com; form-action 'self' github.com gist.github.com; frame-ancestors 'none'; img-src 'self' data: assets-cdn.github.com identicons.github.com collector.githubapp.com github-cloud.s3.amazonaws.com *.githubusercontent.com; media-src 'none'; script-src assets-cdn.github.com; style-src 'unsafe-inline' assets-cdn.github.com"],"strict-transport-security":["max-age=31536000; includeSubdomains; preload"],"public-key-pins":["max-age=5184000; pin-sha256=\"WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=\"; pin-sha256=\"RRM1dGqnDFsCJXBTHky16vi1obOlCgFFn/yOhI/y+ho=\"; pin-sha256=\"k2v657xBsOVe1PQRwOsHsw3bsGT2VzIqz5K+59sNQws=\"; pin-sha256=\"K87oWBWM9UZfyddvDfoxL+8lpNyoUB2ptGtn0fv6G2Q=\"; pin-sha256=\"IQBnNBEiFuhj+8x6X8XLgh01V9Ic5/V3IRQLNFFc7v4=\"; pin-sha256=\"iie1VXtL7HzAMF+/PVPR9xzT80kQxdZeJ+zduCB3uj0=\"; pin-sha256=\"LvRiGEjRqfzurezaWuj8Wie2gyHMrW5Q06LspMnox7A=\"; includeSubDomains"],"x-content-type-options":["nosniff"],"x-frame-options":["deny"],"x-xss-protection":["1; mode=block"],"x-served-by":["a0387c52951b3c2853740ef9cede1dec"],"content-encoding":["gzip"],"x-github-request-id":["F4C2:6ACB:37627B4:53F7DE5:58F55C32"]}
headers.get('content-type') => null
```

#### Artifacts and Resolvers

To add the `node-fetch` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "node-fetch" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```