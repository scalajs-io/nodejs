ScalaJs.io
==========
This is a complete Scala.js facade for Node.js, io.js and npm; which means you can develop full-blown Node.js/io.js 
applications using popular JavaScript software stacks including the MEAN Stack (MongoDB, Express, Angular, Node)
and many other popular npm packages.
 
## Table of Contents

* <a href="#introduction">Introduction</a>
* <a href="#development">Development</a>
    * <a href="#build_requirements">Build Requirements</a>
    * <a href="#building_sdk">Building the SDK</a>
    * <a href="#resolvers">Resolvers</a>
    * <a href="#apps_using_means">Developed using ScalaJs.io</a>
    * <a href="#discussions">Discussions</a>
    * <a href="#advantages">Advantages over JavaScript</a>
* <a href="#NodeJS">Node.js bindings</a>
    * <a href="#node_modules">Modules</a>
    * <a href="#npm_modules">Third-party Modules</a>
    * <a href="#node_integration">Integration Guidance</a>    
* <a href="#Express">Express.js bindings</a>
* <a href="#MongoDB">MongoDB bindings</a>
* <a href="#Angular">Angular.js bindings</a>   
    * <a href="#Refinements">Scala.js Refinements</a> 
    * <a href="#social_networks">Social Network bindings</a> 

<a name="introduction"></a>
## Introduction

The goal of this project is to provide a complete Scala.js binding for the entire MEAN Stack. Why? Because I love NodeJS,
 but I have a love/hate relationship with JavaScript. And many others feel the same way about JavaScript, which is why
 there are so many languages that are designed to improve the experience (CoffeeScript, TypeScript, Scala.js and others). 
 Simply put, ScalaJs.io let's me have my cake and eat it too! And as such, I've gone to great lengths to bring all the 
 things you love about developing applications on the MEAN Stack to Scala.
 
ScalaJs.io is a componentized platform; allowing developers to use only the features they want. If all your application 
requires is a binding for AngularJS, you can use just that. Alternatively, you could use only the Node bindings, or the 
entire MEAN stack (or any of the bundled npm library bindings).

Currently, there are at least four development use cases for ScalaJs.io:
 
* Building full MEAN stack applications using the bundled MongoDB, Express, Angular and Node bindings.
* Building rich thin-client web front-ends using AngularJS bindings only (with any backend).
* Building REST services using Node (and optionally Express) bindings only.
* Building CLI applications using Node bindings only.

<a name="development"></a>
## Development

<a name="build_requirements"></a>
### Build Requirements

* [SBT 0.13.13] (http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
#### Build/publish the SDK

```bash
 $ sbt clean publish-local
```

<a name="resolvers"></a>
#### Resolvers

To add the ScalaJs.io bindings/library to your project, add the following to your build.sbt:  

```   
resolvers += Resolver.sonatypeRepo("releases") 
```

<a name="apps_using_means"></a>
### Developed using  ScalaJs.io
   
The following applications were developed using ScalaJs.io:

| Application                                                            | Frontend              | Backend            | Scalajs.io version | Description                              |
|------------------------------------------------------------------------|-----------------------|--------------------|--------------------|------------------------------------------|
| [Phaser-Invaders](https://github.com/scalajs-io/phaser-invaders-demo)  | Scala.js + DOM        | Scala + NodeJS     | 0.3.0.1            | Port of Phaser Invaders. |
| [Socialize](https://github.com/ldaniels528/scalajs-nodejs-socialized)  | Scala.js + AngularJS  | Scala.js + NodeJS  | 0.3.0.3            | A Facebook-inspired Social networking web application. |
| [Todo MVC](https://github.com/ldaniels528/scalajs-nodejs-todomvc)      | Scala.js + AngularJS  | Scala.js + NodeJS  | 0.2.3.1            | A simple Todo example application. |
| [Trifecta](https://github.com/ldaniels528/trifecta)                    | Scala.js + AngularJS  | Scala + Play 2.4.x | 0.3.0.0            | Trifecta is a web-based and CLI tool that simplifies inspecting Kafka messages and Zookeeper data. |
 
 
<a name="discussions"></a>
### Discussions
 
There's a discussion about [ScalaJs.io on Reddit](https://www.reddit.com/r/scala/comments/4loosi/meansjs_scalajs_facades_for_the_nodejs_api/).    

<a name="advantages">
### Advantages over JavaScript

Scala.js offers many advantages over native JavaScript:

* Scala.js is strongly-typed
* Excellent IDE support
* No JavaScript Warts
* More concise
* [Go beyond JavaScript ES6, today](http://www.scala-js.org)

Consider the following example in JavaScript. Here we have a nested collection of callbacks (read: pyramid of doom) 
in order to gather the information that we display at the end.

##### JavaScript and Node.js

```javascript
var output1 = null;
var output2 = null;
var output3 = null;

fs.mkdirp("/a/test/dir", function (err1) {
    Assert.ifError(err1);

    fs.writeFile("/a/test/dir/file.txt", "Hello World", function (err2) {
        Assert.ifError(err2);

        fs.readFile("/a/test/dir/file.txt", function (err3, data) {
            Assert.ifError(err3);
            output1 = data; // ~> Buffer("Hello World")

            fs.unlink("/a/test/dir/file.txt", function (err4) {
                Assert.ifError(err4);

                fs.readdir("/a/test", function (err5, dir) {
                    Assert.ifError(err5);
                    output2 = dir; // ~> ["dir"]

                    fs.stat("/a/test/dir", function (err6, stats) {
                        Assert.ifError(err6);
                        output3 = stats.isDirectory(); // ~> true

                        fs.rmdir("/a/test/dir", function (err7) {
                            Assert.ifError(err7);
                            fs.mkdirp("C:\\use\\windows\\style\\paths", function (err8) {
                                Assert.ifError(err8);
                                
                                console.log("output1 =", output1.toString(), output1);
                                console.log("output2 =", output2);
                                console.log("output3 =", output3)
                            })
                        })
                    })
                })
            })
        })
    })
});
```

Now consider the equivalent logic in Scala.js using its much more elegant `for` comprehension:

##### Scala.js and Node.js

```scala
import io.scalajs.nodejs.console
import io.scalajs.nodejs.Fs._
  
for {
  _ <- Fs.mkdirpFuture("/a/test/dir")
  _ <- Fs.writeFileFuture("/a/test/dir/file.txt", "Hello World")
  output1 <- Fs.readFileFuture("/a/test/dir/file.txt") // ~> Buffer("Hello World")
  _ <- Fs.unlinkFuture("/a/test/dir/file.txt")
  output2 <- Fs.readdirFuture("/a/test") // ~> ["dir"]
  output3 <- Fs.statFuture("/a/test/dir").map(_.isDirectory()) // ~> true
  _ <- Fs.rmdirFuture("/a/test/dir")
  _ <- Fs.mkdirpFuture("C:\\use\\windows\\style\\paths")
} {
  console.log("output1 =", output1.toString(), output1)
  console.log("output2 =", output2)
  console.log("output3 =", output3)
}
```

<a name="NodeJS"></a>
## Node.js

The Node.js integration is nearly complete (feature for feature), and should be more than sufficient for most web-based 
and CLI applications. Additionally, there are a growing number of third-party (mostly OSS) modules that have been 
implemented as well, including bcrypt, cassandra-driver, kafka-node, mysql, xml2js and many others. 

<a name="node_modules">
#### Modules

The following core Node.js modules (v7.6.0) have been implemented:

| Node Module           | Description                                                                     |
|-----------------------|---------------------------------------------------------------------------------|
| assert                | Provides a simple set of assertion tests that can be used to test invariants. |
| buffer                | The Buffer class was introduced as part of the Node.js API to make it possible to interact with octet streams in the context of things like TCP streams and file system operations. |
| child_process         | The child_process module provides the ability to spawn child processes. |
| cluster               | The cluster module allows you to easily create child processes that all share server ports. |
| crypto                | The crypto module provides cryptographic functionality that includes a set of wrappers for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.|
| dns                   | Support for DNS queries. | 
| events                | Node.js Events Interface | 
| fs                    | File I/O is provided by simple wrappers around standard POSIX functions. |
| http                  | Node.js HTTP Interface |
| https                 | Node.js HTTPS Interface |
| net                   | The net module provides you with an asynchronous network wrapper. |
| os                    | Provides a few basic operating-system related utility functions. |
| path                  | This module contains utilities for handling and transforming file paths. |
| querystring           | The querystring module provides utilities for parsing and formatting URL query strings. |
| readline              | Readline allows reading of a stream on a line-by-line basis. |
| repl                  | The REPL provides a way to interactively run JavaScript and see the results. | 
| stream                | A stream is an abstract interface implemented by various objects in Node.js. | 
| string-decoder        | The string_decoder module provides an API for decoding Buffer objects into strings in a manner that preserves encoded multi-byte UTF-8 and UTF-16 characters. |
| timers                | The timer module exposes a global API for scheduling functions to be called at some future period of time. |
| tty                   | The tty module provides the tty.ReadStream and tty.WriteStream classes. |
| url                   | The url module provides utilities for URL resolution and parsing. |
| util                  | The util module is primarily designed to support the needs of Node.js's internal APIs.|
| vm                    | The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.|
| zlib                  | This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes. |

*NOTE*: The SBT artifact for the complete Node.js platform is: "io.scalajs.npm" %%% "nodejs" % "3.0.6" 

<a name="npm_modules">
#### Third-party Modules

The following Third Party/OSS Node.js (npm) modules have been implemented:

| Module / Package                                                                      | Version | Description                                             |
|---------------------------------------------------------------------------------------|---------|---------------------------------------------------------|
| [async](https://github.com/scalajs-io/async)                                          | 2.0.0   | Higher-order functions and common patterns for asynchronous code. |
| [bcrypt](https://github.com/scalajs-io/bcrypt)                                        | 0.0.3   | A native JS bcrypt library for NodeJS. |
| [bignum](https://github.com/scalajs-io/bignum)                                        | 0.12.5  | Arbitrary-precision integer arithmetic using OpenSSL. |
| [body-parser](https://github.com/scalajs-io/body-parser)                              | 1.15.1  | Body parsing middleware. |
| [brake](https://github.com/scalajs-io/brake)                                          | 1.0.1   | Throttle a stream with backpressure. |
| [buffermaker](https://github.com/scalajs-io/buffermaker)                              | 1.2.0   | buffermaker is a convenient way of creating binary strings. |
| [cassandra-driver](https://github.com/scalajs-io/cassandra-driver)                    | 3.0.2   | DataStax Node.js Driver for Apache Cassandra |
| [cheerio](https://github.com/scalajs-io/cheerio)                                      | 0.22.0  | Tiny, fast, and elegant implementation of core jQuery designed specifically for the server |
| [chalk](https://github.com/scalajs-io/chalk)                                          | 1.1.3   | Terminal string styling done right. Much color. |
| [cookie](https://github.com/scalajs-io/cookie)                                        | 0.3.1   | HTTP server cookie parsing and serialization |
| [cookie-parser](https://github.com/scalajs-io/cookie-parser)                          | 1.4.3   | Cookie parsing with signatures |
| [colors](https://github.com/scalajs-io/colors)                                        | 1.1.2   | Get colors in your node.js console.|
| [csv-parse](https://github.com/scalajs-io/csv-parse)                                  | 1.1.2   | CSV parsing implementing the Node.js 'stream.Transform' API.|
| [csvtojson](https://github.com/scalajs-io/csvtojson)                                  | 1.1.4   | A tool concentrating on converting csv data to JSON with customised parser supporting.|
| [drama](https://github.com/scalajs-io/drama)                                          | 0.1.3   | drama is an Actor model implementation for JavaScript and Node.js |
| [escape-html](https://github.com/scalajs-io/escape-html)                              | 1.0.3   | Escape string for use in HTML |
| [express](https://github.com/scalajs-io/express)                                      | 4.13.4  | Fast, unopinionated, minimalist web framework for Node.js |
| [express-csv](https://github.com/scalajs-io/express-csv)                              | 0.6.0   | `express-csv` provides response csv easily to express. |
| [express-fileupload](https://github.com/scalajs-io/express-fileupload)                | 0.0.5   | Simple express file upload middleware that wraps around connect-busboy |
| [express-ws](https://github.com/scalajs-io/express-ws)                                | 2.0.0   | WebSocket endpoints for Express applications |
| [feedparser-promised](https://github.com/scalajs-io/feedparser-promised)              | 1.1.1   | Wrapper around feedparser with promises. |
| [filed](https://github.com/scalajs-io/filed)                                          | 0.1.0   | Simplified file library. |
| [github-api-node](https://github.com/scalajs-io/github-api-node)                      | 0.11.2  | A higher-level wrapper around the Github API. |
| [glob](https://github.com/scalajs-io/glob)                                            | 7.1.1   | A little globber. |
| [html-to-json](https://github.com/scalajs-io/html-to-json)                            | 0.6.0   | Parses HTML strings into objects using flexible, composable filters. |
| [htmlparser2](https://github.com/scalajs-io/htmlparser2)                              | 3.9.1   | A forgiving HTML/XML/RSS parser. The parser can handle streams and provides a callback interface. |
| [jsdom](https://github.com/scalajs-io/jsdom)                                          | 9.9.1   | A JavaScript implementation of the WHATWG DOM and HTML standards, for use with Node.js |
| [jwt-simple](https://github.com/scalajs-io/jwt-simple)                                | 0.5.0   | JWT(JSON Web Token) encode and decode module |
| [kafka-node](https://github.com/scalajs-io/kafka-node)                                | 0.0.11  | A node binding for librdkafka | Tesing required |
| [kafka-rest](https://github.com/scalajs-io/kafka-rest)                                | 0.0.4   | REST Proxy wrapper library for Kafka | Tesing required |
| [md5](https://github.com/scalajs-io/md5)                                              | 2.1.0   | A JavaScript function for hashing messages with MD5. |
| [memory-fs](https://github.com/scalajs-io/memory-fs)                                  | 0.3.0   | A simple in-memory filesystem. Holds data in a javascript object. |
| [mkdirp](https://github.com/scalajs-io/mkdirp)                                        | 0.5.1   | Recursively mkdir, like mkdir -p. |
| [moment](https://github.com/scalajs-io/moment)                                        | 2.17.1  | Parse, validate, manipulate, and display dates in JavaScript. |
| [moment-timezone](https://github.com/scalajs-io/moment)                               | 0.5.11  | Parse and display dates in any timezone. |
| [mongodb](https://github.com/scalajs-io/mongodb)                                      | 2.2.22  | The official MongoDB driver for Node.js. |
| [mongoose](https://github.com/scalajs-io/mongoose)                                    | 4.8.1   | Mongoose is a MongoDB object modeling tool designed to work in an asynchronous environment. |
| [mpromise](https://github.com/scalajs-io/mpromise)                                    | 0.5.5   | A promises/A+ conformant implementation, written for mongoose. |
| [multer](https://github.com/scalajs-io/multer)                                        | 1.1.0   | Multer is a node.js middleware for handling multipart/form-data. | Tesing required |
| [mysql](https://github.com/scalajs-io/mysql)                                          | 2.10.2  | A node.js driver for mysql. |
| [node-zookeeper-client](https://github.com/scalajs-io/node-zookeeper-client)          | 0.2.2   | A higher-level ZooKeeper client based on node-zookeeper with support for locking and master election. | Tesing required |
| [numeral](https://github.com/scalajs-io/numeral)                                      | 2.0.4   | A javascript library for formatting and manipulating numbers. |
| [oppressor](https://github.com/scalajs-io/oppressor)                                  | 0.0.1   | Streaming http compression response negotiator. | Tesing required |
| [readable-stream](https://github.com/scalajs-io/readable-stream)                      | 2.2.2   | Streams3, a user-land copy of the stream library from Node.js. |
| [request](https://github.com/scalajs-io/request)                                      | 2.72.1  | Simplified HTTP request client. |
| [rxjs](https://github.com/scalajs-io/rxjs)                                            | 4.1.0   | The Reactive Extensions for JavaScript. |
| [socket.io](https://github.com/scalajs-io/socket.io)                                  | 1.7.2   | Realtime application framework (Node.JS server). |
| [socket.io-client](https://github.com/scalajs-io/socket.io-client)                    | 1.7.2   | Socket.io client. |
| [splitargs](https://github.com/scalajs-io/splitargs)                                  | 0.0.7   | Splits strings into tokens by given separator except treating quoted part as a single token. |
| [tingodb](https://github.com/scalajs-io/tingodb)                                      | 0.5.1   | Embedded Node.js database upward compatible with MongoDB. |
| [tough-cookie](https://github.com/scalajs-io/tough-cookie)                            | 2.3.2   | RFC6265 Cookies and Cookie Jar for node.js. |
| [transducers-js](https://github.com/scalajs-io/transducers-js)                        | 0.4.174 | A high performance Transducers implementation for JavaScript. |
| [type-is](https://github.com/scalajs-io/type-is)                                      | 1.6.14  | Infer the content-type of a request. |
| [watch](https://github.com/scalajs-io/watch)                                          | 0.18.0  | Utilities for watching file trees. |
| [winston](https://github.com/scalajs-io/winston)                                      | 2.3.1   | A multi-transport async logging library for Node.js. |
| [winston-daily-rotate-file](https://github.com/scalajs-io/winston-daily-rotate-file)  | 1.4.4   | A multi-transport async logging library for Node.js. |    
| [xml2js](https://github.com/scalajs-io/xml2js)                                        | 0.4.16  | Simple XML to JavaScript object converter. |

*NOTE*: The full SBT artifact expression is: "io.scalajs.npm" %%% "xxxx" % version (e.g. "io.scalajs.npm" %%% "express" % "4.14.1")

I've provided an example to demonstrate how similar the Scala.js code is to the JavaScript
that it replaces.

The following is a simple Hello World app in Node using JavaScript:

```javascript
var http = require("http");
http.createServer(function(request, response) {
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("Hello World");
    response.end();
}).listen(8888);
```

Here's the same example using Scala.js:

```scala
import io.scalajs.nodejs.http._
import scalajs.js

Http.createServer((request: ClientRequest, response: ServerResponse) => {
    response.writeHead(200, js.Dictionary("Content-Type" -> "text/plain"))
    response.write("Hello World")
    response.end()
}).listen(8888)
```

<a name="Express"></a>
## Express.js

The following is a simple Hello World app in Node and Express using JavaScript:

```javascript
var express = require('express');
var app = express();

app.get('/', function (req, res) {
   res.send('Hello World');
})

var server = app.listen(8081, function () {
  var host = server.address().address
  var port = server.address().port
  console.log("Example app listening at http://%s:%s", host, port)
})
```

Here's the same example using Scala.js:

```scala
import io.scalajs.nodejs.console
import io.scalajs.npm.express._

val app = Express()

app.get("/", (req: Request, res: Response) => res.send("Hello World"))

val server = app.listen(8081, connect)

private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port
    console.log("Example app listening at http://%s:%s", host, port)
}
```

The following is a more elaborate example:

```scala
import io.scalajs.npm.express._
import io.scalajs.util.ScalaJsHelpers._
import scalajs.js

val todos: js.Array[Todo] = emptyArray

val app = Express()

app.use(BodyParser.json())
app.use(BodyParser.urlencoded(new UrlEncodedBodyOptions(extended = true)))   
 
app.get("/api/todo/:id", (request: Request, response: Response) => getTodo(request, response))
app.get("/api/todos", (request: Request, response: Response) => getTodos(request, response))
app.post("/api/todo", (request: Request, response: Response) => createTodo(request, response))

def createTodo(request: Request, response: Response) = {
    request.bodyAs[Todo] match {
        case todo if todo.hasTitle =>
            todo.id = UUID.randomUUID().toString
            todos.push(todo)
            response.send(todos)
        case todo =>
            response.badRequest(todo)
    }
}
  
def getTodo(request: Request, response: Response) = {
    val todoId = request.params("id")
    todos.indexWhereOpt(_.id == todoId) match {
        case Some(index) => response.send(todos(index))
        case None => response.notFound(todoId)
    }
}

def getTodos(request: Request, response: Response) = response.send(todos)

@js.native
trait Todo extends js.Object {
    var id: String = js.native
    var title: String = js.native
    var completed: Boolean = js.native
}

implicit class TodoExtensions(val todo: Todo) extends AnyVal {

    @inline
    def hasId: Boolean = Option(todo).flatMap(t => Option(t.id)).exists(_.trim.nonEmpty)
    
    @inline
    def hasTitle: Boolean = Option(todo).flatMap(t => Option(t.title)).exists(_.trim.nonEmpty)
    
    @inline
    def isComplete: Boolean = hasId && hasTitle

}
```
    
<a name="MongoDB"></a>
## MongoDB

The following example demonstrates establishing a connection to MongoDB using Scala.js:

```scala
import io.scalajs.nodejs.console
import io.scalajs.npm.mongodb._
import io.scalajs.util.ScalaJsHelper._

// Connection URL. This is where your mongodb server is running.
val url = "mongodb://localhost:27017/test"

// Use connect method to connect to the Server
MongoClient.connect(url, (err, db) => {
    if (isDefined(err)) {
        console.log("Unable to connect to the mongoDB server. Error:", err)
    } else {
        // HURRAY!! We are connected. :)
        console.log("Connection established to: %s", url)
        
        // TODO do some work here with the database.
        
        // close connection
        db.close()
    }
})
```

Or, if you'd like to be more Scala idiomatic, the connection fragment could be written as follows:

```scala
import io.scalajs.nodejs.console
import io.scalajs.npm.mongodb._
import scala.util.{Success, Failure}

MongoClient.connectFuture(url) onComplete {
    case Success(db) =>
        // HURRAY!! We are connected. :)
        console.log("Connection established to: %s", url)

        // TODO do some work here with the database.

        // close connection
        db.close()
    case Failure(e) =>
        console.log("Unable to connect to the mongoDB server. Error:", e.getMessage)  
}
```

Alternatively, you could choose to use "foreach" to directly manage only the success case:

```scala
import io.scalajs.npm.mongodb._
import io.scalajs.util.PromiseHelper._

MongoClient.connectFuture(url) foreach { db => 
    // HURRAY!! We are connected. :)
    console.log("Connection established to: %s", url)

    // TODO do some work here with the database.

    // close connection
    db.close()
}
```

ScalaJs.io exposes Future-based alternatives to most of the asynchronous functions found in MongoDB, Express, Angular and Node. 
This means that you can use Scala's amazing *for* comprehensions to replace the dreaded pyramid of doom callbacks normally
associated with JavaScript asynchronous code.

Consider the following:

```scala
for {
    // List all the virtual machine images you can use.
    vmImages <- computeManagementClient.virtualMachineVMImages.listFuture
    
    // Create a cloud service.
    computeManagementClient <- computeManagementClient.hostedServices.createFuture(
      HostedServicesOptions(serviceName = serviceName, label = "cloud service 01", location = "West US"))
    
    // Create a virtual machine in the cloud service
    deployment <- computeManagementClient.virtualMachines.createDeploymentFuture(serviceName, deploymentOptions)
} {
    console.info(deployment)
}
```
