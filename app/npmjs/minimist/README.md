Minimist API for Scala.js
================================
[minimist](https://www.npmjs.com/package/minimist) - parse argument options.

### Description

This module is the guts of optimist's argument parser without all the fanciful decoration.

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
import io.scalajs.npm.minimist._
import io.scalajs.util.JSONHelper._
import scalajs.js

val result1 = Minimist("-a beep -b boop".split(' '))
println(s"result: ${result1.toJson}") 
//=> result: {"_":[],a:"beep",b:"boop"}

val result2 = Minimist("-x 3 -y 4 -n5 -abc --beep=boop foo bar baz".split(' '))
println(s"result: ${result2.toJson}") 
//=> result: {"_":["foo","bar","baz"],"x":3,"y":4,"n":5,"a":true,"b":true,"c":true,"beep":"boop"}

val result3 = Minimist("one two three -- four five --six".split(' '), new MinimistOptions().withDelimiter())
println(s"result: ${result3.toJson}") 
//=> result: {"_":["one","two","three"],"--":["four","five","--six"]}
```

### Artifacts and Resolvers

To add the `Minimist` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "minimist" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```