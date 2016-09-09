package org.scalajs.nodejs.express.csv

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * express-csv provides response csv easily to express.
  * @version 0.6.0
  * @see [[https://www.npmjs.com/package/express-csv]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ExpressCSV extends NodeModule

/**
  * Express-CSV Companion
  * @author lawrence.daniels@gmail.com
  */
object ExpressCSV {

  /**
    * Convenience method for retrieving the 'express' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Express instance
    */
  def apply()(implicit require: NodeRequire) = require[ExpressCSV]("express-csv")

}