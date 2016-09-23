package org.scalajs.nodejs.dns

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * DNS Tests
  * @author lawrence.daniels@gmail.com
  */
object DNSTests extends TestSuite {
  val dns = DNS()
  val domain = "yahoo.com"

  override val tests = this {

    "dns.lookup" - {
      dns.lookup(domain, (err: DnsError, ipAddress: String) => {
        err ==> null
        console.log("dns.lookup - ipAddress:", ipAddress)
      })
    }

    "dns.lookupFuture" - {
      dns.lookupFuture(domain) map { ipAddress =>
        console.log("dns.lookupFuture - ipAddress:", ipAddress)
      }
    }

    "dns.lookupService:SSH" - {
      dns.lookupService("127.0.0.1", 22, (err: DnsError, hostname: String, service: String, family: js.Any) => {
        err ==> null
        console.log("dns.lookupService - hostname =>", hostname, ", service =>", service, ", family =>", family)
      })
    }

    "dns.lookupServiceFuture:SSH" - {
      dns.lookupServiceFuture("127.0.0.1", 22) map { case (hostname, service) =>
        console.log("dns.lookupServiceFuture - hostname:", hostname, ", service =>", service)
      }
    }

    "dns.resolve:NS" - {
      dns.resolve(domain, "NS", (error: DnsError, addresses: js.Array[String]) => {
        error ==> null
        console.log("dns.resolveFuture:NS - addresses:", addresses.mkString(", "))
      })
    }

    "dns.resolveFuture:MX" - {
      dns.resolveFuture[js.Array[MX]](domain, RRTYPE_MX) map { response =>
        console.log("dns.resolveFuture:MX - response:", response)
      }
    }

    "dns.resolveFuture:NS" - {
      dns.resolveFuture[js.Array[String]](domain, "NS") map { addresses =>
        console.log("dns.resolveFuture - addresses:", addresses.mkString(", "))
      }
    }

    "dns.resolveFuture:SOA" - {
      dns.resolveFuture[SOA](domain, RRTYPE_SOA) foreach { response =>
        console.log("dns.resolveFuture:SOA: response:", response)
      }
    }

    "dns.reverseFuture" - {
      dns.reverseFuture("216.58.218.142") map { hostnames =>
        console.log("dns.reverseFuture - hostname:", hostnames.mkString(", "))
      }
    }

  }

}
