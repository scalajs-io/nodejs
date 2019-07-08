Moment API for Scala.js
=======================
[moment](https://www.npmjs.com/package/moment) - Parse, validate, manipulate, and display dates

### Description

Parse, validate, manipulate, and display dates.

### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)x

### Build/publish the SDK locally

```bash
$ sbt clean publish-local
```

#### Run the tests

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.npm.moment._

val moment = Moment("9/01/2016 6:17a", "M/DD/YYYY h:mma")
println(moment.toString) //=> Thu Sep 01 2016 06:17:00 GMT-0700
```

### Artifacts and Resolvers

To add the Moment binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```