package io.scalajs.nodejs
package dns

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js
import org.scalatest.funspec.AsyncFunSpec

/**
  * DNS Tests
  */
class DNSAsyncTest extends AsyncFunSpec {
  private val domain   = "google.com"
  private val resolver = new DNS.promises.Resolver()

  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("DNS") {
    it("supports lookup") {
      val promise = Promise[String]()
      DNS.lookup(
        domain,
        (err, ipAddress) => {
          assert(err === null)
          promise.success(ipAddress)
        }
      )
      promise.future.map { ipAddress =>
        assert(ipAddress.nonEmpty)
      }
    }

    it("supports lookupService:SSH") {
      val promise = Promise[(String, String)]()
      DNS.lookupService(
        "127.0.0.1",
        22,
        (err, hostname, service) => {
          assert(err === null)
          promise.success((hostname, service))
        }
      )
      promise.future.map {
        case (host, service) =>
          assert(host === "localhost")
          assert(service === "ssh")
      }
    }

    it("supports resolve:NS") {
      val promise = Promise[js.Array[String]]()
      DNS.resolve(
        domain,
        "NS",
        (err: DnsError, addresses: ResolveResult) => {
          assert(err === null)
          promise.success(addresses.asInstanceOf[js.Array[String]])
        }
      )
      promise.future.map { addresses =>
        assert(addresses.nonEmpty)
      }
    }
  }

  describe("DNS future extension") {
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
