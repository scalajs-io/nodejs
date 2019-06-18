BufferMaker API for Scala.js
================================
[buffermaker](https://www.npmjs.com/package/buffermaker) - A buffermaker is a convenient way of creating binary strings.

### Description

A convenient way of creating binary strings in node.js because Buffer is a bit too low-level for comfort in this regard.

### Build Requirements

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
import io.scalajs.npm.buffermaker._
import io.scalajs.npm.bignum.BigNum

val someBuffer = new BufferMaker()
    .UInt8(1)
    .UInt16BE(2)
    .UInt32BE(3)
    .Int64BE(new BigNum("4")) // uses the BigNum library
    .string("this is a test!")
    .make()

println(someBuffer.toString()) //=> <Buffer 01 00 02 00 00 00 03 00 00 00 00 00 00 00 04 74 68 69 73 20 69 73 20 61 20 74 65 73 74 21>
```

### Artifacts and Resolvers

To add the `BufferMaker` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "buffermaker" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```