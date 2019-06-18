stream-throttle package for Scala.js
================================
[stream-throttle](https://www.npmjs.com/package/stream-throttle) - A rate limiter for Node.js streams.

### Description

A rate limiter for Node.js streams.

<a name="build_requirements"></a>
### Build Requirements

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
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
import io.scalajs.nodejs._
import io.scalajs.npm.streamthrottle._

process.stdin.pipe(new Throttle(new ThrottleOptions(rate = 10))).pipe(process.stdout)
```

```scala
import io.scalajs.nodejs._
import io.scalajs.nodejs.net._
import io.scalajs.npm.streamthrottle._
import scalajs.js

val tg = new ThrottleGroup(new ThrottleOptions(rate = 10240))

val conn1 = Net.createConnection(host = "www.google.com", port = 80)
val conn2 = Net.createConnection(host = "www.google.com", port = 80)

val thr1 = conn1.pipe(tg.throttle())
val thr2 = conn2.pipe(tg.throttle())

// Reads from thr1 and thr2 are throttled to 10 KB/s in aggregate
```

### Artifacts and Resolvers

To add the `stream-throttle` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "stream-throttle" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
