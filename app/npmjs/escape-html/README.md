EscapeHtml API for Scala.js
================================
[escape-html](https://www.npmjs.com/package/escape-html) - Escape string for use in HTML.

### Description

Escape string for use in HTML

This module exports a single function, escapeHtml, that is used to escape a string of content such that it can be 
interpolated in HTML content.

This module will escape the following characters: ", ', &, <, and >.

Note that the escaped value is only suitable for being interpolated into HTML as the text content of elements in 
which the tag does not have different escaping mechanisms (it cannot be placed inside `<style>` or `<script>`, 
for example, as those content bodies are not HTML, but CSS and JavaScript, respectively; these are known as 
"raw text elements" in the HTML standard).

Note when using the escaped value within a tag, it is only suitable as the value of an attribute, where the 
value is quoted with either a double quote character (") or a single quote character (').

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
import io.scalajs.npm.escapehtml._

EscapeHtml("foo & bar") // "foo &amp; bar"
```

### Artifacts and Resolvers

To add the `EscapeHtml` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "escape-html" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```