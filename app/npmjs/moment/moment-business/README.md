MomentRange API for Scala.js
=======================
[moment-business](https://www.npmjs.com/package/moment-business) - Utilities for working with week days and weekend 
days in Moment. It assumes a Western workweek, in which weekends are Saturday and Sunday.

### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)x

### Build/publish the SDK locally

```bash
$ sbt "project moment-business" clean publish-local
```

#### Run the tests

```bash
$ sbt "project moment-business" test
```

### Artifacts and Resolvers

To add the `MomentBusiness` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment-business" % "0.6.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
