package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js module object
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/modules.html#modules_the_module_object]]
  */
@JSName("module")
@js.native
object Module extends js.Any {

  /**
    * The module.exports object is created by the Module system. Sometimes this is not acceptable;
    * many want their module to be an instance of some class. To do this, assign the desired export
    * object to module.exports. Note that assigning the desired object to exports will simply rebind
    * the local exports variable, which is probably not what you want to do.
    */
  var exports: js.Any = js.native

  /** The fully resolved filename to the module. */
  var filename: String = js.native

  /** The identifier for the module. Typically this is the fully resolved filename. */
  var id: String = js.native

  /** Whether or not the module is done loading, or is in the process of loading. */
  var loaded: Boolean = js.native

  /** The module that first required this one. */
  var parent: js.Any = js.native

  /**
    * The module.require method provides a way to load a module as if require() was called from the original module.
    */
  def require(id: String): js.Any = js.native

}