package io.scalajs.nodejs.dns

import org.scalatest.funsuite.AnyFunSuite

class DNSTest extends AnyFunSuite {
  test("getattrinfo codes") {
    assert(DNS.ADDRCONFIG.isInstanceOf[Int])
    assert(DNS.V4MAPPED.isInstanceOf[Int])
  }
}
