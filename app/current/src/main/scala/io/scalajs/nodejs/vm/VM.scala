package io.scalajs.nodejs.vm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{DataView, Uint8Array}
import scala.scalajs.js.|

/**
  * The vm module provides APIs for compiling and running code within V8 Virtual Machine contexts.
  * @see https://nodejs.org/api/vm.html
  */
@js.native
trait VM extends js.Object {
  def compileFunction(code: String,
                      params: js.Array[String],
                      options: CompileFunctionOptions = js.native): js.Function = js.native
  def compileFunction(code: String): js.Function                                = js.native

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
  def createContext(sandbox: js.Object, options: CreateContextOptions = js.native): ScriptContext = js.native
  def createContext(): ScriptContext                                                              = js.native

  /**
    * Returns true if the given sandbox object has been contextified using vm.createContext().
    * @param sandbox the sandbox
    * @return true if the given sandbox object has been contextified using vm.createContext().
    */
  def isContext(sandbox: js.Object): Boolean = js.native

  /**
    * Runs the compiled code contained by the vm.Script object within the given contextifiedSandbox and returns the
    * result. Running code does not have access to local scope.
    * @param code                The JavaScript code to compile and run.
    * @param contextifiedSandbox A contextified object as returned by the vm.createContext() method.
    * @param options             the optional options
    * @example script.runInContext(contextifiedSandbox[, options])
    */
  def runInContext(code: String,
                   contextifiedSandbox: ScriptContext,
                   options: VMRunInContextOptions = js.native): js.Any = js.native

  /**
    * First contextifies the given sandbox, runs the compiled code contained by the vm.Script object within the created
    * sandbox, and returns the result. Running code does not have access to local scope.
    * @param code    The JavaScript code to compile and run.
    * @param sandbox An object that will be contextified. If undefined, a new object will be created.
    * @param options the optional options
    * @example vm.runInNewContext(code[, sandbox][, options])
    */
  def runInNewContext(code: String, sandbox: js.Any, options: VMRunInNewContextOptions = js.native): js.Any =
    js.native

  /**
    * Runs the compiled code contained by the vm.Script within the context of the current global object. Running code
    * does not have access to local scope, but does have access to the current global object.
    * @param code    The JavaScript code to compile and run.
    * @param options the optional options
    * @example script.runInThisContext([options])
    */
  def runInThisContext(code: String, options: VMRunInContextOptions = js.native): Script = js.native
}

/**
  * Virtual Machine Singleton
  */
@js.native
@JSImport("vm", JSImport.Namespace)
object VM extends VM

class CompileFunctionOptions(
    var filename: js.UndefOr[String] = js.undefined,
    var lineOffset: js.UndefOr[Int] = js.undefined,
    var columnOffset: js.UndefOr[Int] = js.undefined,
    var cachedData: js.UndefOr[Uint8Array | DataView] = js.undefined,
    @deprecated("Use script.createCachedData", "Node.js v10")
    var produceCachedData: js.UndefOr[Boolean] = js.undefined,
    var parsingContext: js.UndefOr[js.Object] = js.undefined,
    var contextExtensions: js.UndefOr[js.Array[js.Object]] = js.undefined
) extends js.Object

class CreateContextOptions(
    var name: js.UndefOr[String] = js.undefined,
    var origin: js.UndefOr[String] = js.undefined,
    var codeGeneration: js.UndefOr[CodeGeneration] = js.undefined
) extends js.Object

class VMRunInNewContextOptions(
    var filename: js.UndefOr[String] = js.undefined,
    var lineOffset: js.UndefOr[Int] = js.undefined,
    var columnOffset: js.UndefOr[Int] = js.undefined,
    var displayErrors: js.UndefOr[Boolean] = js.undefined,
    var timeout: js.UndefOr[Int] = js.undefined,
    var breakOnSigint: js.UndefOr[Boolean] = js.undefined,
    var contextName: js.UndefOr[String] = js.undefined,
    var contextOrigin: js.UndefOr[String] = js.undefined,
    var contextCodeGeneration: js.UndefOr[CodeGeneration] = js.undefined,
    var cachedData: js.UndefOr[Uint8Array | DataView] = js.undefined,
    var produceCachedData: js.UndefOr[Boolean] = js.undefined,
    var importModuleDynamically: js.UndefOr[js.Function] = js.undefined
) extends js.Object

class VMRunInContextOptions(var filename: js.UndefOr[String] = js.undefined,
                            var lineOffset: js.UndefOr[Int] = js.undefined,
                            var columnOffset: js.UndefOr[Int] = js.undefined,
                            var displayErrors: js.UndefOr[Boolean] = js.undefined,
                            var timeout: js.UndefOr[Int] = js.undefined,
                            var breakOnSigint: js.UndefOr[Boolean] = js.undefined,
                            var cachedData: js.UndefOr[Uint8Array | DataView] = js.undefined,
                            var produceCachedData: js.UndefOr[Boolean] = js.undefined,
                            var importModuleDynamically: js.UndefOr[js.Function] = js.undefined)
    extends js.Object
