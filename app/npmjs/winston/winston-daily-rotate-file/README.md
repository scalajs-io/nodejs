WinstonDailyRotateFile API for Scala.js
================================
[winston-daily-rotate-file](https://www.npmjs.com/package/winston-daily-rotate-file) - A transport for winston which logs to a rotating file each day..

### Description

A transport for [winston](https://github.com/scalajs-io/winston) which logs to a rotating file each day.

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
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

WinstonDailyRotateFile // let's ensure the daily rotate file package is loaded

val transport = new winston.transports.DailyRotateFile(new DailyRotateFileOptions(
    filename = "./src/test/resources/rotating.log",
    datePattern = "yyyy-MM-dd.",
    prepend = true,
    level = if (process.env.get("ENV").contains("development")) "debug" else "info"
))

val logger = new winston.Logger(new ConfigurationOptions(
    transports = js.Array(transport)
))

logger.info("Hello World!")
```

### Artifacts and Resolvers

To add the `WinstonDailyRotateFile` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "winston-daily-rotate-file" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
