OTaaTRepl API for Scala.js
================================
[otaat-repl](https://www.npmjs.com/package/otaat-repl) - A node.js REPL that helps you do "One thing at a time".

### Description

The node.js REPL is fantastic. It's a great tool for experimentation, testing, debugging, domain-specific languages, 
etc. The only trouble with the REPL is that it is hard to deal with asynchronous code. Not impossible, just hard. 
It really is a great place to do one thing at a time, but it's a lousy place to do many things at once.

Of course, if you are using node.js, you already use asynchronous code all the time. Asynchronous design is one 
of node.js's strengths. Even if you didn't do any asynchronous coding before learning node.js, you do now, right?

Enter OTaaTRepl.

OTaaTRepl is a small wrapper around the standard node.js REPL that handles promise objects complying with the 
CommonJS Promises/A specification. When an expression results in a non-promise the REPL acts as normal. When an 
expression results in a CommonJS Promises/A promise then the REPL does not return control back to the user until 
either the promise is fulfilled, the promise is rejected, or a timeout is reached. This creates the illusion that 
the REPL is blocked until the asynchronous expression completes. When you want to do one thing at a time this is 
exactly the behavior you want. When the promise is fulfilled the results are displayed and also put in the _ variable 
just as if the code really was blocking.

OTaaTRepl is known to work with the wonderful promise library Q by Kris Kowal. In theory it should work with any 
object that has a then() method that accepts a fulfillment callback and a rejection callback.

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
import io.scalajs.npm.otaatrepl._

val replServer = OTaaTRepl.start(new OTaaTReplOptions(
  prompt = "amazing> "
))
```

### Artifacts and Resolvers

To add the `OTaaTRepl` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "otaat-repl" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```