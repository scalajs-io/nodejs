Form-data API for Scala.js
================================
[form-data](http://form-data.github.io/node-form-data-native/2.2/api/) - A library to create readable "multipart/form-data" streams.

### Description

A library to create readable "multipart/form-data" streams. Can be used to submit forms and file uploads 
to other web applications.

<a name="build_requirements"></a>
### Build Requirements

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
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

##### FormData accepts strings, buffers and readables

```scala
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.formdata._
import scalajs.js

val form = FormData()
form.append("my_field", "my value")
form.append("my_buffer", new Buffer(10))
form.append("my_file", Fs.createReadStream("/foo/bar.jpg"))
```

##### FormData accepts Http-response streams

```scala
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.http.{Http, ServerResponse}
import io.scalajs.npm.formdata._
import scalajs.js

val form = FormData()
Http.request("http://nodejs.org/images/logo.png", (response: ServerResponse) => {
    form.append("my_field", "my value")
    form.append("my_buffer", new Buffer(10))
    form.append("my_logo", response)
})
```

##### FormData accepts Request streams

```scala
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.http.{Http, ServerResponse}
import io.scalajs.npm.formdata._
import io.scalajs.npm.request.Request
import scalajs.js

val form = FormData()
form.append("my_field", "my value")
form.append("my_buffer", new Buffer(10))
form.append("my_logo", Request("http://nodejs.org/images/logo.png"))
```

### Artifacts and Resolvers

To add the `Form-data` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "form-data" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
