package com.github.ldaniels528.meansjs.nodejs.core

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * The assert module provides a simple set of assertion tests that can be used to test invariants. The module is
  * intended for internal use by Node.js, but can be used in application code via require('assert'). However, assert
  * is not a testing framework, and is not intended to be used as a general purpose assertion library.
  *
  * The API for the assert module is Locked. This means that there will be no additions or changes to any of the
  * methods implemented and exposed by the module.
  * @version 6.2.1
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Assert extends NodeModule with EventEmitter {

  /**
    * An alias of assert.ok() .
    * @param expression the expression to evaluate
    * @example assert(value[, message])
    */
  def apply(expression: js.Any, message: String = null): Unit = js.native

  /**
    * Tests for deep equality between the actual and expected parameters. Primitive values are compared with the equal
    * comparison operator ( == ). Only enumerable "own" properties are considered. The deepEqual() implementation does
    * not test object prototypes, attached symbols, or non-enumerable properties. This can lead to some potentially
    * surprising results.
    * @example assert.deepEqual(actual, expected[, message])
    */
  def deepEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests for deep equality between the actual and expected parameters. Primitive values are compared with the equal
    * comparison operator ( == ). Only enumerable "own" properties are considered. The deepEqual() implementation does
    * not test object prototypes, attached symbols, or non-enumerable properties. This can lead to some potentially
    * surprising results.
    * @example assert.deepEqual(actual, expected[, message])
    */
  def deepEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Generally identical to assert.deepEqual() with two exceptions. First, primitive values are compared using the
    * strict equality operator ( === ). Second, object comparisons include a strict equality check of their prototypes.
    * @example assert.deepStrictEqual(actual, expected[, message])
    */
  def deepStrictEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Asserts that the function block does not throw an error. See assert.throws() for more details.
    * When assert.doesNotThrow() is called, it will immediately call the block function. If an error is thrown
    * and it is the same type as that specified by the error parameter, then an AssertionError is thrown. If the
    * error is of a different type, or if the error parameter is undefined, the error is propagated back to the caller.
    * @example assert.doesNotThrow(block[, error][, message])
    */
  def doesNotThrow(block: js.Function, error: js.Any, message: String): Unit = js.native

  /**
    * Asserts that the function block does not throw an error. See assert.throws() for more details.
    * When assert.doesNotThrow() is called, it will immediately call the block function. If an error is thrown
    * and it is the same type as that specified by the error parameter, then an AssertionError is thrown. If the
    * error is of a different type, or if the error parameter is undefined, the error is propagated back to the caller.
    * @example assert.doesNotThrow(block[, error][, message])
    */
  def doesNotThrow(block: js.Function, message: String): Unit = js.native

  /**
    * Asserts that the function block does not throw an error. See assert.throws() for more details.
    * When assert.doesNotThrow() is called, it will immediately call the block function. If an error is thrown
    * and it is the same type as that specified by the error parameter, then an AssertionError is thrown. If the
    * error is of a different type, or if the error parameter is undefined, the error is propagated back to the caller.
    * @example assert.doesNotThrow(block[, error][, message])
    */
  def doesNotThrow(block: js.Function, error: js.Any): Unit = js.native

  /**
    * Tests shallow, coercive equality between the actual and expected parameters using the equal comparison operator ( == ).
    * @example assert.equal(actual, expected[, message])
    */
  def equal(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests shallow, coercive equality between the actual and expected parameters using the equal comparison operator ( == ).
    * @example assert.equal(actual, expected[, message])
    */
  def equal(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Throws an AssertionError. If message is falsy, the error message is set as the values of actual and expected
    * separated by the provided operator. Otherwise, the error message is the value of message.
    * @example assert.fail(actual, expected, message, operator)
    */
  def fail(actual: js.Any, expected: js.Any, message: String, operator: String): Unit = js.native

  /**
    * Throws value if value is truthy. This is useful when testing the error argument in callbacks.
    * @example assert.ifError(value)
    */
  def ifError(value: js.Any): Unit = js.native

  /**
    * Tests for any deep inequality. Opposite of assert.deepEqual().
    * @example assert.notDeepEqual(actual, expected[, message])
    */
  def notDeepEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests for any deep inequality. Opposite of assert.deepEqual().
    * @example assert.notDeepEqual(actual, expected[, message])
    */
  def notDeepEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Tests for deep strict inequality. Opposite of assert.deepStrictEqual().
    * @example assert.notDeepStrictEqual(actual, expected[, message])
    */
  def notDeepStrictEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests for deep strict inequality. Opposite of assert.deepStrictEqual().
    * @example assert.notDeepStrictEqual(actual, expected[, message])
    */
  def notDeepStrictEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Tests shallow, coercive inequality with the not equal comparison operator ( != ).
    * @example assert.notEqual(actual, expected[, message])
    */
  def notEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests shallow, coercive inequality with the not equal comparison operator ( != ).
    * @example assert.notEqual(actual, expected[, message])
    */
  def notEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Tests strict inequality as determined by the strict not equal operator ( !== ).
    * @example assert.notStrictEqual(actual, expected[, message])
    */
  def notStrictEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests strict inequality as determined by the strict not equal operator ( !== ).
    * @example assert.notStrictEqual(actual, expected[, message])
    */
  def notStrictEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * Tests if value is truthy. It is equivalent to assert.equal(!!value, true, message). If value is not truthy,
    * an AssertionError is thrown with a message property set equal to the value of the message parameter. If the
    * message parameter is undefined, a default error message is assigned.
    */
  def ok(value: js.Any): Unit = js.native

  /**
    * Tests if value is truthy. It is equivalent to assert.equal(!!value, true, message). If value is not truthy,
    * an AssertionError is thrown with a message property set equal to the value of the message parameter. If the
    * message parameter is undefined, a default error message is assigned.
    */
  def ok(value: js.Any, message: String): Unit = js.native

  /**
    * Tests strict equality as determined by the strict equality operator ( === ).
    * @example assert.strictEqual(actual, expected[, message])
    */
  def strictEqual(actual: js.Any, expected: js.Any, message: String): Unit = js.native

  /**
    * Tests strict equality as determined by the strict equality operator ( === ).
    * @example assert.strictEqual(actual, expected[, message])
    */
  def strictEqual(actual: js.Any, expected: js.Any): Unit = js.native

  /**
    * If the values are not strictly equal, an AssertionError is thrown with a message property set equal to the value
    * of the message parameter. If the message parameter is undefined, a default error message is assigned.
    * @example assert.throws(block[, error][, message])
    */
  def throws(block: js.Function, error: js.Any, message: String): Unit = js.native

}

/**
  * Assert Companion
  * @author lawrence.daniels@gmail.com
  */
object Assert {

  /**
    * Convenience method for retrieving the Assert module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Assert instance
    */
  def apply()(implicit require: NodeRequire) = require[Assert]("assert")

}