MomentTimezone API for Scala.js
=======================
[moment-timezone](https://www.npmjs.com/package/moment-timezone) - Parse and display moments in any timezone.

### Description

Parse and display [moment](https://github.com/scalajs-io/moment)s in any timezone.

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
import io.scalajs.npm.moment.timezone._

MomentTimezone // load the moment-timezone module

val moment = Moment("2014-06-01T12:00:00Z")
val output = moment.tz("America/Los_Angeles").format("ha z")
println(output) // 5am PDT
```

### Artifacts and Resolvers

To add the `MomentTimezone` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment-timezone" % "0.6.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
