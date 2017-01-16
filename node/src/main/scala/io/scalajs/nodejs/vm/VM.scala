package io.scalajs.nodejs.vm

import io.scalajs.nodejs.NodeOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.
  * @version 7.4.0
  * @see https://nodejs.org/api/vm.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait VM extends js.Object {

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
    * Creates a new script
    * @param code    The JavaScript code to compile.
    * @param options the optional options
    * @example vm.createScript(code[, options])
    */
  def createScript(code: String, options: ScriptOptions | NodeOptions = js.native): ContextifyScript = js.native

  /**
    * The vm.runInDebugContext() method compiles and executes code inside the V8 debug context.
    * @param code The JavaScript code to compile and run.
    * @example vm.runInDebugContext(code)
    */
  def runInDebugContext(code: String): js.Any = js.native

  /**
    * Runs the compiled code contained by the vm.Script object within the given contextifiedSandbox and returns the
    * result. Running code does not have access to local scope.
    * @param code                The JavaScript code to compile and run.
    * @param contextifiedSandbox A contextified object as returned by the vm.createContext() method.
    * @param options             the optional options
    * @example script.runInContext(contextifiedSandbox[, options])
    */
  def runInContext(code: String, contextifiedSandbox: ScriptContext, options: ContextOptions | NodeOptions = js.native): js.Any = js.native

  /**
    * First contextifies the given sandbox, runs the compiled code contained by the vm.Script object within the created
    * sandbox, and returns the result. Running code does not have access to local scope.
    * @param code    The JavaScript code to compile and run.
    * @param sandbox An object that will be contextified. If undefined, a new object will be created.
    * @param options the optional options
    * @example vm.runInNewContext(code[, sandbox][, options])
    */
  def runInNewContext(code: String, sandbox: js.Any, options: ContextOptions | NodeOptions = js.native): js.Any = js.native

  /**
    * Runs the compiled code contained by the vm.Script within the context of the current global object. Running code
    * does not have access to local scope, but does have access to the current global object.
    * @param code    The JavaScript code to compile and run.
    * @param options the optional options
    * @example script.runInThisContext([options])
    */
  def runInThisContext(code: String, options: ContextOptions | NodeOptions = js.native): ContextifyScript = js.native

  /**
    * Returns true if the given sandbox object has been contextified using vm.createContext().
    * @param sandbox the sandbox
    * @return true if the given sandbox object has been contextified using vm.createContext().
    */
  def isContext(sandbox: js.Any): Boolean = js.native

}

/**
  * Virtual Machine Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("vm", JSImport.Namespace)
object VM extends VM