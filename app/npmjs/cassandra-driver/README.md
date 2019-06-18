Cassandra-driver API for Scala.js
=======================
[cassandra-driver](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.

### Description

A modern, feature-rich and highly tunable Node.js client library for Apache Cassandra (1.2+) and 
DataStax Enterprise (3.1+) using exclusively Cassandra's binary protocol and Cassandra Query Language v3.

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
import io.scalajs.npm.cassandradriver._
import scalajs.js


val client = new Client(new ClientOptions(contactPoints = js.Array("localhost"), keyspace = "classroom"))
val students = Seq(
    js.Array("123456", "Larry Sanders", "Operating Systems")
)

students foreach { params =>
    client.execute("INSERT INTO students (id, name, course) VALUES (?, ?, ?)", params, (err, student) => {
        console.log("student =>", student)
    })
}


class Student(val id: String, val name: String, val course: String) extends js.Object
```

### Artifacts and Resolvers

To add the `CassandraDriver` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "cassandra-driver" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```