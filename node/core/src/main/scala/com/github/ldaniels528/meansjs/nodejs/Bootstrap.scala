package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * NodeJS Bootstrap object for ScalaJS
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Bootstrap extends js.Object {

  /** The name of the directory that the currently executing script resides in. */
  val __dirname: String = js.native

  /**
    * The filename of the code being executed. This is the resolved absolute path of this code file. For a main program
    * this is not necessarily the same filename used in the command line. The value inside a module is the path to that
    * module file.
    */
  val __filename: String = js.native

  /**
    * A reference to the module.exports that is shorter to type. See module system documentation for details on when
    * to use exports and when to use module.exports.
    *
    * exports isn't actually a global but rather local to each module.
    */
  val exports: js.Object = js.native

  /**
    * A reference to the current module. In particular module.exports is used for defining what a module exports and
    * makes available through require().
    *
    * module isn't actually a global but rather local to each module.
    */
  val module: Module = js.native

  /**
    * To require modules. See the Modules section. require isn't actually a global but rather local to each module.
    */
  val require: Require = js.native

}
