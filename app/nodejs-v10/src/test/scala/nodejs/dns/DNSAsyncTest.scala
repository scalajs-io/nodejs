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
  private val resolver = new DNS.promises.Resolver()

  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("PromisesResolver") {
    it("supports resolveFuture:MX") {
      resolver.resolve(domain, RRTYPE_MX).toFuture map { response =>
        val result = response.asInstanceOf[js.Array[MX]]
        assert(result(0).priority > 0 && result(0).exchange.nonEmpty)
      }
    }

    it("supports resolveFuture:NS") {
      resolver.resolve(domain, RRTYPE_NS).toFuture map { response =>
        val result = response.asInstanceOf[js.Array[String]]
        assert(result(0).nonEmpty)
      }
    }

    it("supports resolveFuture:SOA") {
      resolver.resolve(domain, RRTYPE_SOA).toFuture map { response =>
        val result = response.asInstanceOf[SOA]
        assert(result.expire > 0 && result.hostmaster.nonEmpty)
      }
    }

    it("supports reverseFuture") {
      resolver.reverse("216.58.218.142").toFuture map { hostnames =>
        assert(hostnames.nonEmpty && hostnames(0).nonEmpty)
      }
    }
  }
}
