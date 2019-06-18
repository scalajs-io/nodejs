KafkaNode API for Scala.js
================================
[kafka-node](https://www.npmjs.com/package/kafka-node) - Client for Apache Kafka v0.8+.

### Description

Kafka-node is a Node.js client with Zookeeper integration for Apache Kafka 0.8.1 and later.

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
import io.scalajs.nodejs.console
import io.scalajs.npm.kafkanode._
import io.scalajs.util.ScalaJsHelper._
import scalajs.js

val zkConnect = "localhost:2181"
val topic = "com.shocktrade.quotes"

val client = new Client(zkConnect)
val producer = new Producer(client)
producer.createTopicsFuture(topics = js.Array(topic), async = true) foreach { _ =>
  console.log(s"Created topic $topic")
}

val consumer = new Consumer(client, js.Array(new FetchRequest(topic = topic, offset = 0)),
    new ConsumerOptions(
      groupId = "kafka-node-group",
      autoCommit = true,
      autoCommitIntervalMs = 5000,
      fetchMaxWaitMs = 100,
      fetchMinBytes = 4,
      fetchMaxBytes = 1024 * 1024,
      fromOffset = 0L,
      encoding = "utf8"
    )
)

consumer.onMessage((message: String) => {
  console.log("message: %j", message)
})

consumer.onError((error: js.Any) => {
  console.log("error: %j", error)
})
```

### Artifacts and Resolvers

To add the `KafkaNode` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "kafka-node" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```