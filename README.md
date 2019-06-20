This is a complete Scala.js facade for Node.js for Scala 2.12 and 2.13.

## Features

The Node.js integration is nearly complete (feature for feature), and should be more than sufficient for most web-based 
and CLI applications.

## How to use

Add below line to your SBT project.

```sbt
libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v8" % "0.8.0"
```

## Support matrix

|            |   ScalaJS 0.6.28+  |   ScalaJS 1.x  |
| ---------- | :----------------: | :------------: |
| Scala 2.13 | :heavy_check_mark: | :construction: |
| Scala 2.12 | :heavy_check_mark: | :construction: |
| Scala 2.11 |         N/A        |       N/A      |
| Scala 2.10 |         N/A        |       N/A      |

-   :heavy_check_mark: Supported
-   :construction: Not supported but planned

### Supported Modules

The following core Node.js modules (v8.7.0) have been implemented:

| Node Module    | Description                                                                                                                                                                         |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| assert         | Provides a simple set of assertion tests that can be used to test invariants.                                                                                                       |
| buffer         | The Buffer class was introduced as part of the Node.js API to make it possible to interact with octet streams in the context of things like TCP streams and file system operations. |
| child_process  | The child_process module provides the ability to spawn child processes.                                                                                                             |
| cluster        | The cluster module allows you to easily create child processes that all share server ports.                                                                                         |
| crypto         | The crypto module provides cryptographic functionality that includes a set of wrappers for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.                       |
| dns            | Support for DNS queries.                                                                                                                                                            |
| events         | Node.js Events Interface                                                                                                                                                            |
| fs             | File I/O is provided by simple wrappers around standard POSIX functions.                                                                                                            |
| http           | Node.js HTTP Interface                                                                                                                                                              |
| https          | Node.js HTTPS Interface                                                                                                                                                             |
| net            | The net module provides you with an asynchronous network wrapper.                                                                                                                   |
| os             | Provides a few basic operating-system related utility functions.                                                                                                                    |
| path           | This module contains utilities for handling and transforming file paths.                                                                                                            |
| querystring    | The querystring module provides utilities for parsing and formatting URL query strings.                                                                                             |
| readline       | Readline allows reading of a stream on a line-by-line basis.                                                                                                                        |
| repl           | The REPL provides a way to interactively run JavaScript and see the results.                                                                                                        |
| stream         | A stream is an abstract interface implemented by various objects in Node.js.                                                                                                        |
| string-decoder | The string_decoder module provides an API for decoding Buffer objects into strings in a manner that preserves encoded multi-byte UTF-8 and UTF-16 characters.                       |
| timers         | The timer module exposes a global API for scheduling functions to be called at some future period of time.                                                                          |
| tty            | The tty module provides the tty.ReadStream and tty.WriteStream classes.                                                                                                             |
| url            | The url module provides utilities for URL resolution and parsing.                                                                                                                   |
| util           | The util module is primarily designed to support the needs of Node.js's internal APIs.                                                                                              |
| vm             | The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.                                                                                      |
| zlib           | This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes.                                                                                          |

## Example of code

### Callback-style JavaScript (prior to async/await)

```javascript
var output1 = null;
var output2 = null;
var output3 = null;

fs.mkdirp("/a/test/dir", function (err1) {
    Assert.ifError(err1);

    fs.writeFile("/a/test/dir/file.txt", "Hello World", function (err2) {
        Assert.ifError(err2);

        fs.readFile("/a/test/dir/file.txt", function (err3, data) {
            Assert.ifError(err3);
            output1 = data; // ~> Buffer("Hello World")

            fs.unlink("/a/test/dir/file.txt", function (err4) {
                Assert.ifError(err4);

                fs.readdir("/a/test", function (err5, dir) {
                    Assert.ifError(err5);
                    output2 = dir; // ~> ["dir"]

                    fs.stat("/a/test/dir", function (err6, stats) {
                        Assert.ifError(err6);
                        output3 = stats.isDirectory(); // ~> true

                        fs.rmdir("/a/test/dir", function (err7) {
                            Assert.ifError(err7);
                            fs.mkdirp("C:\\use\\windows\\style\\paths", function (err8) {
                                Assert.ifError(err8);
                                
                                console.log("output1 =", output1.toString(), output1);
                                console.log("output2 =", output2);
                                console.log("output3 =", output3)
                            })
                        })
                    })
                })
            })
        })
    })
});
```

Now consider the equivalent logic in Scala.js using its much more elegant `for` comprehension:

### Scala.js

```scala
import io.scalajs.nodejs.console
import io.scalajs.nodejs.Fs._
  
for {
  _ <- Fs.mkdirpFuture("/a/test/dir")
  _ <- Fs.writeFileFuture("/a/test/dir/file.txt", "Hello World")
  output1 <- Fs.readFileFuture("/a/test/dir/file.txt") // ~> Buffer("Hello World")
  _ <- Fs.unlinkFuture("/a/test/dir/file.txt")
  output2 <- Fs.readdirFuture("/a/test") // ~> ["dir"]
  output3 <- Fs.statFuture("/a/test/dir").map(_.isDirectory()) // ~> true
  _ <- Fs.rmdirFuture("/a/test/dir")
  _ <- Fs.mkdirpFuture("C:\\use\\windows\\style\\paths")
} {
  console.log("output1 =", output1.toString(), output1)
  console.log("output2 =", output2)
  console.log("output3 =", output3)
}
```
