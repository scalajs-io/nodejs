MemoryFs API for Scala.js
================================
[memory-fs](https://www.npmjs.com/package/memory-fs) - A simple in-memory filesystem. Holds data in a javascript object.

### Description

A simple in-memory filesystem. Holds data in a javascript object.

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

Using `MemoryFs` asynchronously via callbacks

```scala
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.fs.{FileIOError, Stats}
import io.scalajs.npm.memoryfs._
import scalajs.js

var output1: Buffer = null
var output2: js.Array[String] = null
var output3: Boolean = false
      
val fs = new MemoryFs() 
fs.mkdirp("/a/test/dir", (err1: FileIOError) => {
    fs.writeFile("/a/test/dir/file.txt", "Hello World", (err2: FileIOError) => {
      fs.readFile("/a/test/dir/file.txt", (err3: FileIOError, data: Buffer) => {
        output1 = data // ~> Buffer("Hello World")

        fs.unlink("/a/test/dir/file.txt", (err4: FileIOError) => {
          fs.readdir("/a/test", (err5: FileIOError, dir: js.Array[String]) => {
            output2 = dir // ~> ["dir"]

            fs.stat("/a/test/dir", (err6: FileIOError, stats: Stats) => {
              output3 = stats.isDirectory() // ~> true

              fs.rmdir("/a/test/dir", (err7: FileIOError) => {
                fs.mkdirp("C:\\use\\windows\\style\\paths", (err8: FileIOError) => {
                  show("output1 =", output1.toString(), output1)
                  show("output2 =", output2)
                  show("output3 =", output3)
                })
              })
            })
          })
        })
      })
    })
})

def show(label: String, value: js.Any*): Unit = {
  println(s"$label ${value.mkString(" ")}")
}
```

Using `MemoryFs` asynchronously via promises

```scala
import io.scalajs.npm.memoryfs._
import io.scalajs.util.ScalaJsHelper._
import scalajs.js

val fs = new MemoryFs() 

for {
    _ <- fs.mkdirpFuture("/a/test/dir")
    _ <- fs.writeFileFuture("/a/test/dir/file.txt", "Hello World")
    output1 <- fs.readFileFuture("/a/test/dir/file.txt") // ~> Buffer("Hello World")
    _ <- fs.unlinkFuture("/a/test/dir/file.txt")
    output2 <- fs.readdirFuture("/a/test") // ~> ["dir"]
    output3 <- fs.statFuture("/a/test/dir").map(_.isDirectory()) // ~> true
    _ <- fs.rmdirFuture("/a/test/dir")
    _ <- fs.mkdirpFuture("C:\\use\\windows\\style\\paths")
} {
    show("output1 =", output1.toString(), output1)
    show("output2 =", output2)
    show("output3 =", output3)
}

def show(label: String, value: js.Any*): Unit = {
  println(s"$label ${value.mkString(" ")}")
}
```

Using `MemoryFs` synchronously

```scala
import io.scalajs.npm.memoryfs._
import scalajs.js

val fs = new MemoryFs() 
fs.mkdirpSync("/a/test/dir")
fs.writeFileSync("/a/test/dir/file.txt", "Hello World")
val output1 = fs.readFileSync("/a/test/dir/file.txt") // ~> Buffer("Hello World")
fs.unlinkSync("/a/test/dir/file.txt")
val output2 = fs.readdirSync("/a/test")
// ~> ["dir"]
val output3 = fs.statSync("/a/test/dir").isDirectory() // ~> true
fs.rmdirSync("/a/test/dir")
fs.mkdirpSync("C:\\use\\windows\\style\\paths")

show("output1 =", output1.toString(), output1)
show("output2 =", output2)
show("output3 =", output3)

def show(label: String, value: js.Any*): Unit = {
  println(s"$label ${value.mkString(" ")}")
}
```

### Artifacts and Resolvers

To add the `MemoryFs` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "memory-fs" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```