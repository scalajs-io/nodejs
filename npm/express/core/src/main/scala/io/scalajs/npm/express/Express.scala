package io.scalajs.npm.express

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Fast, unopinionated, minimalist web framework
  * @version 4.14.0
  * @see https://www.npmjs.com/package/express
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Express extends IEventEmitter {

  /**
    * Creates an Express application. The express() function is a top-level function exported by the express module.
    * @example var app = express()
    */
  def apply(): Application = js.native

  /**
    * `bodyParser()` middleware has been deprecated; use BodyParser.json() and BodyParser.urlencoded() as needed
    * @see [[https://github.com/expressjs/body-parser/commit/b7420f8dc5c8b17a277c9e50d72bbaf3086a3900]]
    */
  @deprecated("Use BodyParser.json() and BodyParser.urlencoded() as needed", "4.0")
  def bodyParser(): Router = js.native

  /**
    * Creates a new router object.
    * @example express.Router([options])
    */
  def Router(options: RouterOptions | NodeOptions | js.Any = js.native): Router = js.native

  /**
    * This is the only built-in middleware function in Express. It serves static files and is based on serve-static.
    * The root argument refers to the root directory from which the static assets are to be served. The file to serve
    * will be determined by combining req.url with the provided root directory. When a file is not found, instead of
    * sending a 404 response, this module will instead call next() to move on to the next middleware, allowing for
    * stacking and fall-backs.
    * <p/>The following table describes the properties of the options object.
    * @example express.static(root, [options])
    */
  def static(root: String, options: StaticOptions | NodeOptions | js.Any = js.native): Router = js.native

}

/**
  * Express Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("express", JSImport.Namespace)
object Express extends Express