package com.github.ldaniels528.meansjs.nodejs.vm

import scala.scalajs.js

/**
  * Contextify Script
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ContextifyScript extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * If given a sandbox object, the vm.createContext() method will
    * [prepare that sandbox][#vm_what_does_it_mean_to_contextify_an_object] so that it can be used in calls to
    * vm.runInContext() or script.runInContext(). Inside such scripts, the sandbox object will be the global object,
    * retaining all of its existing properties but also having the built-in objects and functions any standard global
    * object has. Outside of scripts run by the vm module, sandbox will remain unchanged.
    *
    * If sandbox is omitted (or passed explicitly as undefined), a new, empty contextified sandbox object will be returned.
    *
    * The vm.createContext() method is primarily useful for creating a single sandbox that can be used to run multiple
    * scripts. For instance, if emulating a web browser, the method can be used to create a single sandbox representing
    * a window's global object, then run all <script> tags together within the context of that sandbox.
    * @param sandbox the given sandbox
    * @example vm.createContext([sandbox])
    * @since 0.11.7
    */
  def createContext(sandbox: js.Any): ScriptContext = js.native

  /**
    * The vm.runInDebugContext() method compiles and executes code inside the V8 debug context.
    * @param code The JavaScript code to compile and run.
    * @example vm.runInDebugContext(code)
    */
  def runInDebugContext(code: String): js.Any = js.native

  /**
    * Runs the compiled code contained by the vm.Script object within the given contextifiedSandbox and returns the
    * result. Running code does not have access to local scope.
    * @param contextifiedSandbox A contextified object as returned by the vm.createContext() method.
    * @param options             the optional options
    * @example script.runInContext(contextifiedSandbox[, options])
    */
  def runInContext(contextifiedSandbox: ScriptContext, options: ScriptOptions = null): js.Any = js.native

  /**
    * First contextifies the given sandbox, runs the compiled code contained by the vm.Script object within the created
    * sandbox, and returns the result. Running code does not have access to local scope.
    * @param sandbox An object that will be contextified. If undefined, a new object will be created.
    * @param options the optional options
    * @example script.runInNewContext([sandbox][, options])
    */
  def runInNewContext(sandbox: js.Any, options: ScriptOptions = null): js.Any = js.native

  /**
    * Runs the compiled code contained by the vm.Script within the context of the current global object. Running code
    * does not have access to local scope, but does have access to the current global object.
    * @param options the optional options
    * @example script.runInThisContext([options])
    */
  def runInThisContext(options: ScriptOptions = null): ContextifyScript = js.native

}
