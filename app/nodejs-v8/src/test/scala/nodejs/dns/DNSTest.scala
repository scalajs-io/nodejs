package io.scalajs.nodejs
package dns

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * DNS Tests
  */
class DNSTest extends FunSpec {
  private val domain = "google.com"

  describe("DNS") {

    it("supports lookup") {
      DNS.lookup(domain, (err, ipAddress) => {
        assert(err === null)
        info(s"lookup - ipAddress: $ipAddress")
      })
    }

    it("supports lookupService:SSH") {
      DNS.lookupService("127.0.0.1", 22, (err, hostname, service) => {
        assert(err === null)
        assert(hostname.nonEmpty)
        assert(service.nonEmpty)
      })
    }

    it("supports resolve:NS") {
      DNS.resolve(
        domain,
        "NS",
        (err: DnsError, addresses: ResolveResult) => {
          assert(err === null)
          assert(addresses.asInstanceOf[js.Array[String]].nonEmpty)
        }
      )
    }
  }
}
