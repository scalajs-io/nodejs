HtmlParser2 API for Scala.js
=======================
[htmlparser2](https://www.npmjs.com/package/htmlparser2) - Fast & forgiving HTML/XML/RSS parser.

### Description

A forgiving HTML/XML/RSS parser. The parser can handle streams and provides a callback interface.

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
  import io.scalajs.npm.htmlparser2._
  import scala.scalajs.js
  
  val parser = new Parser(
    new ParserHandler {

      override def onopentag(name: String, attribs: js.Dictionary[String]) {
        if (name == "script" && attribs("type") == "text/javascript") {
          console.log("JS! Hooray!")
        }
      }

      override def ontext(text: String): Unit = console.log("-->", text)

      override def onclosetag(tagname: String) {
        if (tagname == "script") {
          console.log("That's it?!")
        }
      }
    },
    new ParserOptions(decodeEntities = true)
  )
  parser.write("Xyz <script type='text/javascript'>var foo = '<<bar>>'</script>")
  parser.end()
```

### Artifacts and Resolvers

To add the `HtmlParser2` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "htmlparser2" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```