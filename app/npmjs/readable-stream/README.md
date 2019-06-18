ReadableStream API for Scala.js
================================
[readable-stream](https://www.npmjs.com/package/readable-stream) - A Streams3, a user-land copy of the stream library from Node.js

### Description

This package is a mirror of the Streams2 and Streams3 implementations in Node-core.

Full documentation may be found on the [Node.js website](https://nodejs.org/dist/v7.4.0/docs/api/).

If you want to guarantee a stable streams base, regardless of what version of Node you, or the users of your 
libraries are using, use readable-stream only and avoid the "stream" module in Node-core, for background see 
[this blogpost](https://r.va.gg/2014/06/why-i-dont-use-nodes-core-stream-module.html).

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
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.process
import io.scalajs.npm.readablestream.Readable

val bulk = new Readable()
bulk._read = () => {}

('A' to 'F') foreach { ch =>
  bulk.push(Buffer.from(String.valueOf(ch)))
}
bulk.push(null)
bulk.pipe(process.stdout)
```

##### Output:

```text
ABCDEF
```

### Artifacts and Resolvers

To add the `ReadableStream` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "readable-stream" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 