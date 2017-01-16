package io.scalajs.npm.should

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * should.js - test framework agnostic BDD-style assertions
  * @version 11.1.2
  * @see http://shouldjs.github.io/
  * @see https://www.npmjs.com/package/should
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Should extends Assertion {

  def apply(value: js.Any): Assertion = js.native

  /**
    * Object with configuration.
    * It contains such properties:
    * checkProtoEql boolean - Affect if .eql will check objects prototypes
    * plusZeroAndMinusZeroEqual boolean - Affect if .eql will treat +0 and -0 as equal
    * Also it can contain options for should-format.
    */
  def config: Config = js.native

  /**
    * Allow to extend given prototype with should property using given name.
    * This getter will unwrap all standard wrappers like Number, Boolean, String.
    *
    * Using should(obj) is the equivalent of using obj.should with known issues (like nulls and method calls etc).
    * To add new assertions, need to use Assertion.add method.
    * @param propertyName the name of property to add. Default is 'should'.
    * @param proto        the prototype to extend with. Default is Object.prototype.
    * @return a descriptor - enough to return all back
    */
  def extend(propertyName: String = js.native, proto: js.Any = js.native): js.Any = js.native

  /**
    * Delete previous extension. If desc missing it will remove default extension.
    * @param desc the descriptor returned from should.extend object
    * @return should function
    */
  def noConflict(desc: String = js.native): this.type = js.native

  /**
    * Simple utility function for a bit more easier should assertion extension
    * @param f So called plugin function. It should accept 2 arguments: should function and Assertion constructor
    */
  def use(f: js.Function): this.type = js.native

}

/**
  * Should Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("should", JSImport.Namespace)
object Should extends Should