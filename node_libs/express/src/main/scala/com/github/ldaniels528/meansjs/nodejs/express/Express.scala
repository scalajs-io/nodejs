package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * NodeJS Express module
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/express
  * @version 4.13.4
  */
@js.native
trait Express extends NodeModule with EventEmitter {

  /**
    * Creates an Express application. The express() function is a top-level function exported by the express module.
    * @example var app = express()
    */
  def apply(): Application = js.native

  /**
    * `bodyParser()` middleware has been deprecated; use BodyParser.json() and BodyParser.urlencoded() as needed
    * @see [[https://github.com/expressjs/body-parser/commit/b7420f8dc5c8b17a277c9e50d72bbaf3086a3900]]
    */
  @deprecated("Use BodyParser.json() and BodyParser.urlencoded() as needed", "4.x")
  def bodyParser(): Router = js.native

  /**
    * Creates a new router object.
    * @example express.Router([options])
    */
  def Router(options: RouterOptions): Router = js.native

  /**
    * Creates a new router object.
    * @example var router = express.Router([options])
    */
  def Router(): Router = js.native

  /**
    * This is the only built-in middleware function in Express. It serves static files and is based on serve-static.
    * The root argument refers to the root directory from which the static assets are to be served. The file to serve
    * will be determined by combining req.url with the provided root directory. When a file is not found, instead of
    * sending a 404 response, this module will instead call next() to move on to the next middleware, allowing for
    * stacking and fall-backs.
    * <p/>The following table describes the properties of the options object.
    * @example express.static(root, [options])
    */
  def static(root: String, options: StaticOptions): Router = js.native

  /**
    * This is the only built-in middleware function in Express. It serves static files and is based on serve-static.
    * The root argument refers to the root directory from which the static assets are to be served. The file to serve
    * will be determined by combining req.url with the provided root directory. When a file is not found, instead of
    * sending a 404 response, this module will instead call next() to move on to the next middleware, allowing for
    * stacking and fall-backs.
    * <p/>The following table describes the properties of the options object.
    * @example express.static(root, [options])
    */
  def static(root: String): Router = js.native

}

/**
  * Express Companion
  * @author lawrence.daniels@gmail.com
  */
object Express {

  /**
    * Convenience method for retrieving the 'express' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Express instance
    */
  def apply()(implicit require: NodeRequire) = require[Express]("express")

}