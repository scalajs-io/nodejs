DOM-HTML API for Scala.js
================================
A collection of DOM-HTML bindings for Scala.js

### Description

A collection of DOM-HTML bindings for Scala.js

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
import scalajs.js

val result = JSON.parseAs[js.Object]("""{"x":5}""", { (key: js.Any, value: js.Any) => value }: js.Function)
println(JSON.stringify(result)) // {"x":5}
```

In some cases, the NodeList is a live collection, which means that changes in the DOM are reflected in the collection. 
For example, Node.childNodes is live:

```scala
import io.scalajs.dom._
import io.scalajs.dom.html.browser._

val parent = document.getElementById[ParentNode]("parent")
val child_nodes = parent.childNodes
console.log(child_nodes.length); // let's assume "2"
parent.appendChild(document.createElement("div"))
console.log(child_nodes.length); // should output "3"
```

The following example shows how to create a URLSearchParams object from a URL string.

```scala
import io.scalajs.dom.html._

val searchParams = new URLSearchParams("key1=value1&key2=value2")

// Display the key/value pairs
for (value <- searchParams.values()) {
  println(value)
}
```

The performance.now() method returns a DOMHighResTimeStamp, measured in milliseconds, 
accurate to five thousandths of a millisecond (5 microseconds).

```scala
import io.scalajs.dom._
import io.scalajs.dom.html.browser._

def doSomething() {
  // ...
}

val t0 = performance.now()
doSomething()
val t1 = performance.now()
console.log("Call to doSomething took " + (t1 - t0) + " milliseconds.");
```

### Artifacts and Resolvers

To add the `DOM-HTML` bindings to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs" %%% "dom-html" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
