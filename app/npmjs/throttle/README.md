Throttle API for Scala.js
================================
[throttle](https://www.npmjs.com/package/throttle) - Node.js Transform stream that passes data through at n bytes per second.

### Description

This module offers a Throttle passthrough stream class, which allows you to write data to it and it will be passed 
through in n bytes per second. It can be useful for throttling HTTP uploads or to simulate reading from a file in 
real-time, etc.

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
import io.scalajs.nodejs.process
import io.scalajs.npm.throttle._

process.stdin.pipe(new Throttle(100 * 1024)).pipe(process.stdout)
```

### Artifacts and Resolvers

To add the `Throttle` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "throttle" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```