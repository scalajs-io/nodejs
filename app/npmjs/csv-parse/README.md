Csv-parse API for Scala.js
================================
[csv-parse](https://www.npmjs.com/package/csv-parse) - CSV parsing implementing the Node.js stream.Transform API.

### Description

Part of the CSV module, this project is a parser converting CSV text input into arrays or objects. 
It implements the Node.js stream.Transform API. It also provides a simple callback-based API for convenience. 
It is both extremely easy to use and powerful. It was first released in 2010 and is used against big data sets 
by a large community.

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
import io.scalajs.JSON
import io.scalajs.npm.csvparse._
import io.scalajs.npm.readablestream.Readable
import scalajs.js

val text =
    """# A List of Super Heroes
      |"first", "last", "alter-ego", "votes"
      |"Bruce", "Wayne", "Batman", 1000
      |"Charles", "Xavier", "Professor X", 890
      |"Clark", "Kent", "Superman", 2000
      |"David", "Banner", "The Incredible Hulk", 1985
      |"Peter", "Parker", "The Amazing Spider-Man", 1999""".stripMargin

val results = js.Array[js.Any]()

val parser = CsvParse(new ParserOptions(
    comment = "#",
    auto_parse = true,
    columns = true,
    delimiter = ",",
    quote = "\"",
    relax = true,
    rowDelimiter = "\n",
    skip_empty_lines = true,
    trim = true
))
parser.onData((data: js.Any) => results.push(data))

val readable = new Readable()
readable._read = () => {}
readable.push(text)
readable.push(null)
readable.pipe(parser)

readable.onEnd(() => {
  println(JSON.stringify(results, null, " "))
})
```

##### Output:

```text
[
 {
  "first": "Bruce",
  "last": "Wayne",
  "alter-ego": "Batman",
  "votes": 1000
 },
 {
  "first": "Charles",
  "last": "Xavier",
  "alter-ego": "Professor X",
  "votes": 890
 },
 {
  "first": "Clark",
  "last": "Kent",
  "alter-ego": "Superman",
  "votes": 2000
 },
 {
  "first": "David",
  "last": "Banner",
  "alter-ego": "The Incredible Hulk",
  "votes": 1985
 },
 {
  "first": "Peter",
  "last": "Parker",
  "alter-ego": "The Amazing Spider-Man",
  "votes": 1999
 }
]
```

### Artifacts and Resolvers

To add the `CsvParse` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "csv-parse" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```