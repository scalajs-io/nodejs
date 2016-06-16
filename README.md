 Scalajs-Nodejs (formerly MEANS.js)
====================================
This is a Scala.js binding for the Node.js and MEAN Stack (MongoDB ExpressJS AngularJS NodeJS) applications.
 
## Table of Contents

* <a href="#introduction">Introduction</a>
* <a href="#development">Development</a>
    * <a href="#build_requirements">Build Requirements</a>
    * <a href="#building_sdk">Building the SDK</a>
    * <a href="#running_examples">Building and run examples</a>
    * <a href="#apps_using_means">Developed using Scalajs-Nodejs</a>
    * <a href="#discussions">Discussions</a>
* <a href="#NodeJS">Node.js bindings</a>
    * <a href="#node_modules">Modules</a>
    * <a href="#node_integration">Integration Guidance</a>    
* <a href="#Express">Express.js bindings</a>
* <a href="#MongoDB">MongoDB bindings</a>
* <a href="#Angular">Angular.js bindings</a>   
    * <a href="#Refinements">Scala.js Refinements</a> 
    * <a href="#social_networks">Social Network bindings</a> 

<a name="introduction"></a>
## Introduction

The goal of this project is to be a complete Scala.js binding for the entire MEAN Stack. Why? Because I love NodeJS,
 but I have a love/hate relationship with JavaScript. And many others feel the same way about JavaScript, which is why
 there are so many languages that are designed to improve the experience (CoffeeScript, TypeScript, Scala.js and others). 
 Simply put, Scalajs-Nodejs let's me have my cake and eat it too! And as such, I've gone to great lengths to bring all the 
 things you love about developing applications on the MEAN Stack to Scala.
 
Scalajs-Nodejs is componentized; allowing developers to use include only the features they want. If all your application 
requires is a binding for AngularJS, you can use just that. Alternatively, you could use only the Node bindings, or the 
entire MEAN stack.

Currently, there are at least four development use cases for Scalajs-Nodejs:
 
* Building full MEAN stack applications using AngularJS and Node bindings.
* Building rich thin-client web frontends using AngularJS bindings only (with any backend).
* Building REST services using Node bindings only.
* Building CLI applications using Node bindings only.

<a name="development"></a>
## Development

<a name="build_requirements"></a>
#### Build Requirements

* [Scala 2.11.8+] (http://scala-lang.org/download/)
* [Scala.js 0.6.9] (http://www.scala-js.org/)
* [SBT 0.13.11+] (http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
#### Build/publish the SDK

```bash
 $ sbt clean publish-local
```

<a name="running_examples"></a>
#### Building and running examples

```bash
 $ sbt "project examples" clean fastOptJS
 $ cd examples
 $ node ./examples.js ColorsExample
```

<a name="apps_using_means"></a>
### Developed using  Scalajs-Nodejs
   
The following applications were developed using Scalajs-Nodejs:

| Application                                                            | Frontend              | Backend            | Description                                                  |
|------------------------------------------------------------------------|-----------------------|--------------------|--------------------------------------------------------------|
| [Socialized](https://github.com/ldaniels528/scalajs-nodejs-socialized) | Scala.js/AngularJS    | Scala.js/NodeJS    | A Facebook-inspired Social networking web application. |
| [Todo MVC](https://github.com/ldaniels528/scalajs-nodejs-todomvc)      | Scala.js/AngularJS    | Scala.js/NodeJS    | A simple Todo example application. |
| [Trifecta](https://github.com/ldaniels528/trifecta)                    | Scala.js/AngularJS    | Scala/Play 2.4.x   | Trifecta is a web-based and CLI tool that simplifies inspecting Kafka messages and Zookeeper data. |
 
 
<a name="discussions"></a>
### Discussions
 
There's currently an on-going discussion about [MEANS.js on Reddit](https://www.reddit.com/r/scala/comments/4loosi/meansjs_scalajs_facades_for_the_nodejs_api/).    
   
<a name="NodeJS"></a>
## Node.js

The Node.js integration is by no means complete; however, there should be a sufficient number of
modules implemented for most web applications. 

<a name="node_modules">
#### Modules

The following Core NodeJS modules have been implemented thus far:

| Node Module           | Version | Artifact ID               | Description                                             | Status          |
|-----------------------|---------|---------------------------|---------------------------------------------------------|-----------------|
| assert                | 6.2.1   | scalajs-nodejs-assert     | Provides a simple set of assertion tests that can be used to test invariants. | Stable |
| buffer                | 6.2.1   | scalajs-nodejs-core       | The Buffer class was introduced as part of the Node.js API to make it possible to interact with octet streams in the context of things like TCP streams and file system operations. | Stable |
| cluster               | 6.2.1   | scalajs-nodejs-cluster    | The cluster module allows you to easily create child processes that all share server ports. | Stable |
| crypto                | 6.1.0   | scalajs-nodejs-core       | The crypto module provides cryptographic functionality that includes a set of wrappers for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.| Stable |
| dns                   | 6.2.1   | scalajs-nodejs-dns        | Support for DNS queries.| Stable |
| events                | 6.1.0   | scalajs-nodejs-core       | Node.js Events Interface | Stable |
| fs                    | 6.2.1   | scalajs-nodejs-fs         | File I/O is provided by simple wrappers around standard POSIX functions. | Stable |
| http                  | 6.1.0   | scalajs-nodejs-http       | Node.js HTTP Interface | Stable |
| https                 | 6.1.0   | scalajs-nodejs-https      | Node.js HTTPS Interface | Stable |
| net                   | 6.2.1   | scalajs-nodejs-net        | The net module provides you with an asynchronous network wrapper. | Stable |
| os                    | 6.1.0   | scalajs-nodejs-os         | Provides a few basic operating-system related utility functions. | Stable |
| path                  | 6.1.0   | scalajs-nodejs-path       | This module contains utilities for handling and transforming file paths. | Stable |
| readline              | 6.1.0   | scalajs-nodejs-readline   | Readline allows reading of a stream on a line-by-line basis. | Stable |
| repl                  | 6.1.0   | scalajs-nodejs-repl       | The REPL provides a way to interactively run JavaScript and see the results. | Stable |
| stream                | 6.1.0   | scalajs-nodejs-core       | A stream is an abstract interface implemented by various objects in Node.js. | Stable |
| string-decoder        | 6.1.0   | scalajs-nodejs-string-decoder | The string_decoder module provides an API for decoding Buffer objects into strings in a manner that preserves encoded multi-byte UTF-8 and UTF-16 characters. | Stable |
| tty                   | 6.2.1   | scalajs-nodejs-tty        | The tty module provides the tty.ReadStream and tty.WriteStream classes. | Stable |
| url                   | 6.1.0   | scalajs-nodejs-url        | The url module provides utilities for URL resolution and parsing. | Stable |
| util                  | 6.1.0   | scalajs-nodejs-util       | The util module is primarily designed to support the needs of Node.js's internal APIs.| Stable |
| vm                    | 6.2.1   | scalajs-nodejs-vm         | The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.| Stable |
| zlib                  | 6.1.0   | scalajs-nodejs-zlib       | This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes. | Stable |


The following Third Party/OSS NodeJS modules have been implemented thus far:

| Node Module           | Version | Artifact ID               | Description                                             | Status          |
|-----------------------|---------|---------------------------|---------------------------------------------------------|-----------------|
| adal-node             | 0.1.19  | scalajs-nodejs-adal-node  | Windows Azure Active Directory Client Library for node. | Tesing required |
| amqplib               | 0.4.1   | scalajs-nodejs-amqplib    | An AMQP 0-9-1 (e.g., RabbitMQ) library and client. | Tesing required |
| async                 | 1.5.2   | scalajs-nodejs-async      | Higher-order functions and common patterns for asynchronous code. | Tesing required |
| azure                 | 0.10.6  | scalajs-nodejs-azure      | Microsoft Azure Client Library for node. | WIP - Unusable |
| bcrypt                | 0.0.3   | scalajs-nodejs-bcrypt     | A native JS bcrypt library for NodeJS. | Stable |
| body-parser           | 1.15.1  | scalajs-nodejs-body-parser| Body parsing middleware. | Stable |
| cassandra-driver      | 3.0.2   | scalajs-nodejs-datastax-cassandra| DataStax Node.js Driver for Apache Cassandra | Tesing required |
| colors                | 1.1.2   | scalajs-nodejs-colors     | Get colors in your node.js console.| Stable |
| drama                 | 0.1.3   | scalajs-nodejs-drama      | drama is an Actor model implementation for JavaScript and Node.js | Tesing required |
| escape-html           | 1.0.3   | scalajs-nodejs-escape-html| Escape string for use in HTML | Stable |
| express               | 4.13.4  | scalajs-nodejs-express    | Fast, unopinionated, minimalist web framework for Node.js | Stable |
| express-fileupload    | 0.0.5   | scalajs-nodejs-express-fileupload | Simple express file upload middleware that wraps around connect-busboy | Stable |
| express-ws            |2.0.0-rc1| scalajs-nodejs-express-ws | WebSocket endpoints for Express applications | Stable |
| filed                 | 0.1.0   | scalajs-nodejs-filed      | Simplified file library. | Stable |
| jwt-simple            | 0.5.0   | scalajs-nodejs-jwt-simple | JWT(JSON Web Token) encode and decode module | Stable |
| kafka-node            | 0.0.11  | scalajs-nodejs-kafkanode  | A node binding for librdkafka | Tesing required |
| mongodb               | 2.1.18  | scalajs-nodejs-mongodb    | Node.js MongoDB Driver | Stable |
| multer                | 1.1.0   | scalajs-nodejs-multer     | Multer is a node.js middleware for handling multipart/form-data. | Tesing required |
| mysql                 | 2.10.2  | scalajs-nodejs-mysql      | A node.js driver for mysql. | Stable |
| node-zookeeper-client | 0.2.2   | scalajs-nodejs-zookeeper-client | A higher-level ZooKeeper client based on node-zookeeper with support for locking and master election. | Tesing required |
| oppressor             | 0.0.1   | scalajs-nodejs-oppressor  | Streaming http compression response negotiator. | Tesing required |
| request               | 2.72.1  | scalajs-nodejs-request    | Simplified HTTP request client. | Stable |
| splitargs             | 0.0.7   | scalajs-nodejs-elgs-splitargs | Splits strings into tokens by given separator except treating quoted part as a single token. | Stable |
| watch                 | 0.18.0  | scalajs-nodejs-watch      | Utilities for watching file trees. | Stable |
| xml2js                | 0.4.16  | scalajs-nodejs-xml2js     | Simple XML to JavaScript object converter. | Stable |


*NOTE*: The full SBT artifact expression is: "com.github.ldaniels528" %%% "scalajs-nodejs-xxxx" % version 
(e.g. "com.github.ldaniels528" %%% "scalajs-nodejs-express" % "0.1.7")

I've provided an example to demonstrate how similar the Scala.js code is to the JavaScript
that it replaces.

The following is a simple Hello World app in Node using JavaScript.

```javascript
var http = require("http");
http.createServer(function(request, response) {
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("Hello World");
    response.end();
}).listen(8888);
```

Here's the same example using Scalajs-Nodejs:

```scala
val http = require[Http]("http")
http.createServer((request: ClientRequest, response: ServerResponse) => {
    response.writeHead(200, js.Dictionary("Content-Type" -> "text/plain"))
    response.write("Hello World")
    response.end()
}).listen(8888)
```

<a name="node_integration">
#### Integration Guidance

Currently, the "require" function (along with a few others) must be passed to the Scala.js application because of an issue
with getting a reference to them. This can be accomplished inside a bootstrap JavaScript file as follows:

```javascript
require("./target/scala-2.11/means-examples-fastopt.js");
var facade = examples.Examples();
facade.start({
     "__dirname": __dirname,
     "__filename": __filename,
     "exports": exports,
     "module": module,
     "require": require
 });
```

Then within your Scala.js application:

```scala
def start(bootstrap: Bootstrap) = {
    import bootstrap._
    
    val express = require[Express]("express")
        .
        .
        .
}
```

<a name="Express"></a>
## Express.js

The following is a simple Hello World app in Node and Express using JavaScript.

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
val express = require[Express]("express")
val app = express()

app.get("/", (req: Request, res: Response) => res.send("Hello World"))

val server = app.listen(8081, connect)

private def connect: js.Function = () => {
    val host = server.address().address
    val port = server.address().port
    console.log("Example app listening at http://%s:%s", host, port)
}
```

**NOTE:** Alternatively, you could use any module's apply() method to create an instance via an implicit reference to `require`:

```scala
implicit val require = bootstrap.require

val todos: js.Array[Todo] = emptyArray

val express = Express()
val app = express()
val bodyParser = BodyParser()

app.use(bodyParser.json())
app.use(bodyParser.urlencoded(new UrlEncodedBodyOptions(extended = true)))   
 
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
    def hasId = Option(todo).flatMap(t => Option(t.id)).exists(_.trim.nonEmpty)
    
    @inline
    def hasTitle = Option(todo).flatMap(t => Option(t.title)).exists(_.trim.nonEmpty)
    
    @inline
    def isComplete = hasId && hasTitle

}
```
    
<a name="MongoDB"></a>
## MongoDB

The following example demonstrates establishing a connection to MongoDB using Scala.js:

```scala
// lets require/import the mongodb native drivers.
val mongodb = require[MongoDB]("mongodb")

// We need to work with "MongoClient" interface in order to connect to a mongodb server.
val mongoClient = mongodb.MongoClient

// Connection URL. This is where your mongodb server is running.
val url = "mongodb://localhost:27017/test"

// Use connect method to connect to the Server
mongoClient.connect(url, (err: MongoError, db: MongoDatabase) => {
    if (isDefined(err) {
        console.log("Unable to connect to the mongoDB server. Error:", err)
    } else {
        //HURRAY!! We are connected. :)
        console.log("Connection established to: %s", url)
        
        // do some work here with the database.
        
        //Close connection
        db.close()
    }
})
```

Or, if you'd like to be more Scala idiomatic, the connection fragment could be written as follows:

```scala
mongoClient.connectFuture(url) onComplete {
    case Success(db) =>
        // HURRAY!! We are connected. :)
        console.log("Connection established to: %s", url)

        // do some work here with the database.

        // close connection
        db.close()
    case Failure(e) =>
        console.log("Unable to connect to the mongoDB server. Error:", e.getMessage)  
}
```

Scalajs-Nodejs exposes Future-based alternatives to most of the asynchronous functions found in MongoDB, Express, Angular and Node. 
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
| $anchorScroll     | scalajs-angularjs-core         | Anchor Scroll Service. |
| $animate          | scalajs-angularjs-animate      | The $animate service exposes a series of DOM utility methods that provide support for animation hooks. |
| $cacheFactory     | scalajs-angularjs-core         | Factory that constructs cache objects and gives access to them. |
| $compile          | scalajs-angularjs-core         | Compiles an HTML string or DOM into a template and produces a template function, which can then be used to link scope and the template together. |
| $cookies          | scalajs-angularjs-core         | Provides read/write access to browser's cookies. |
| $cookieStore      | scalajs-angularjs-core         | Provides a key-value (string-object) storage, that is backed by session cookies. |
| $exceptionHandler | scalajs-angularjs-core         | Any uncaught exception in angular expressions is delegated to this service. |
| $filter           | scalajs-angularjs-core         | Selects a subset of items from array and returns it as a new array. |
| $http             | scalajs-angularjs-core         | The $http service is a core Angular service that facilitates communication with the remote HTTP servers via the browser's XMLHttpRequest object or via JSONP. |
| $injector         | scalajs-angularjs-core         | $injector is used to retrieve object instances as defined by provider, instantiate types, invoke methods, and load modules. |
| $interval         | scalajs-angularjs-core         | Angular's wrapper for window.setInterval. The fn function is executed every delay milliseconds. |
| $location         | scalajs-angularjs-core         | The $location service parses the URL in the browser address bar (based on the window.location) and makes the URL available to your application. |
| $log              | scalajs-angularjs-core         | Simple service for logging. Default implementation safely writes the message into the browser's console (if present). |
| $modal            | scalajs-angularjs-ui-bootstrap | Modal Dialogs - Angular UI Bootstrap |
| $parse            | scalajs-angularjs-core         | Converts Angular expression into a function. |
| $q                | scalajs-angularjs-core         | A service that helps you run functions asynchronously, and use their return values (or exceptions) when they are done processing. |
| $resource         | scalajs-angularjs-core         | A factory which creates a resource object that lets you interact with RESTful server-side data sources. |
| $route            | scalajs-angularjs-ui-router    | $route is used for deep-linking URLs to controllers and views (HTML partials). It watches $location.url() and tries to map the path to an existing route definition. |
| $sce              | scalajs-angularjs-core         | $sce is a service that provides Strict Contextual Escaping services to AngularJS. |
| $timeout          | scalajs-angularjs-core         | Angular's wrapper for window.setTimeout. The fn function is wrapped into a try/catch block and delegates any exceptions to $exceptionHandler service. |
| FacebookService   | scalajs-angularjs-facebook     | AngularJS - Facebook service |
| FileUploader      | scalajs-angularjs-nergvh-fileupload | AngularJS File Uploader |
| toaster           | scalajs-angularjs-toaster      | AngularJS Toaster is a customized version of "toastr" non-blocking notification javascript library. |

*NOTE*: The full SBT artifact expression is: "com.github.ldaniels528" %%% "scalajs-angularjs-xxxx" % version 
(e.g. "com.github.ldaniels528" %%% "scalajs-angularjs-toaster" % "0.1.7")


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
module.serviceOf[MarketStatusService]("MarketStatusSvc")

class MarketStatusService($http: Http) extends Service {

  def getMarketStatus(implicit ec: ExecutionContext): Future[MarketStatus] = {
    $http.get[MarketStatus]("/api/tradingClock/status")
  }
  
}

trait MarketStatus extends js.Object {
  var stateChanged: Boolean = js.native
  var active: Boolean = js.native
  var sysTime: Double = js.native
  var delay: Double = js.native
  var start: Double = js.native
  var end: Double = js.native
}
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

Scalajs-Nodejs provides implicit conversions so that you may use `scala.concurrent.duration.FiniteDuration`s with `$timeout`,
`$interval`, and any other services that use time in milliseconds.

```scala
$timeout(() => doSomething(), 5.minutes)
```

#### JSON data as Scala objects

Scalajs-Nodejs allows you to utilize dynamic JavaScript objects or type-safe Scala objects using traits. 
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

However, sometimes we instead want to retrieve the data as a type-safe Scala object. Scalajs-Nodejs makes this as simple as:

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

Scalajs-Nodejs provides implicit conversions that convert a `HttpResponse[T]` into a `Future[T]`, we can also use `for`
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
import org.scalajs.nodejs.util.ScalaJsHelper._

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
import org.scalajs.nodejs.util.ScalaJsHelper._

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
