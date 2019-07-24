package io.scalajs.nodejs.util

import io.scalajs.nodejs.fs.Fs
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

/**
  * Util Tests
  * @author lawrence.daniels@gmail.com
  */
class UtilTest extends AnyFunSpec {

  describe("Util") {

    it("supports callbackify(promise)") {
      val callback = Util.callbackify(Fs.promises.stat("."))
      Util.inspect(callback)
    }

    it("supports promisify(function)") {
      val promise = Util.promisify(Fs.stat _)
      Util.inspect(promise("."))
    }

    it("supports isPrimitive(5)") {
      assert(Util.isPrimitive(5)) // Returns: true
    }

    it("supports isPrimitive(\"foo\")") {
      assert(Util.isPrimitive("foo")) // Returns: true
    }

    it("supports isPrimitive(false)") {
      assert(Util.isPrimitive(false)) // Returns: true
    }

    it("supports isPrimitive(null)") {
      assert(Util.isPrimitive(null)) // Returns: true
    }

    it("supports isPrimitive(undefined)") {
      assert(Util.isPrimitive(js.undefined)) // Returns: true
    }

    it("supports isPrimitive({})") {
      assert(!Util.isPrimitive(new js.Object())) // Returns: false
    }

    it("supports isPrimitive(function() {})") {
      assert(!Util.isPrimitive(() => {})) // Returns: false
    }

    it("supports isPrimitive(/^$/)") {
      assert(!Util.isPrimitive(js.RegExp("/^$/"))) // Returns: false
    }

    it("supports isPrimitive(new Date())") {
      assert(!Util.isPrimitive(new js.Date())) // Returns: false
    }

  }

}
