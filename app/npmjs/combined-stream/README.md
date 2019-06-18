combined-stream API for Scala.js
================================
[combined-stream](https://www.npmjs.com/package/combined-stream) - A stream that emits multiple other streams one after another.

### Description

A stream that emits multiple other streams one after another.

NB Currently combined-stream works with streams vesrion 1 only. There is ongoing effort to switch this library to 
streams version 2. Any help is welcome. :) Meanwhile you can explore other libraries that provide streams2 support 
with more or less compatability with combined-stream.

[combined-stream2](https://github.com/scalajs-io/combined-stream2): A drop-in streams2-compatible replacement for the combined-stream module.

[multistream](https://github.com/scalajs-io/multistream): A stream that emits multiple other streams one after another.

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

Here is a simple example that shows how you can use combined-stream to combine two files into one:

```scala
import io.scalajs.nodejs.fs._
import io.scalajs.npm.combinedstream._

val combinedStream = CombinedStream.create()
combinedStream.append(Fs.createReadStream("file1.txt"))
combinedStream.append(Fs.createReadStream("file2.txt"))
combinedStream.pipe(Fs.createWriteStream("combined.txt"))
```

While the example above works great, it will pause all source streams until they are needed. 
If you don't want that to happen, you can set pauseStreams to false:

```scala
import io.scalajs.nodejs.fs._
import io.scalajs.npm.combinedstream._

val combinedStream = CombinedStream.create(CombineStreamOptions(pauseStreams = false))
combinedStream.append(Fs.createReadStream("file1.txt"))
combinedStream.append(Fs.createReadStream("file2.txt"))
combinedStream.pipe(Fs.createWriteStream("combined.txt"))
```

However, what if you don't have all the source streams yet, or you don't want to allocate the resources 
(file descriptors, memory, etc.) for them right away? Well, in that case you can simply provide a callback that 
supplies the stream by calling a next() function:

```scala
import io.scalajs.nodejs.fs._
import io.scalajs.npm.combinedstream._

val combinedStream = CombinedStream.create()
combinedStream.append(next => next(Fs.createReadStream("file1.txt")))
combinedStream.append(next => next(Fs.createReadStream("file2.txt")))
combinedStream.pipe(Fs.createWriteStream("combined.txt"))
```

### Artifacts and Resolvers

To add the `combined-stream` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "combined-stream" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
