package io.scalajs.nodejs
package dns

import org.scalatest.AsyncFunSpec

import scala.concurrent.ExecutionContext
import scala.scalajs.js

/**
  * DNS Tests
  */
class DNSAsyncTest extends AsyncFunSpec {
  private val domain                     = "google.com"
  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("DNS") {
    it("supports lookupFuture") {
      DNS.lookupFuture(domain) map {
        case (ipAddress, ttl) =>
          assert(ttl > 0 && ipAddress.nonEmpty)
      }
    }

    it("supports lookupServiceFuture:SSH") {
      DNS.lookupServiceFuture("127.0.0.1", 22) map {
        case (hostname, service) =>
          assert(hostname.nonEmpty && service.nonEmpty)
      }
    }

    it("supports resolveFuture:MX") {
      DNS.resolveFuture(domain, RRTYPE_MX) map { response =>
        val result = response.asInstanceOf[js.Array[MX]]
        assert(result(0).priority > 0 && result(0).exchange.nonEmpty)
      }
    }

    it("supports resolveFuture:NS") {
      DNS.resolveFuture(domain, RRTYPE_NS) map { response =>
        val result = response.asInstanceOf[js.Array[String]]
        assert(result(0).nonEmpty)
      }
    }

    it("supports resolveFuture:SOA") {
      DNS.resolveFuture(domain, RRTYPE_SOA) map { response =>
        val result = response.asInstanceOf[SOA]
        assert(result.expire > 0 && result.hostmaster.nonEmpty)
      }
    }

    it("supports reverseFuture") {
      DNS.reverseFuture("216.58.218.142") map { hostnames =>
        assert(hostnames.nonEmpty && hostnames(0).nonEmpty)
      }
    }
  }
}
