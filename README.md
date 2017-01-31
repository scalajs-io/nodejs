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
    * <a href="#running_examples">Building and run examples</a>
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
#### Build Requirements

* [SBT 0.13.13] (http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
#### Build/publish the SDK

```bash
 $ sbt clean publish-local
```

<a name="running_examples"></a>
#### Building and running examples

```bash
 $ sbt "project examples" clean fastOptJS
 $ node ./examples.js ColorsExample
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
| [Scalajs-Invaders](https://github.com/ldaniels528/scalajs-invaders)    | Scala.js + DOM        | Scala + NodeJS     | 0.3.0.0            | Port of Phaser Invaders. |
| [Socialize](https://github.com/ldaniels528/scalajs-nodejs-socialized)  | Scala.js + AngularJS  | Scala.js + NodeJS  | 0.2.3.1            | A Facebook-inspired Social networking web application. |
| [Todo MVC](https://github.com/ldaniels528/scalajs-nodejs-todomvc)      | Scala.js + AngularJS  | Scala.js + NodeJS  | 0.2.3.1            | A simple Todo example application. |
| [Trifecta](https://github.com/ldaniels528/trifecta)                    | Scala.js + AngularJS  | Scala + Play 2.4.x | 0.3.0.0            | Trifecta is a web-based and CLI tool that simplifies inspecting Kafka messages and Zookeeper data. |
 
 
<a name="discussions"></a>
### Discussions
 
There's an on-going discussion about [ScalaJs.io on Reddit](https://www.reddit.com/r/scala/comments/4loosi/meansjs_scalajs_facades_for_the_nodejs_api/).    

<a name="advantages">
### Advantages over JavaScript

Scala.js offers many advantages over native JavaScript:

* Scala.js is strongly-typed
* Excellent IDE support
* No JavaScript Warts
* More concise
* [Go beyond JavaScript ES6, today](http://www.scala-js.org/)

Consider the following example in JavaScript. Here we have a nested collection of callbacks in order to gather the
information that we display at the end.

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

The following core Node.js modules have been implemented:

| Node Module           | Version | Artifact ID       | Description                                             | Status          |
|-----------------------|---------|-------------------|---------------------------------------------------------|-----------------|
| assert                | 7.4.0   | nodejs            | Provides a simple set of assertion tests that can be used to test invariants. | Stable |
| buffer                | 7.4.0   | nodejs            | The Buffer class was introduced as part of the Node.js API to make it possible to interact with octet streams in the context of things like TCP streams and file system operations. | Stable |
| cluster               | 7.4.0   | nodejs            | The cluster module allows you to easily create child processes that all share server ports. | Stable |
| crypto                | 7.4.0   | nodejs            | The crypto module provides cryptographic functionality that includes a set of wrappers for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.| Stable |
| dns                   | 7.4.0   | nodejs            | Support for DNS queries.| Stable |
| events                | 7.4.0   | nodejs            | Node.js Events Interface | Stable |
| fs                    | 7.4.0   | nodejs            | File I/O is provided by simple wrappers around standard POSIX functions. | Stable |
| http                  | 7.4.0   | nodejs            | Node.js HTTP Interface | Stable |
| https                 | 7.4.0   | nodejs            | Node.js HTTPS Interface | Stable |
| net                   | 7.4.0   | nodejs            | The net module provides you with an asynchronous network wrapper. | Stable |
| os                    | 7.4.0   | nodejs            | Provides a few basic operating-system related utility functions. | Stable |
| path                  | 7.4.0   | nodejs            | This module contains utilities for handling and transforming file paths. | Stable |
| readline              | 7.4.0   | nodejs            | Readline allows reading of a stream on a line-by-line basis. | Stable |
| repl                  | 7.4.0   | nodejs            | The REPL provides a way to interactively run JavaScript and see the results. | Stable |
| stream                | 7.4.0   | nodejs            | A stream is an abstract interface implemented by various objects in Node.js. | Stable |
| string-decoder        | 7.4.0   | nodejs            | The string_decoder module provides an API for decoding Buffer objects into strings in a manner that preserves encoded multi-byte UTF-8 and UTF-16 characters. | Stable |
| tty                   | 7.4.0   | nodejs            | The tty module provides the tty.ReadStream and tty.WriteStream classes. | Stable |
| url                   | 7.4.0   | nodejs            | The url module provides utilities for URL resolution and parsing. | Stable |
| util                  | 7.4.0   | nodejs            | The util module is primarily designed to support the needs of Node.js's internal APIs.| Stable |
| vm                    | 7.4.0   | nodejs            | The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.| Stable |
| zlib                  | 7.4.0   | nodejs            | This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes. | Stable |

*NOTE*: The full SBT artifact expression is: "io.scalajs.npm" %%% "xxxx" % version 
(e.g. "io.scalajs.npm" %%% "readline" % "0.3.0.0")

<a name="npm_modules">
#### Third-party Modules

The following Third Party/OSS Node.js (npm) modules have been implemented:

| Node Module           | Version | Artifact ID            | Description                                             | Status          |
|-----------------------|---------|------------------------|---------------------------------------------------------|-----------------|
| async                 | 2.0.0   | async                  | Higher-order functions and common patterns for asynchronous code. | Stable |
| bcrypt                | 0.0.3   | bcrypt                 | A native JS bcrypt library for NodeJS. | Stable |
| bignum                | 0.12.5  | bignum                 | Arbitrary-precision integer arithmetic using OpenSSL. | Stable |
| body-parser           | 1.15.1  | body-parser            | Body parsing middleware. | Stable |
| buffermaker           | 1.2.0   | buffermaker            | buffermaker is a convenient way of creating binary strings. | Stable |
| cassandra-driver      | 3.0.2   | cassandra-driver       | DataStax Node.js Driver for Apache Cassandra | Stable |
| cheerio               | 0.22.0  | cheerio                | Tiny, fast, and elegant implementation of core jQuery designed specifically for the server | Stable |
| cookie                | 0.3.1   | cookie                 | HTTP server cookie parsing and serialization | Stable |
| cookie-parser         | 1.4.3   | cookie-parser          | Cookie parsing with signatures | Stable |
| colors                | 1.1.2   | colors                 | Get colors in your node.js console.| Stable |
| csv-parse             | 1.1.2   | csv-parse              | CSV parsing implementing the Node.js 'stream.Transform' API.| Stable |
| drama                 | 0.1.3   | drama                  | drama is an Actor model implementation for JavaScript and Node.js | Stable |
| escape-html           | 1.0.3   | escape-html            | Escape string for use in HTML | Stable |
| express               | 4.13.4  | express                | Fast, unopinionated, minimalist web framework for Node.js | Stable |
| express-csv           | 0.6.0   | express-csv            | express-csv provides response csv easily to express. | Stable |
| express-fileupload    | 0.0.5   | express-fileupload     | Simple express file upload middleware that wraps around connect-busboy | Stable |
| express-multer        | 1.1.0   | express-multer         | Multer is a node.js middleware for handling multipart/form-data. | Tesing required |
| express-ws            |2.0.0-rc1| express-ws             | WebSocket endpoints for Express applications | Stable |
| feedparser-promised   | 1.1.1   | feedparser-promised    | Wrapper around feedparser with promises. | Stable |
| filed                 | 0.1.0   | filed                  | Simplified file library. | Stable |
| html-to-json          | 0.6.0   | html-to-json           | Parses HTML strings into objects using flexible, composable filters. | Stable |
| htmlparser2           | 3.9.1   | htmlparser2            | A forgiving HTML/XML/RSS parser. The parser can handle streams and provides a callback interface. | Stable |
| jsdom                 | 9.9.1   | jsdom                  | A JavaScript implementation of the WHATWG DOM and HTML standards, for use with Node.js. | Stable |
| jwt-simple            | 0.5.0   | jwt-simple             | JWT(JSON Web Token) encode and decode module | Stable |
| jsdom                 | 9.9.1   | jsdom                  | A JavaScript implementation of the WHATWG DOM and HTML standards, for use with Node.js | Stable |
| kafka-node            | 0.0.11  | kafka-node             | A node binding for librdkafka | Tesing required |
| kafka-rest            | 0.0.4   | kafka-rest             | REST Proxy wrapper library for Kafka | Tesing required |
| md5                   | 2.1.0   | md5                    | A JavaScript function for hashing messages with MD5. | Stable |
| memory-fs             | 0.3.0   | memory-fs              | A simple in-memory filesystem. Holds data in a javascript object. | Stable |
| moment                | 2.17.1  | moment                 | Parse, validate, manipulate, and display dates in JavaScript. | Stable |
| moment-timezone       | 0.5.11  | moment-timezone        | Parse and display dates in any timezone. | Stable |
| mongodb               | 2.1.18  | mongodb                | Node.js MongoDB Driver | Stable |
| mysql                 | 2.10.2  | mysql                  | A node.js driver for mysql. | Stable |
| node-zookeeper-client | 0.2.2   | zookeeper-client       | A higher-level ZooKeeper client based on node-zookeeper with support for locking and master election. | Tesing required |
| numeral               | 2.0.4   | numeral                | A javascript library for formatting and manipulating numbers. | Stable |
| oppressor             | 0.0.1   | oppressor              | Streaming http compression response negotiator. | Tesing required |
| request               | 2.72.1  | request                | Simplified HTTP request client. | Stable |
| rx                    | 4.1.0   | rx                     | The Reactive Extensions for JavaScript. | Stable |
| socket.io             | 1.7.2   | socket.io-server       | Realtime application framework (Node.JS server). | Stable |
| socket.io-client      | 1.7.2   | socket.io-client       | Socket.io client. | Stable |
| splitargs             | 0.0.7   | splitargs              | Splits strings into tokens by given separator except treating quoted part as a single token. | Stable |
| transducers-js        | 0.4.174 | transducers            | A high performance Transducers implementation for JavaScript. | Stable |
| type-is               | 1.6.14  | type-is                | A high performance Transducers implementation for JavaScript. | Stable |
| watch                 | 0.18.0  | watch                  | Utilities for watching file trees. | Stable |
| xml2js                | 0.4.16  | xml2js                 | Simple XML to JavaScript object converter. | Stable |

*NOTE*: The full SBT artifact expression is: "io.scalajs.npm" %%% "xxxx" % version 
(e.g. "io.scalajs.npm" %%% "express" % "0.3.0.0")

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

<a name="Angular"></a>
## Angular.js

The following AngularJS services have been implemented thus far:

| Service           | Artifact ID                    | Description                      |
|-------------------|--------------------------------|----------------------------------|
| $anchorScroll     | angularjs-anchor-scroll        | Anchor Scroll Service. |
| $animate          | angularjs-animate              | The $animate service exposes a series of DOM utility methods that provide support for animation hooks. |
| $cacheFactory     | angularjs-core                 | Factory that constructs cache objects and gives access to them. |
| $compile          | angularjs-core                 | Compiles an HTML string or DOM into a template and produces a template function, which can then be used to link scope and the template together. |
| $cookies          | angularjs-cookies              | Provides read/write access to browser's cookies. |
| $cookieStore      | angularjs-cookies              | Provides a key-value (string-object) storage, that is backed by session cookies. |
| $exceptionHandler | angularjs-core                 | Any uncaught exception in angular expressions is delegated to this service. |
| $filter           | angularjs-core                 | Selects a subset of items from array and returns it as a new array. |
| $http             | angularjs-core                 | The $http service is a core Angular service that facilitates communication with the remote HTTP servers via the browser's XMLHttpRequest object or via JSONP. |
| $injector         | angularjs-core                 | $injector is used to retrieve object instances as defined by provider, instantiate types, invoke methods, and load modules. |
| $interval         | angularjs-core                 | Angular's wrapper for window.setInterval. The fn function is executed every delay milliseconds. |
| $location         | angularjs-core                 | The $location service parses the URL in the browser address bar (based on the window.location) and makes the URL available to your application. |
| $log              | angularjs-core                 | Simple service for logging. Default implementation safely writes the message into the browser's console (if present). |
| $modal            | angularjs-ui-bootstrap         | Modal Dialogs - Angular UI Bootstrap |
| $nvd3             | angularjs-nvd3                 | An AngularJS directive for NVD3 re-usable charting library (based on D3).|
| $parse            | angularjs-core                 | Converts Angular expression into a function. |
| $q                | angularjs-core                 | A service that helps you run functions asynchronously, and use their return values (or exceptions) when they are done processing. |
| $resource         | angularjs-core                 | A factory which creates a resource object that lets you interact with RESTful server-side data sources. |
| $route            | angularjs-ui-router            | $route is used for deep-linking URLs to controllers and views (HTML partials). It watches $location.url() and tries to map the path to an existing route definition. |
| $sce              | angularjs-sanitize             | $sce is a service that provides Strict Contextual Escaping services to AngularJS. |
| $timeout          | angularjs-core                 | Angular's wrapper for window.setTimeout. The fn function is wrapped into a try/catch block and delegates any exceptions to $exceptionHandler service. |
| FacebookService   | angularjs-facebook             | AngularJS - Facebook service |
| FileUploader      | angularjs-nergvh-fileupload    | AngularJS File Uploader |
| md5               | angularjs-md5                  | A md5 crypto component for Angular.js. |
| toaster           | angularjs-toaster              | AngularJS Toaster is a customized version of "toastr" non-blocking notification javascript library. |

*NOTE*: The full SBT artifact expression is: "io.scalajs" %%% "angularjs-xxxx" % version 
(e.g. "io.scalajs" %%% "angularjs-toaster" % "0.3.0.0")


#### Defining a Module

```scala
val module = angular.createModule("shocktrade",
    js.Array("ngAnimate", "ngCookies", "ngRoute", "ngSanitize", "nvd3ChartDirectives", "toaster", "ui.bootstrap"))

// add the custom directives
module.directiveOf[AvatarDirective]("avatar")
module.directiveOf[ChangeArrowDirective]("changearrow")

// add the custom filters
module.filter("duration", Filters.duration)
module.filter("yesno", Filters.yesNo)

// add the controllers and services
module.controllerOf[DiscoverController]("DiscoverController")
module.serviceOf[FacebookService]("Facebook")
module.serviceOf[MySession]
module.serviceOf[QuoteService]

// define the routes
module.config({ ($routeProvider: RouteProvider) =>
    $routeProvider
        .when("/about/us", RouteTo(templateUrl = "/assets/views/about/us.htm"))
        .when("/discover", RouteTo(templateUrl = "/assets/views/discover/discover.htm", controller = "DiscoverController"))
        .when("/discover/:symbol", RouteTo(templateUrl = "/assets/views/discover/discover.htm", controller = "DiscoverController"))
        .otherwise(RouteTo(redirectTo = "/about/us"))
})

// initialize the application
module.run({ (WebSocketService: WebSocketService) =>
    // inject Facebook's JavaScript SDK
    FacebookInjector.init()
    
    // initialize the web socket service
    WebSocketService.init()
})
```

#### Filter Example

```scala
val yesNo: js.Function = () => ((state: Boolean) => if (state) "Yes" else "No"): js.Function

module.filter("yesno", yesNo)
```

#### Controller Example 1: Js.Dynamic Impelementation

```scala
module.controllerOf[AwardsController]("AwardsCtrl")

class AwardsController($scope: js.Dynamic, $http: Http, @injected("MySession") mySession: MySession) extends Controller {

    $scope.getAwards = () => AvailableAwards
    
    $scope.getMyAwards = () => getMyAwards
    
    $scope.getAwardImage = (code: String) => AwardIconsByCode.get(code).orNull
    
    $scope.setupAwards = () => setupAwards()
    
    private def getMyAwards: js.Array[js.Dynamic] = {
        mySession.getMyAwards() map (code => AwardsByCode.get(code).orNull)
    }
    
    private def setupAwards() {
        console.log("Setting up awards....")
        AvailableAwards foreach { award =>
            award.owned = mySession.getMyAwards().contains(award.code.as[String])
        }
    }
}
```

In the example above, we're using a Scala.js JSON literal as our scope. While this is very flexible, it's not at all 
type-safe. In addition, most IDE's will be unable to provide any useful type inference information. 

#### Controller Example 2: Type-Safe Implementation

```scala
class AwardsController($scope: AwardsControllerScope, $http: Http,
                       @injected("MySessionService") mySession: MySessionService)
  extends Controller {

  $scope.getAwards = () => {
    Award.AvailableAwards map { award =>
      val myAward = award.asInstanceOf[MyAward]
      myAward.owned = mySession.getMyAwards.contains(award.code)
      myAward
    } sortBy (_.owned) reverse
  }

  $scope.getAwardImage = (aCode: js.UndefOr[String]) => {
    aCode.toOption.flatMap(code => AwardIconsByCode.get(code)).orUndefined
  }

  $scope.getMyAwards = () => {
    mySession.getMyAwards flatMap (code => AwardsByCode.get(code))
  }

}

object AwardsController {

  private val AwardsByCode = js.Dictionary[Award](Award.AvailableAwards map { award => (award.code, award) }: _*)

  private val AwardIconsByCode = js.Dictionary[String](Award.AvailableAwards map { award => (award.code, award.icon) }: _*)

}

@js.native
trait AwardsControllerScope extends Scope {
  var getAwards: js.Function0[js.Array[MyAward]] = js.native
  var getAwardImage: js.Function1[js.UndefOr[String], js.UndefOr[String]] = js.native
  var getMyAwards: js.Function0[js.Array[Award]] = js.native
}

@js.native
trait MyAward extends Award {
  var owned: Boolean = js.native
}
```

In the example above, we using a generic scope object because we don't need to specify any custom scope variables, and 
we're using the `@scope` macro annotation to attach our methods to the `$scope` variable. 

#### Modal Dialog &#8212; Controller and Service

```scala
class InvitePlayerDialog($http: Http, $modal: Modal) extends Service {

  def popup(participant: Participant): Future[InvitePlayerDialogResult] = {
    val modalInstance = $modal.open[InvitePlayerDialogResult](ModalOptions(
      templateUrl = "invite_player_dialog.htm",
      controllerClass = classOf[InvitePlayerDialogController]
    ))
    modalInstance.result
  }
}

class InvitePlayerDialogController($scope: InvitePlayerScope, $modalInstance: ModalInstance[InvitePlayerDialogResult],
                                   @injected("MySessionService") mySession: MySessionService)
  extends Controller {

  private val myFriends = mySession.fbFriends
  $scope.invites = emptyArray[TaggableFriend]

  $scope.getFriends = () => myFriends

  $scope.getInvitedCount = () => $scope.invites.count(invitee => isDefined(invitee))

  $scope.getInvites = () => $scope.invites

  $scope.ok = () => $modalInstance.close(getSelectedFriends)

  $scope.cancel = () => $modalInstance.dismiss("cancel")

  private def getSelectedFriends = {
    js.Array(
      $scope.invites.indices flatMap { n =>
        if (isDefined($scope.invites(n))) Some(myFriends(n)) else None
      }: _*)
  }

}

object InvitePlayerDialogController {
  type InvitePlayerDialogResult = js.Array[TaggableFriend]
}

@js.native
trait InvitePlayerScope extends Scope {
  // variables
  var invites: js.Array[TaggableFriend] = js.native

  // functions
  var cancel: js.Function0[Unit] = js.native
  var getFriends: js.Function0[js.Array[TaggableFriend]] = js.native
  var getInvitedCount: js.Function0[Int] = js.native
  var getInvites: js.Function0[js.Array[TaggableFriend]] = js.native
  var ok: js.Function0[Unit] = js.native
}
```

### Core Angular components

#### Service Example

```scala
import io.scalajs.npm.angularjs._
import io.scalajs.npm.angularjs.http._

module.serviceOf[MarketStatusService]("MarketStatusSvc")


class MarketStatusService($http: Http) extends Service {

  def getMarketStatus(implicit ec: ExecutionContext): Future[MarketStatus] = {
    $http.get[MarketStatus]("/api/tradingClock/status")
  }
  
}

@ScalaJSDefined
class MarketStatus(var stateChanged: Boolean,
                   var active: Boolean,
                   var sysTime: Double,
                   var delay: Double,
                   var start: Double,
                   var end: Double) extends js.Object 
```

#### Directive Example

```scala
module.directiveOf[ChangeArrowDirective]("changearrow")

class ChangeArrowDirective extends Directive[ChangeArrowDirectiveScope] {
  override val restrict = "E"
  override val scope = JS(value = "@value")
  override val transclude = true
  override val replace = false
  override val template = """<i ng-class="icon"></i>"""

  override def link(scope: ChangeArrowDirectiveScope, element: JQLite, attrs: Attributes) = {
    scope.$watch("value", { (newValue: js.UndefOr[Any], oldValue: js.UndefOr[Any]) =>
      scope.icon = newValue.toOption flatMap getNumericValue map {
        case v if v > 0 => "fa fa-arrow-up positive"
        case v if v < 0 => "fa fa-arrow-down negative"
        case _ => "fa fa-minus null"
      } orNull
    })
  }

  private def getNumericValue(newValue: Any): Option[Double] = newValue match {
    case n: Number => Some(n.doubleValue)
    case s: String if s.nonEmpty => Try(s.toDouble).toOption
    case _ => None
  }
}

@js.native
trait ChangeArrowDirectiveScope extends Scope {
  var value: js.UndefOr[Any] = js.native
  var icon: String = js.native
}

object ChangeArrowDirectiveScope {
  def apply(): ChangeArrowDirectiveScope = {
    val scope = new js.Object().asInstanceOf[ChangeArrowDirectiveScope]
    scope.icon = null
    scope
  }
}
```

<a name="Refinements"></a>
### The Refinements

#### Durations

ScalaJs.io provides implicit conversions so that you may use `scala.concurrent.duration.FiniteDuration`s with `$timeout`,
`$interval`, and any other services that use time in milliseconds.

```scala
$timeout(() => doSomething(), 5.minutes)
```

#### JSON data as Scala objects

ScalaJs.io allows you to utilize dynamic JavaScript objects or type-safe Scala objects using traits. 
Consider the following example:

```scala
$http.get[js.Dynamic]("/api/tradingClock/status") onComplete {
    case Success(status) => console.log(angular.toJson(status))
    case Failure(e) => console.error(e.getMessage)
}
```

Above we retrieve a JSON object (see below) in much the same fashion as you would using native JavaScript. Sometimes
one may want to retrieve the data as a `js.Dynamic` because of the flexibility it offers.

```json
{"stateChanged":false,"active":false,"sysTime":1392092448795,"delay":-49848795,"start":1392042600000,"end":1392066000000}
```

However, sometimes we instead want to retrieve the data as a type-safe Scala object. ScalaJs.io makes this as simple as:

```scala
$http.get[MarketStatus]("/api/tradingClock/status") onComplete {
    case Success(status) => console.log(angular.toJson(status))
    case Failure(e) => console.error(e.getMessage)
}

@js.native
trait MarketStatus extends js.Object {
    var stateChanged: Boolean = js.native
    var active: Boolean = js.native
    var sysTime: Double = js.native
    var delay: Double = js.native
    var start: Double = js.native
    var end: Double = js.native
}
```

Above, we retrieve a JSON object via the given API and return a Market Status object.

#### For Comprehensions

ScalaJs.io provides implicit conversions that convert a `HttpResponse[T]` into a `Future[T]`, we can also use `for`
comprehensions when we need to combine data from multiple API calls.

```scala
val outcome = for {
   symbols <- contestService.getHeldSecurities(playerId)
   quotes <- quoteService.getStockQuoteList(symbols)
 } yield quotes
```

The above code uses Scala's for comprehension to first retrieve a collection of symbols (via REST) and then use the 
symbols to then retrieve a collection of quotes (also via REST). 

To do the same in JavaScript would've required creating 
multiple promises (via $q) or ugly callbacks, and then there's the results gathering/error handling... which would also 
be more painful in JavaScript. 

Here's how it's handled via Scala.js:

```scala
outcome onComplete {
    case Success(updatedQuotes) => obj.quotes = updatedQuotes
    case Failure(e) =>
        toaster.error("Failed to load Held Securities")
        console.error(s"Failed to load Held Securities: ${e.getMessage}")
}
```

<a name="social_networks"></a>
### Social Components (Facebook and LinkedIn)

#### Sample Code for Facebook

Inside of your HTML index page:

```javascript
<script>
    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
```

Within your Scala.js application, you can initialize the Facebook SDK:

```scala

val config = FacebookAppConfig(appId = "[YOUR_APP_KEY_GOES_HERE]", status = true, xfbml = true, version = "v2.5")
FB.init(config)
```

Assuming you're using AngularJS, within your Scala.js application, you define the AngularJS Facebook service:

```scala
module.serviceOf[FacebookService]("Facebook")
```
      
Finally, within your AngularJS controller or service you invoke the Facebook login:   
  
```scala    
import io.scalajs.util.ScalaJsHelper._

class SocialController($scope: SocialControllerScope, @injected("Facebook") facebook: FacebookService) extends Controller {
    private var facebookID: js.UndefOr[String] = js.undefined

    $scope.loginToFacebook = () => {
        facebook.login() onComplete {
          case Success(response) =>
            facebookID = response.authResponse.userID
          case Failure(e) =>
            toaster.error("Facebook Login Error", e.displayMessage)
        }
    }   
}

@js.native
trait SocialControllerScope extends Scope {
    var loginToFacebook: js.Function0[Unit] = js.native
}
```

Afterwards, you may call any Facebook API that you have the permissions to execute:

```scala
import io.scalajs.util.ScalaJsHelper._

val outcome = for {
    fbProfile <- facebook.getUserProfile
    fbFriends <- facebook.getTaggableFriends
} yield (fbProfile, friends)

outcome onComplete {
    case Success((fbProfile, friends)) =>
        console.log(s"fbProfile = ${angular.toJson(fbProfile, pretty = true)}")
        console.log(s"fbFriends = ${angular.toJson(fbFriends, pretty = true)}")
    case Failure(e) =>
        toaster.error(s"Failed to retrieve Facebook profile and friends - ${e.displayMessage}")
}
```

If you're not using AngularJS, you can use the Facebook SDK directly:

```scala
FB.login((response: js.UndefOr[FacebookLoginStatusResponse]) =>
    response.toOption match {
        case Some(resp) if resp.error.isEmpty => console.log(s"auth = ${angular.toJson(auth)}")
        case Some(resp) => console.error(s"Error logging in to Facebook: ${resp.error}")
        case None => console.error("No response from Facebook servers")
    }
)     
```

#### Sample Code for LinkedIn

Inside of your HTML index page:

```html
<script type="text/javascript" src="//platform.linkedin.com/in.js">
    api_key: [YOUR_API_KEY_GOES_HERE]
    authorize: true
    onLoad: linkedInInit
    scope: r_basicprofile r_emailaddress rw_company_admin w_share
</script>
```

Within your Scala.js application:

```scala
js.Dynamic.global.linkedInInit = () => {
    val injector = angular.element(jQuery("#Main")).injector()
    injector.get[MySessionService]("MySession").toOption match {
        case Some(mySession) =>
            console.info("Initializing LinkedIn API...")
            mySession.initLinkedIn(LinkedIn.IN)
        case None =>
            console.error("MySession could not be retrieved.")
    }
}
```

Afterwards, you may call any LinkedIn API that you have the permissions to execute: 

```scala

var linkedInID: js.UndefOr[String] = js.undefined

// read the authenticated user's profile
IN.API.Profile(js.Array("me")) onComplete {
    case Success(response) =>
        linkedInID = response.values.headOption.flatMap(_.id.toOption).orUndefined
    case Failure(e) =>
        console.error(s"Failed to retrieve LinkedIn profile - ${e.getMessage}")
}
```
