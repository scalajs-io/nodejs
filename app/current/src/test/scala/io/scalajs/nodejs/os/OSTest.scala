package io.scalajs.nodejs.os

import org.scalatest.funsuite.AnyFunSuite

class OSTest extends AnyFunSuite {
  test("constants") {
    assert(OS.constants.dlopen.RTLD_LOCAL.isInstanceOf[Int])
    assert(OS.constants.errno.E2BIG.isInstanceOf[Int])
    assert(OS.constants.priority.PRIORITY_HIGHEST.isInstanceOf[Int])
    assert(OS.constants.signals.SIGABRT.isInstanceOf[Int])
    assert(OS.constants.UV_UDP_REUSEADDR.isInstanceOf[Int])
  }
}
