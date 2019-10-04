package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The assert module provides a simple set of assertion tests that can be used to test invariants. The module is
  * intended for internal use by Node.js, but can be used in application code via require('assert'). However, assert
  * is not a testing framework, and is not intended to be used as a general purpose assertion library.
  *
  * The API for the assert module is Locked. This means that there will be no additions or changes to any of the
  * methods implemented and exposed by the module.
  */
@js.native
trait Assert extends IEventEmitter {

  /**
    * An alias of assert.ok() .
    * @param expression the expression to evaluate
    * @example assert(value[, message])
    */
  def apply(expression: js.Any, message: String = js.native): Unit = js.native

  @deprecated("Use assert.deepStrictEqual() instead.", "stability 0")
  def deepEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * Generally identical to assert.deepEqual() with two exceptions. First, primitive values are compared using the
    * strict equality operator ( === ). Second, object comparisons include a strict equality check of their prototypes.
    * @example assert.deepStrictEqual(actual, expected[, message])
    */
  def deepStrictEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def doesNotReject(asyncFn: js.Function | js.Promise[_],
                    error: js.RegExp | js.Function = js.native,
                    message: String = js.native): Unit = js.native

  /**
    * Asserts that the function block does not throw an error. See assert.throws() for more details.
    * When assert.doesNotThrow() is called, it will immediately call the block function. If an error is thrown
    * and it is the same type as that specified by the error parameter, then an AssertionError is thrown. If the
    * error is of a different type, or if the error parameter is undefined, the error is propagated back to the caller.
    * @example assert.doesNotThrow(block[, error][, message])
    */
  def doesNotThrow(block: js.Function, error: js.RegExp | js.Function = js.native, message: String = js.native): Unit =
    js.native

  /**
    * @see https://nodejs.org/api/assert.html#assert_assert_equal_actual_expected_message
    */
  @deprecated("Use assert.strictEqual() instead.", "stability 0")
  def equal(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * @see https://nodejs.org/api/assert.html#assert_assert_fail_message
    */
  def fail(message: String): Unit = js.native

  /**
    * @see https://nodejs.org/api/assert.html#assert_assert_fail_message
    */
  def fail(message: js.Error): Unit = js.native

  @deprecated("Use assert.fail([message]) or other assert functions instead.", "Node.js v10.0.0")
  def fail(actual: js.Any, expected: js.Any, message: String, operator: String): Unit = js.native

  /**
    * Throws value if value is truthy. This is useful when testing the error argument in callbacks.
    * @example assert.ifError(value)
    */
  def ifError(value: js.Any): Unit = js.native

  @deprecated("Use assert.notDeepStrictEqual() instead.", "stability 0")
  def notDeepEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * Tests for deep strict inequality. Opposite of assert.deepStrictEqual().
    * @example assert.notDeepStrictEqual(actual, expected[, message])
    */
  def notDeepStrictEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  @deprecated("Use assert.notStrictEqual() instead.", "stability 0")
  def notEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * Tests strict inequality as determined by the strict not equal operator ( !== ).
    * @example assert.notStrictEqual(actual, expected[, message])
    */
  def notStrictEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * Tests if value is truthy. It is equivalent to assert.equal(!!value, true, message). If value is not truthy,
    * an AssertionError is thrown with a message property set equal to the value of the message parameter. If the
    * message parameter is undefined, a default error message is assigned.
    */
  def ok(value: js.Any, message: String = js.native): Unit = js.native

  /**
    * Tests strict equality as determined by the strict equality operator ( === ).
    * @example assert.strictEqual(actual, expected[, message])
    */
  def strictEqual(actual: js.Any, expected: js.Any, message: String = js.native): Unit = js.native

  /**
    * If the values are not strictly equal, an AssertionError is thrown with a message property set equal to the value
    * of the message parameter. If the message parameter is undefined, a default error message is assigned.
    * @example assert.throws(block[, error][, message])
    */
  def throws(block: js.Function,
             error: js.RegExp | js.Function | js.Object | Error,
             message: String = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def rejects(asyncFn: js.Function | js.Promise[_],
              error: js.RegExp | js.Function | js.Object | Error = js.native,
              message: String = js.native): Unit = js.native
}

/**
  * Assert Singleton
  */
@js.native
@JSImport("assert", JSImport.Namespace)
object Assert extends Assert {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  val strict: Assert = js.native
}
