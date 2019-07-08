moment-duration-format API for Scala.js
================================
[moment-duration-format](https://www.npmjs.com/package/moment-duration-format) - Format plugin for the Moment Duration object.
                                                                                 
### Description

**Format plugin for the Moment Duration object.**

This is a plugin to the Moment.js JavaScript date library to add comprehensive formatting to Moment Durations.

Format template grammar is patterned on the existing Moment Date format template grammar, with a few modifications 
because durations are fundamentally different from dates.

This plugin does not have any dependencies beyond Moment.js itself, and may be used in the browser and in Node.js.

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
import io.scalajs.npm.moment._
import io.scalajs.npm.moment.durationformat._

Moment.duration(123, "minutes").format() // "2:03"
 
Moment.duration(123, "months").format() // "10y 3m"

Moment.duration(123, "minutes").format("h:mm") // "2:03"
```

### Artifacts and Resolvers

To add the `moment-duration-format` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment-duration-format" % "0.6.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```