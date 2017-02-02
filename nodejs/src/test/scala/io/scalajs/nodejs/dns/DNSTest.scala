package io.scalajs.nodejs
package dns

import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * DNS Tests
  * @author lawrence.daniels@gmail.com
  */
class DNSTest extends FunSpec {
  private val domain = "yahoo.com"

  describe("DNS") {

    it("supports lookup") {
      DNS.lookup(domain, (err: DnsError, ipAddress: String) => {
        assert(err == null)
        info(s"lookup - ipAddress: $ipAddress")
      })
    }

    it("supports lookupFuture") {
      DNS.lookupFuture(domain) map { ipAddress =>
        info(s"lookupFuture - ipAddress: $ipAddress")
      }
    }

    it("supports lookupService:SSH") {
      DNS.lookupService(
        "127.0.0.1",
        22,
        (err: DnsError, hostname: String, service: String, family: js.Any) => {
          assert(err == null)
          info(s"lookupService - hostname => $hostname, service => $service, family => $family")
        }
      )
    }

    it("supports lookupServiceFuture:SSH") {
      DNS.lookupServiceFuture("127.0.0.1", 22) map {
        case (hostname, service) =>
          info(s"lookupServiceFuture - hostname: $hostname, service => $service")
      }
    }

    it("supports resolve:NS") {
      DNS.resolve(domain, "NS", (error: DnsError, addresses: js.Array[String]) => {
        assert(error == null)
        info(s"resolveFuture:NS - addresses: ${addresses.mkString(", ")}")
      })
    }

    it("supports resolveFuture:MX") {
      DNS.resolveFuture[js.Array[MX]](domain, RRTYPE_MX) map { response =>
        info(s"resolveFuture:MX - response: $response")
      }
    }

    it("supports resolveFuture:NS") {
      DNS.resolveFuture[js.Array[String]](domain, "NS") map { addresses =>
        info(s"resolveFuture - addresses: ${addresses.mkString(", ")}")
      }
    }

    it("supports resolveFuture:SOA") {
      DNS.resolveFuture[SOA](domain, RRTYPE_SOA) foreach { response =>
        info(s"resolveFuture:SOA: response: $response")
      }
    }

    it("supports reverseFuture") {
      DNS.reverseFuture("216.58.218.142") map { hostnames =>
        info(s"reverseFuture - hostname: ${hostnames.mkString(", ")}")
      }
    }

  }

}
