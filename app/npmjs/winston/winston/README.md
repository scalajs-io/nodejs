Winston API for Scala.js
================================
[winston](https://www.npmjs.com/package/winston) - A multi-transport async logging library for Node.js.

### Description

A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."

Winston is designed to be a simple and universal logging library with support for multiple transports. 
A transport is essentially a storage device for your logs. Each instance of a winston logger can have 
multiple transports configured at different levels. For example, one may want error logs to be stored 
in a persistent remote location (like a database), but all logs output to the console or a local file.

There also seemed to be a lot of logging libraries out there that coupled their implementation of 
logging (i.e. how the logs are stored / indexed) to the API that they exposed to the programmer. 
This library aims to decouple those parts of the process to make it more flexible and extensible.

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

##### Using the Default Logger

The default logger is accessible through the winston module directly. 
Any method that you could call on an instance of a logger is available on the default logger:

```scala
import io.scalajs.npm.winston._

Winston.log("info", "Hello distributed log files!")
Winston.info("Hello again distributed logs")

Winston.level = "debug"
Winston.log("debug", "Now my debug messages are written to console!")
```

By default, only the `Console` transport is set on the default logger. 
You can add or remove transports via the `add()` and `remove()` methods:

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._

Winston.add(winston.transports.File, new FileTransportOptions(filename = "somefile.log"))
Winston.remove(winston.transports.Console)
```

Or do it with one call to configure():

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

Winston.configure(new ConfigurationOptions(
  transports = js.Array(new winston.transports.File(new FileTransportOptions(filename = "somefile.log")))
))
```

##### Instantiating your own Logger

If you would prefer to manage the object lifetime of loggers you are free to instantiate them yourself:

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

val logger = new winston.Logger(new ConfigurationOptions(
    transports = js.Array(
      new winston.transports.Console(),
      new winston.transports.File(new FileTransportOptions(filename = "somefile.log"))
)))
```

##### Multiple transports of the same type

It is possible to use multiple transports of the same type e.g. winston.transports.File by passing in 
a custom name when you construct the transport.

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

val logger = new winston.Logger(new ConfigurationOptions(
  transports = js.Array(
      new winston.transports.File(new FileTransportOptions(
        name = "info-file",
        filename = "filelog-info.log",
        level = "info"
      )),
      new winston.transports.File(new FileTransportOptions(
        name = "error-file",
        filename = "filelog-error.log",
        level = "error"
      ))
  )
))

// If you later want to remove one of these transports you can do so by using the string name. e.g.:

logger.remove("info-file")

// In this example one could also remove by passing in the instance of the Transport itself. 
// e.g. this is equivalent to the string example above

// Notice it was first in the Array above 
val infoFile = logger.transports(0)
logger.remove(infoFile)
```

##### Profiling

In addition to logging messages and metadata, winston also has a simple profiling mechanism implemented for any logger:

```scala
import io.scalajs.nodejs.setTimeout
import io.scalajs.npm.winston._

// 
// Start profile of 'test' 
// Remark: Consider using Date.now() with async operations 
// 
Winston.profile("test")

setTimeout(() => {
    // 
    // Stop profile of 'test'. Logging will now take place: 
    //   "17 Jan 21:00:00 - info: test duration=1000ms" 
    // 
    Winston.profile("test")
}, 1000)
```

##### String interpolation

The log method provides the same string interpolation methods like util.format.

This allows for the following log messages.

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js


val logger = new winston.Logger(new ConfigurationOptions(
  transports = js.Array(new winston.transports.Console())
))

logger.log("info", "test message %s", "my string")
// info: test message my string

logger.log("info", "test message %d", 123)
// info: test message 123

logger.log("info", "test message %j", new MetaData(number = 123), new MetaData())
// info: test message {"number":123}
// meta = {}

logger.log("info", "test message %s, %s", "first", "second", new MetaData(number = 123))
// info: test message first, second
// meta = {number: 123}

logger.log("info", "test message", "first", "second", new MetaData(number = 123))
// info: test message first second
// meta = {number: 123}

logger.log("info", "test message %s, %s", "first", "second", new MetaData(number = 123), (() => {}): js.Function)
// info: test message first, second
// meta = {number: 123}
// callback = function(){}

logger.log("info", "test message", "first", "second", new MetaData(number = 123), (() => {}): js.Function)
// info: test message first second
// meta = {number: 123}
// callback = function(){}


class MetaData(val number: Integer = null) extends js.Object
```

##### Querying Logs

Winston supports querying of logs with Loggly-like options. See [Loggly Search API](https://www.loggly.com/docs/api-retrieving-data/). 
Specifically: File, Couchdb, Redis, Loggly, Nssocket, and Http.

```scala
import io.scalajs.nodejs.console
import io.scalajs.npm.winston._
import scalajs.js

val options = new QueryOptions(
    from = js.Date.now - 24 * 60 * 60 * 1000,
    until = new js.Date,
    limit = 10,
    start = 0,
    order = "desc",
    fields = js.Array("message")
)

//
// Find items logged between today and yesterday.
//
Winston.query(options, (err, results) => {
    if (err != null) {
      throw new IllegalStateException(err.code)
    }
    
    console.log("query results:", results)
})
```

##### Streaming Logs
      
Streaming allows you to stream your logs back from your chosen transport.

```scala
import io.scalajs.nodejs.console
import io.scalajs.npm.winston._

Winston.stream(new StreamingOptions(start = -1)).onLog { log => 
    console.log("log:", log)
}
```

##### To Exit or Not to Exit

By default, winston will exit after logging an uncaughtException. 
if this is not the behavior you want, set exitOnError = false

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._

val logger = new winston.Logger(new ConfigurationOptions(exitOnError = false))
 
// 
// or, like this: 
// 
logger.exitOnError = false
```

##### Using Logging Levels

Setting the level for your logging message can be accomplished in one of two ways. 
You can pass a string representing the logging level to the log() method or use the level specified methods 
defined on every winston Logger.

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._

val logger = new winston.Logger(new ConfigurationOptions(exitOnError = false))

// 
// Any logger instance 
// 
logger.log("silly", "127.0.0.1 - there's no place like home")
logger.log("debug", "127.0.0.1 - there's no place like home")
logger.log("verbose", "127.0.0.1 - there's no place like home")
logger.log("info", "127.0.0.1 - there's no place like home")
logger.log("warn", "127.0.0.1 - there's no place like home")
logger.log("error", "127.0.0.1 - there's no place like home")
logger.info("127.0.0.1 - there's no place like home")
logger.warn("127.0.0.1 - there's no place like home")
logger.error("127.0.0.1 - there's no place like home")

// 
// Default logger 
// 
Winston.log("info", "127.0.0.1 - there's no place like home")
Winston.info("127.0.0.1 - there's no place like home")
```

winston allows you to define a level property on each transport which specifies the maximum level of messages 
that a transport should log. For example, using the npm levels you could log only error messages to the console 
and everything info and below to a file (which includes error messages):

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

val logger = new winston.Logger(new ConfigurationOptions(
    transports = js.Array(
        new winston.transports.Console(new ConsoleTransportOptions(level = "error")),
        new winston.transports.File(new FileTransportOptions(
            filename = "somefile.log",
            level = "info"
        ))
    )
))
```

You may also dynamically change the log level of a transport:

```scala
import io.scalajs.npm.winston
import io.scalajs.npm.winston._
import io.scalajs.npm.winston.transports._
import scalajs.js

val logger = new winston.Logger(new ConfigurationOptions(
    transports = js.Array(
        new winston.transports.Console(new ConsoleTransportOptions(level = "warn")),
        new winston.transports.File(new FileTransportOptions(
            filename = "somefile.log",
            level = "info"
        ))
    )
))
  
logger.debug("Will not be logged in either transport!")
logger.transports.console.level = "debug"
logger.transports.file.level = "verbose"
logger.verbose("Will be logged in both transports!")
```

### Artifacts and Resolvers

To add the `Winston` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "winston" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```