package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.nodejs.bodyparser.BodyParser
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Express Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Express extends js.Object {

  /**
    * Creates an Express application. The express() function is a top-level function exported by the express module.
    * @example var app = express()
    */
  def apply(): Application = js.native

  /**
    * `bodyParser()` middleware has been deprecated; use [[BodyParser.json()]] and [[BodyParser.urlencoded()]] as needed
    * @see [[https://github.com/expressjs/body-parser/commit/b7420f8dc5c8b17a277c9e50d72bbaf3086a3900]]
    */
  @deprecated("Use .json() and .urlencoded() as needed", "4.x")
  def bodyParser(): Router = js.native

  /**
    * Creates a new router object.
    * @example express.Router([options])
    */
  def Router(options: Express.RouterOptions): Router = js.native

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
  def static(root: String, options: Express.StaticOptions): Router = js.native

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
    * Router Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait RouterOptions extends js.Object {
    var caseSensitive: js.UndefOr[Boolean]
    var mergeParams: js.UndefOr[Boolean]
    var strict: js.UndefOr[Boolean]
  }

  /**
    * Router Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object RouterOptions {

    def apply(caseSensitive: js.UndefOr[Boolean] = js.undefined,
              mergeParams: js.UndefOr[Boolean] = js.undefined,
              strict: js.UndefOr[Boolean] = js.undefined) = {
      val options = makeNew[RouterOptions]
      options.caseSensitive = caseSensitive
      options.mergeParams = mergeParams
      options.strict = strict
      options
    }

  }

  /**
    * Static Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait StaticOptions extends js.Object {
    var dotfiles: js.UndefOr[String]
    var etag: js.UndefOr[Boolean]
    var extensions: js.UndefOr[Boolean]
    var fallthrough: js.UndefOr[Boolean]
    var index: js.UndefOr[js.Any]
    var lastModified: js.UndefOr[Boolean]
    var maxAge: js.UndefOr[Double]
    var redirect: js.UndefOr[Boolean]
    var setHeaders: js.UndefOr[js.Function]
  }

  /**
    * Static Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object StaticOptions {

    def apply(dotfiles: js.UndefOr[String] = js.undefined,
              etag: js.UndefOr[Boolean] = js.undefined,
              extensions: js.UndefOr[Boolean] = js.undefined,
              fallthrough: js.UndefOr[Boolean] = js.undefined,
              index: js.UndefOr[js.Any] = js.undefined,
              lastModified: js.UndefOr[Boolean] = js.undefined,
              maxAge: js.UndefOr[Double] = js.undefined,
              redirect: js.UndefOr[Boolean] = js.undefined,
              setHeaders: js.UndefOr[js.Function] = js.undefined) = {
      val options = makeNew[StaticOptions]
      options.dotfiles = dotfiles
      options.etag = etag
      options.extensions = extensions
      options.fallthrough = fallthrough
      options.lastModified = lastModified
      options.maxAge = maxAge
      options.redirect = redirect
      options.setHeaders = setHeaders
      options
    }

  }

}