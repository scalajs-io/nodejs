package io.scalajs.npm.should

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
trait Assertion extends js.Object {

  def a: ShouldNoun = js.native

  /**
    * Way to extend Assertion function. It uses some logic
    * to define only positive assertions and itself rule with negative assertion.All actions happen in subcontext
    * and this method take care about negation.
    * Potentially we can add some more modifiers that does not depends from state of assertion.
    * @param name the name of getter
    * @param func the optional function to call
    */
  def add(name: String, func: js.Function = js.native): this.type = js.native

  /**
    * Add chaining getter to Assertion like .a, .which etc
    * @param name   the name of getter
    * @param onCall the optional function to call
    */
  def addChain(name: String, onCall: js.Function = js.native): this.type = js.native

  /**
    * Create alias for some Assertion property
    * @param from the name of to map
    * @param to   the name of alias
    */
  def alias(from: String, to: String): this.type = js.native

  def and: this.type = js.native

  /**
    * Base method for assertions.Before calling this method need to fill Assertion#params object.
    * This method usually called from other assertion methods.
    * Assertion#params can contain such properties:
    * <ul>
    * <li>operator - required string containing description of this assertion</li>
    * <li>obj - optional replacement for this.obj, it useful if you prepare more clear object then given</li>
    * <li>message - if this property filled with string any others will be ignored and this one used as assertion message</li>
    * <li>expected - any object used when you need to assert relation between given object and expected. Like given == expected (== is a relation)</li>
    * <li>details - additional string with details to generated message</li>
    * </ul>
    * @param expr the assertion expression
    */
  def assert(expr: js.Any): this.type = js.native

  def be: this.type = js.native

  /**
    * Node.js standard assert.deepEqual.
    * But uses should.js .eql implementation instead of Node.js own deepEqual.
    * @param actual   the actual value
    * @param expected the expected value
    * @param message  the assertion failure message
    */
  def deepEqual(actual: js.Any, expected: js.Any, message: String = js.native): this.type = js.native

  /**
    * Node.js standard assert.doesNotThrow.
    * @param block   the function block
    * @param message the assertion failure message
    */
  def doesNotThrow(block: js.Function, message: String = js.native): this.type = js.native

  /**
    * Deep object equality comparison. For full spec see should-equal tests.
    * @param value   the expected value
    * @param message the assertion failure message
    */
  def eql(value: js.Any, message: String = js.native): this.type = js.native

  /**
    * Node.js standard assert.equal.
    * @param actual   the actual value
    * @param expected the expected value
    * @param message  the assertion failure message
    */
  def equal(actual: js.Any, expected: js.Any, message: String): this.type = js.native

  /**
    * Node.js standard assert.equal.
    * @param actual   the actual value
    * @param expected the expected value
    */
  def equal(actual: js.Any, expected: js.Any): this.type = js.native

  /**
    * Node.js standard assert.equal.
    * @param expected the expected value
    */
  def equal(expected: js.Any): this.type = js.native

  /**
    * Asserts given object is empty. For strings, arrays and arguments it checks .length property, for objects it checks keys.
    */
  def empty(): this.type = js.native

  /**
    * Asserts given object has enumerable property with optionally value. On success it change given object to be value of property.
    * @param name  the name of property
    * @param value the optional property value to check
    */
  def enumerable(name: String, value: js.Any): this.type = js.native

  /**
    * Asserts given object has enumerable properties
    * @param names the names of property
    */
  def enumerables(names: js.Any): this.type = js.native

  def exactly(value: js.Any): this.type = js.native

  def exist(value: js.Any): this.type = js.native

  /**
    * Shortcut for Assertion#assert(false).
    */
  def fail(): Unit = js.native

  def have: this.type = js.native

  def not: this.type = js.native

  def ok(): this.type = js.native

  def properties(names: js.Any): Assertion = js.native

  def property(name: String): Assertion = js.native

  def property(name: String, value: js.Any): Assertion = js.native

  /**
    * Asserts given object has nested property in depth by path. On success it change given object to be value of final property.
    * @param properties the properties path to search
    */
  def propertyByPath(properties: String | js.Array[String] | js.Any*): Assertion = js.native

  def `with`: ShouldChecks = js.native

}