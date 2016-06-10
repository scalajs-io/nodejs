MEANS.js
=============
MEANS.js is a Scala.js binding for the MEAN Stack (MongoDB ExpressJS AngularJS NodeJS).
 
## Table of Contents

* <a href="#introduction">Introduction</a>
* <a href="#development">Development</a>
    * <a href="#build_requirements">Build Requirements</a>
    * <a href="#building_sdk">Building the SDK</a>
    * <a href="#running_examples">Building and run examples</a>
    * <a href="#apps_using_means">Developed using MEANS.js</a>
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

The goal of MEANS.js is to be a complete Scala.js binding for the entire MEAN Stack. Why? Because I love NodeJS,
 but I have a love/hate relationship with JavaScript. And many others feel the same way about JavaScript, which is why
 there are so many languages that are designed to improve the experience (CoffeeScript, TypeScript, Scala.js and others). 
 Simply put, MEANS.js let's me have my cake and eat it too! And as such, I've gone to great lengths to bring all the 
 things you love about developing applications on the MEAN Stack to Scala.
 
MEANS.js is componentized; allowing developers to use include only the features they want. If all your application 
requires is a binding for AngularJS, you can use just that. Alternatively, you could use only the Node bindings, or the 
entire MEAN stack.

Currently, there are at least four development use cases for MEANS.js:
 
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
### Developed using MEANS.js
   
The following applications were developed using MEANS.js:

| Application                                                      | Frontend              | Backend            | Description                                                  |
|------------------------------------------------------------------|-----------------------|--------------------|--------------------------------------------------------------|
| [Socialized](https://github.com/ldaniels528/means-js-socialized) | MEANS.js/AngularJS    | MEANS.js/NodeJS    | A Facebook-inspired Social networking web application. |
| [Todo MVC](https://github.com/ldaniels528/means-js-todomvc)      | MEANS.js/AngularJS    | MEANS.js/NodeJS    | A simple Todo example application. |
| [Trifecta](https://github.com/ldaniels528/trifecta)              | MEANS.js/AngularJS    | Play 2.4.x + Scala | Trifecta is a web-based and CLI tool that simplifies inspecting Kafka messages and Zookeeper data. |
 
 
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

| Node Module           | Version | Artifact ID           | Description                                             | Status          |
|-----------------------|---------|-----------------------|---------------------------------------------------------|-----------------|
| assert                | 6.2.1   | means-node-assert     | Provides a simple set of assertion tests that can be used to test invariants. | Stable |
| buffer                | 6.2.1   | means-node-core       | The Buffer class was introduced as part of the Node.js API to make it possible to interact with octet streams in the context of things like TCP streams and file system operations. | Stable |
| cluster               | 6.2.1   | means-node-cluster    | The cluster module allows you to easily create child processes that all share server ports. | Stable |
| crypto                | 6.1.0   | means-node-core       | The crypto module provides cryptographic functionality that includes a set of wrappers for OpenSSL's hash, HMAC, cipher, decipher, sign and verify functions.| Tesing required |
| events                | 6.1.0   | means-node-core       | Node.js Events Interface | Stable |
| fs                    | 6.2.1   | means-node-fs         | File I/O is provided by simple wrappers around standard POSIX functions. | Stable |
| http                  | 6.1.0   | means-node-http       | Node.js HTTP Interface | Stable |
| https                 | 6.1.0   | means-node-https      | Node.js HTTPS Interface | Tesing required |
| net                   | 6.2.1   | means-node-net        | The net module provides you with an asynchronous network wrapper. | Stable |
| os                    | 6.1.0   | means-node-os         | Provides a few basic operating-system related utility functions. | Stable |
| path                  | 6.1.0   | means-node-path       | This module contains utilities for handling and transforming file paths. | Stable |
| readline              | 6.1.0   | means-node-readline   | Readline allows reading of a stream on a line-by-line basis. | Stable |
| repl                  | 6.1.0   | means-node-repl       | The REPL provides a way to interactively run JavaScript and see the results. | Stable |
| stream                | 6.1.0   | means-node-core       | A stream is an abstract interface implemented by various objects in Node.js. | Stable |
| string-decoder        | 6.1.0   | means-node-string-decoder | The string_decoder module provides an API for decoding Buffer objects into strings in a manner that preserves encoded multi-byte UTF-8 and UTF-16 characters. | Stable |
| tty                   | 6.2.1   | means-node-tty        | The tty module provides the tty.ReadStream and tty.WriteStream classes. | Stable |
| url                   | 6.1.0   | means-node-url        | The url module provides utilities for URL resolution and parsing. | Stable |
| util                  | 6.1.0   | means-node-util       | The util module is primarily designed to support the needs of Node.js's internal APIs.| Stable |
| vm                    | 6.2.1   | means-node-vm         | The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.| Stable |
| zlib                  | 6.1.0   | means-node-zlib       | This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes. | Stable |


The following Third Party/OSS NodeJS modules have been implemented thus far:

| Node Module           | Version | Artifact ID           | Description                                             | Status          |
|-----------------------|---------|-----------------------|---------------------------------------------------------|-----------------|
| adal-node             | 0.1.19  | means-node-adal-node  | Windows Azure Active Directory Client Library for node. | Tesing required |
| amqplib               | 0.4.1   | means-node-amqplib    | An AMQP 0-9-1 (e.g., RabbitMQ) library and client. | Tesing required |
| async                 | 1.5.2   | means-node-async      | Higher-order functions and common patterns for asynchronous code. | Tesing required |
| azure                 | 0.10.6  | means-node-azure      | Microsoft Azure Client Library for node. | WIP - Unusable |
| bcrypt                | 0.0.3   | means-node-bcrypt     | A native JS bcrypt library for NodeJS. | Stable |
| body-parser           | 1.15.1  | means-node-body-parser| Body parsing middleware. | Stable |
| cassandra-driver      | 3.0.2   | means-node-datastax-cassandra| DataStax Node.js Driver for Apache Cassandra | Tesing required |
| colors                | 1.1.2   | means-node-colors     | Get colors in your node.js console.| Stable |
| drama                 | 0.1.3   | means-node-drama      | drama is an Actor model implementation for JavaScript and Node.js | Tesing required |
| escape-html           | 1.0.3   | means-node-escape-html| Escape string for use in HTML | Stable |
| express               | 4.13.4  | means-node-express    | Fast, unopinionated, minimalist web framework for Node.js | Stable |
| express-fileupload    | 0.0.5   | means-node-express-fileupload | Simple express file upload middleware that wraps around connect-busboy | Stable |
| express-ws            |2.0.0-rc1| means-node-express-ws | WebSocket endpoints for Express applications | Stable |
| filed                 | 0.1.0   | means-node-filed      | Simplified file library. | Stable |
| jwt-simple            | 0.5.0   | means-node-jwt-simple | JWT(JSON Web Token) encode and decode module | Stable |
| kafka-node            | 0.0.11  | means-node-kafkanode  | A node binding for librdkafka | Tesing required |
| mongodb               | 2.1.18  | means-node-mongodb    | Node.js MongoDB Driver | Stable |
| multer                | 1.1.0   | means-node-multer     | Multer is a node.js middleware for handling multipart/form-data. | Tesing required |
| mysql                 | 2.10.2  | means-node-mysql      | A node.js driver for mysql. | Stable |
| node-zookeeper-client | 0.2.2   | means-node-zookeeper-client | A higher-level ZooKeeper client based on node-zookeeper with support for locking and master election. | Tesing required |
| oppressor             | 0.0.1   | means-node-oppressor  | Streaming http compression response negotiator. | Tesing required |
| request               | 2.72.1  | means-node-request    | Simplified HTTP request client. | Stable |
| splitargs             | 0.0.7   | means-node-elgs-splitargs | Splits strings into tokens by given separator except treating quoted part as a single token. | Stable |
| watch                 | 0.18.0  | means-node-watch      | Utilities for watching file trees. | Stable |
| xml2js                | 0.4.16  | means-node-xml2js     | Simple XML to JavaScript object converter. | Stable |


*NOTE*: The full SBT artifact expression is: "com.github.ldaniels528" %%% "means-node-xxxx" % version 
(e.g. "com.github.ldaniels528" %%% "means-node-express" % "0.1.7")

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

Here's the same example using MEANS.js:

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

MEANS.js exposes Future-based alternatives to most of the asynchronous functions found in MongoDB, Express, Angular and Node. 
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

| Service           | Artifact ID                | Description                      |
|-------------------|----------------------------|----------------------------------|
| $anchorScroll     | means-angular-core         | Anchor Scroll Service. |
| $animate          | means-angular-animate      | The $animate service exposes a series of DOM utility methods that provide support for animation hooks. |
| $cacheFactory     | means-angular-core         | Factory that constructs cache objects and gives access to them. |
| $compile          | means-angular-core         | Compiles an HTML string or DOM into a template and produces a template function, which can then be used to link scope and the template together. |
| $cookies          | means-angular-core         | Provides read/write access to browser's cookies. |
| $cookieStore      | means-angular-core         | Provides a key-value (string-object) storage, that is backed by session cookies. |
| $exceptionHandler | means-angular-core         | Any uncaught exception in angular expressions is delegated to this service. |
| $filter           | means-angular-core         | Selects a subset of items from array and returns it as a new array. |
| $http             | means-angular-core         | The $http service is a core Angular service that facilitates communication with the remote HTTP servers via the browser's XMLHttpRequest object or via JSONP. |
| $injector         | means-angular-core         | $injector is used to retrieve object instances as defined by provider, instantiate types, invoke methods, and load modules. |
| $interval         | means-angular-core         | Angular's wrapper for window.setInterval. The fn function is executed every delay milliseconds. |
| $location         | means-angular-core         | The $location service parses the URL in the browser address bar (based on the window.location) and makes the URL available to your application. |
| $log              | means-angular-core         | Simple service for logging. Default implementation safely writes the message into the browser's console (if present). |
| $modal            | means-angular-ui-bootstrap | Modal Dialogs - Angular UI Bootstrap |
| $parse            | means-angular-core         | Converts Angular expression into a function. |
| $q                | means-angular-core         | A service that helps you run functions asynchronously, and use their return values (or exceptions) when they are done processing. |
| $resource         | means-angular-core         | A factory which creates a resource object that lets you interact with RESTful server-side data sources. |
| $route            | means-angular-ui-router    | $route is used for deep-linking URLs to controllers and views (HTML partials). It watches $location.url() and tries to map the path to an existing route definition. |
| $sce              | means-angular-core         | $sce is a service that provides Strict Contextual Escaping services to AngularJS. |
| $timeout          | means-angular-core         | Angular's wrapper for window.setTimeout. The fn function is wrapped into a try/catch block and delegates any exceptions to $exceptionHandler service. |
| FacebookService   | means-angular-facebook     | AngularJS - Facebook service |
| FileUploader      | means-angular-nergvh-fileupload | AngularJS File Uploader |
| toaster           | means-angular-toaster      | AngularJS Toaster is a customized version of "toastr" non-blocking notification javascript library. |

*NOTE*: The full SBT artifact expression is: "com.github.ldaniels528" %%% "means-angular-xxxx" % version 
(e.g. "com.github.ldaniels528" %%% "means-angular-toaster" % "0.1.7")


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

MEANS.js provides implicit conversions so that you may use `scala.concurrent.duration.FiniteDuration`s with `$timeout`,
`$interval`, and any other services that use time in milliseconds.

```scala
$timeout(() => doSomething(), 5.minutes)
```

#### JSON data as Scala objects

MEANS.js allows you to utilize dynamic JavaScript objects or type-safe Scala objects using traits. 
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

However, sometimes we instead want to retrieve the data as a type-safe Scala object. MEANS.js makes this as simple as:

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

MEANS.js provides implicit conversions that convert a `HttpResponse[T]` into a `Future[T]`, we can also use `for`
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
import com.github.ldaniels528.meansjs.social.facebook.FB

val config = FacebookAppConfig(appId = "[YOUR_APP_KEY_GOES_HERE]", status = true, xfbml = true, version = "v2.5")
FB.init(config)
```

Assuming you're using AngularJS, within your Scala.js application, you define the AngularJS Facebook service:

```scala
module.serviceOf[FacebookService]("Facebook")
```
      
Finally, within your AngularJS controller or service you invoke the Facebook login:   
  
```scala    
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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
import com.github.ldaniels528.meansjs.social.linkedin.IN

var linkedInID: js.UndefOr[String] = js.undefined

// read the authenticated user's profile
IN.API.Profile(js.Array("me")) onComplete {
    case Success(response) =>
        linkedInID = response.values.headOption.flatMap(_.id.toOption).orUndefined
    case Failure(e) =>
        console.error(s"Failed to retrieve LinkedIn profile - ${e.getMessage}")
}
```
