Node-Zookeeper-Client API for Scala.js
================================
[node-zookeeper-client](https://www.npmjs.com/package/node-zookeeper-client) - A pure Javascript ZooKeeper client for Node.js.

### Description

This module is designed to resemble the ZooKeeper Java client API but with tweaks to follow the convention 
of Node.js modules. Developers that are familiar with the ZooKeeper Java client would be able to pick it up quickly.

This module has been tested to work with ZooKeeper version 3.4.

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

`NodeZookeeperClient` can retrieve data from Zookeeper:

```scala
import io.scalajs.JSON
import io.scalajs.nodejs._
import io.scalajs.npm.nzc._
import io.scalajs.util.ScalaJsHelper._
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

val zkHost = "localhost:2181"
val client = NodeZookeeperClient.createClient(zkHost)
client.onceConnected(() => {
    println(s"Connected to $zkHost...")
    client.getChildren("/", (error: String, paths: js.Array[String]) => {
      if (isDefined(error))
        println(s"Failed to execute the getChildren: ${JSON.stringify(error)}, results: ${JSON.stringify(paths)}")
      else println(JSON.stringify(paths))
    
      val tasks = Future.sequence(paths.toSeq map { path =>
        client.getDataFuture[String](path = s"/$path").map(path -> _)
      })
    
      tasks foreach { tuples =>
        tuples foreach { case (path, values) =>
          println(s"$path: ${JSON.stringify(values)}")
        }
      }
    
      tasks onComplete { _ =>
        client.close()
      }
    })
})
client.connect()
```

`NodeZookeeperClient` can also insert and update data:

```scala
import io.scalajs.JSON
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.npm.nzc._
import io.scalajs.util.ScalaJsHelper._
import scala.scalajs.js

val zkHost = "localhost:2181"
val client = NodeZookeeperClient.createClient(zkHost)
client.onceConnected(() => {
    println(s"Connected to $zkHost...")
    client
      .transaction()
      .create("/txn")
      .create("/txn/1", Buffer.from("transaction"))
      .setData("/txn/1", Buffer.from("test"), -1)
      .check("/txn/1")
      .remove("/txn/1", -1)
      .remove("/txn")
      .commit((error: Exception, results: js.Any) => {
        if (isDefined(error)) println(s"Failed to execute the transaction: $error, results: ${JSON.stringify(results)}")
        else println("Transaction completed.")
        client.close()
      })
})
client.connect()
```

### Artifacts and Resolvers

To add the `NodeZookeeperClient` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "node-zookeeper-client" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```