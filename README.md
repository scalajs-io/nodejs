# scala-js-nodejs

Scala.js type facades for Node.js v8 and later.

## Support matrix

|            |   ScalaJS 0.6.28+  |   ScalaJS 1.x  |
| ---------- | :----------------: | :------------: |
| Scala 2.13 | :heavy_check_mark: | :construction: |
| Scala 2.12 | :heavy_check_mark: | :construction: |
| Scala 2.11 |         N/A        |       N/A      |
| Scala 2.10 |         N/A        |       N/A      |

-   :heavy_check_mark: Supported
-   :construction: Not supported but planned

## Supported Modules

The following core Node.js modules (v8.7.0+) have been implemented:

| Node Module                                                  | v10 & v12 support  |
| ------------------------------------------------------------ | ------------------ |
| [assert](https://nodejs.org/api/assert.html)                 | :heavy_check_mark: |
| [buffer](https://nodejs.org/api/buffer.html)                 | :heavy_check_mark: |
| [child_process](https://nodejs.org/api/child_process.html)   | :heavy_check_mark: |
| [cluster](https://nodejs.org/api/cluster.html)               | :heavy_check_mark: |
| [console](https://nodejs.org/api/console.html)               | :heavy_check_mark: |
| [crypto](https://nodejs.org/api/crypto.html)                 | :heavy_check_mark: |
| [dgram](https://nodejs.org/api/dgram.html)                   | :heavy_check_mark: |
| [dns](https://nodejs.org/api/dns.html)                       | :heavy_check_mark: |
| [events](https://nodejs.org/api/events.html)                 | :heavy_check_mark: |
| [fs](https://nodejs.org/api/fs.html)                         | :heavy_check_mark: |
| [http](https://nodejs.org/api/http.html)                     | :heavy_check_mark: |
| [https](https://nodejs.org/api/https.html)                   | :heavy_check_mark: |
| [net](https://nodejs.org/api/net.html)                       | :heavy_check_mark: |
| [os](https://nodejs.org/api/os.html)                         | :heavy_check_mark: |
| [path](https://nodejs.org/api/path.html)                     | :heavy_check_mark: |
| [process](https://nodejs.org/api/process.html)               | :heavy_check_mark: |
| [querystring](https://nodejs.org/api/querystring.html)       | :heavy_check_mark: |
| [readline](https://nodejs.org/api/readline.html)             | :heavy_check_mark: |
| [repl](https://nodejs.org/api/repl.html)                     | :heavy_check_mark: |
| [stream](https://nodejs.org/api/stream.html)                 | :heavy_check_mark: |
| [string-decoder](https://nodejs.org/api/string_decoder.html) | :heavy_check_mark: |
| [timers](https://nodejs.org/api/timers.html)                 | :heavy_check_mark: |
| [tls](https://nodejs.org/api/tls.html)                       | :heavy_check_mark: |
| [tty](https://nodejs.org/api/tty.html)                       | :heavy_check_mark: |
| [url](https://nodejs.org/api/url.html)                       | :heavy_check_mark: |
| [util](https://nodejs.org/api/util.html)                     | :heavy_check_mark: |
| [vm](https://nodejs.org/api/vm.html)                         | :heavy_check_mark: |
| [zlib](https://nodejs.org/api/zlib.html)                     |                    |

## How to use

Add below line to your SBT project.

```sbt
libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v8" % "0.8.0"
```

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
