gzip-uncompressed-size API for Scala.js
================================
[gzip-uncompressed-size](https://www.npmjs.com/package/gzip-uncompressed-size) - Determine the estimated uncompressed size from a GZIP file (uses ISIZE).

### Description

This module returns the GZIP ISIZE, which according to the specification, contains the size of the original 
(uncompressed) input. It has been documented that the size reported is not 100% accurate.

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

##### Usage via callback

```scala
import io.scalajs.npm.gzipuncompressedsize._

GzipUncompressedSize.fromFile("my/compressed/file.gz", (error, uncompressedSize) => {
    error match {
        case null => println(s"uncompressedSize = $uncompressedSize")
        case err => println(s"An error occurred: ${err.message}")
    }
})
```

##### Usage with promise

```scala
import io.scalajs.npm.gzipuncompressedsize._
import scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

GzipUncompressedSize.fromFileAsync("my/compressed/file.gz").future onComplete {
    case Success(uncompressedSize) =>
      println(s"uncompressedSize = $uncompressedSize")
    case Failure(e) =>
      println(s"An error occurred: ${e.getMessage}")
}
```

### Artifacts and Resolvers

To add the `gzip-uncompressed-size` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "gzip-uncompressed-size" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 