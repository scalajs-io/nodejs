MEANS.js
=============
Type-safe Scala.js Bindings for the MEAN Stack (MongoDB ExpressJS AngularJS NodeJS)

## Introduction

The goal of MEANS.js is to be complete set of type-safe Scala.js bindings for the entire MEAN Stack. MEANS.js goes to 
great lengths to make all the things you love about writing Scala on the back-end, to the front-end. To that end, various
refinements have been added to make the transition more seamless.

## Examples

#### Example 1

I've provided a few examples to demonstrate how similar the Scala.js code is to the JavaScript
that it replaces.

The following is a simple Hello World app in Node using JavaScript.

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
    
    app.get("/", (req: Request, res: Response) => {
        res.send("Hello World")
    })
    
    val server = app.listen(8081, connect)
    
    private def connect: js.Function = () => {
        val host = server.address().address
        val port = server.address().port
        
        console.log("Example app listening at http://%s:%s", host, port)
    }
```

#### Example 2

The following is a simple Hello World app in Node using JavaScript.

```javascript

    var http = require("http");
    http.createServer(function(request, response) {
      response.writeHead(200, {"Content-Type": "text/plain"});
      response.write("Hello World");
      response.end();
    }).listen(8888);
```

Here's the same example using MEANS.js + Scala.js:

```scala

  val http = require[Http]("http")
  http.createServer((request: ClientRequest, response: ServerResponse) => {
    response.writeHead(200, js.Dictionary("Content-Type" -> "text/plain"))
    response.write("Hello World")
    response.end()
  }).listen(8888)

```