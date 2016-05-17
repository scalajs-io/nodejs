package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * In each module, the module free variable is a reference to the object representing the current module.
  * For convenience, module.exports is also accessible via the exports module-global. module isn't actually
  * a global but rather local to each module.
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/modules.html#modules_the_module_object]]
  */
@js.native
trait Module extends js.Object {

  /**
    * The module objects required by this one.
    * @example module.children
    */
  var children: js.Array[Module] = js.native

  /**
    * The module.exports object is created by the Module system. Sometimes this is not acceptable;
    * many want their module to be an instance of some class. To do this, assign the desired export
    * object to module.exports. Note that assigning the desired object to exports will simply rebind
    * the local exports variable, which is probably not what you want to do.
    * @example module.exports
    */
  var exports: js.Dictionary[js.Any] = js.native

  /**
    * The fully resolved filename to the module.
    * @example module.filename
    */
  var filename: String = js.native

  /**
    * The identifier for the module. Typically this is the fully resolved filename.
    * @example module.id
    */
  var id: String = js.native

  /**
    * Whether or not the module is done loading, or is in the process of loading.
    * @example module.loaded
    */
  var loaded: Boolean = js.native

  /**
    * The module that first required this one.
    * @example module.parent
    */
  var parent: js.Any = js.native

  /**
    * The module.require method provides a way to load a module as if require() was called from the original module.
    * <p/><b>Note</b> that in order to do this, you must get a reference to the module object. Since require() returns the
    * module.exports, and the module is typically only available within a specific module's code, it must be
    * explicitly exported in order to be used.
    */
  def require(id: String): js.Any = js.native

}