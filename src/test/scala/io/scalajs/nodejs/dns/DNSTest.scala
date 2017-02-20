package io.scalajs.nodejs
package dns

import io.scalajs.util.JSONHelper._
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
      DNS.lookup(domain, (err, ipAddress) => {
        Assert.equal(err, null, err.toJson)
        info(s"lookup - ipAddress: $ipAddress")
      })
    }

    it("supports lookupAsync") {
      DNS.lookupAsync(domain).future map { ipAddress =>
        info(s"lookupAsync - ipAddress: $ipAddress")
      }
    }

    it("supports lookupService:SSH") {
      DNS.lookupService("127.0.0.1", 22, (err, hostname, service) => {
        Assert.equal(err, null, err.toJson)
        info(s"lookupService - hostname => $hostname, service => $service")
      })
    }

    it("supports lookupServiceAsync:SSH") {
      DNS.lookupServiceAsync("127.0.0.1", 22).future map { case (hostname, service) =>
        info(s"lookupServiceAsync - hostname: $hostname, service => $service")
      }
    }

    it("supports resolve:NS") {
      DNS.resolve(domain, "NS", (err: DnsError, addresses: js.Array[String]) => {
        Assert.equal(err, null, err.toJson)
        info(s"resolve:NS - addresses: ${addresses.mkString(", ")}")
      })
    }

    it("supports resolveAsync:MX") {
      DNS.resolveAsync[js.Array[MX]](domain, RRTYPE_MX).future map { response =>
        info(s"resolveAsync:MX - response: ${response.toJson}")
      }
    }

    it("supports resolveAsync:NS") {
      DNS.resolveAsync[js.Array[String]](domain, "NS").future map { addresses =>
        info(s"resolveAsync - addresses: ${addresses.mkString(", ")}")
      }
    }

    it("supports resolveAsync:SOA") {
      DNS.resolveAsync[SOA](domain, RRTYPE_SOA).future foreach { response =>
        info(s"resolveAsync:SOA: response: ${response.toJson}")
      }
    }

    it("supports reverseAsync") {
      DNS.reverseAsync("216.58.218.142").future map { hostnames =>
        info(s"reverseAsync - hostname: ${hostnames.mkString(", ")}")
      }
    }

  }

}
