SplitArgs API for Scala.js
================================
[splitargs](https://www.npmjs.com/package/splitargs) - Splits strings into tokens by given separator except treating quoted part as a single token.

### Description

Splits strings into tokens by given separator except treating quoted part as a single token.

### Build Requirements

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
import io.scalajs.nodejs.Assert
import io.scalajs.npm.splitargs._
import scala.scalajs.js

val line = "I said 'I am sorry.', and he said \"it doesn't matter.\""
val args = SplitArgs(line)
Assert.deepEqual(args, js.Array("I", "said", "I am sorry.,", "and", "he", "said", "it doesn\'t matter."))
```

### Artifacts and Resolvers

To add the `SplitArgs` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "splitargs" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
