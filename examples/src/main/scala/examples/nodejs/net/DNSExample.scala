package examples.nodejs.net

import org.scalajs.nodejs.dns._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.dns.{DNS, DnsError, MX, SOA}
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * DNS Example
  * @author lawrence.daniels@gmail.com
  */
class DNSExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val dns = require[DNS]("dns")
  val assert = Assert()

  doCallbacks("google.com")
  doFutures("bing.com")

  /**
    * lookup and lookupService using callbacks
    */
  def doCallbacks(domain: String) {
    // perform a lookup w/callback
    dns.lookup(s"www.$domain", (error1: DnsError, ipAddress: String) => {
      assert.ifError(error1)
      dns.reverse(ipAddress, (error2: DnsError, hostnames: js.Array[String]) => {
        assert.ifError(error2)
        console.log("lookup/Callback: ipAddress => %s, hostname = %s", ipAddress, hostnames.mkString(", "))
      })
    })

    // perform a lookupService w/callback
    dns.lookupService("127.0.0.1", 22, (error: DnsError, hostname: String, service: String, family: js.Any) => {
      assert.ifError(error)
      console.log("lookupService/Callback: hostname =>", hostname, ", service =>", service, ", family =>", family)
    })

    // perform a resolve NS w/callback
    dns.resolve(domain, "NS", (error: DnsError, addresses: js.Array[String]) => {
      assert.ifError(error)
      console.log("resolve:NS/Callback: addresses =>", addresses.mkString(", "))
    })
  }

  /**
    * lookup and lookupService using futures
    */
  def doFutures(domain: String) {
    // perform a lookup and then reverse lookup
    for {
      ipAddress <- dns.lookupFuture(s"www.$domain")
      hostnames <- dns.reverseFuture(ipAddress)
    } {
      console.log("lookup/Future: ipAddress => %s, hostname = %s", ipAddress, hostnames.mkString(", "))
    }

    // lookup the SSH service
    dns.lookupServiceFuture("127.0.0.1", 22) foreach { case (hostname, service) =>
      console.log("lookupService/Future: hostname =>", hostname, ", service =>", service)
    }

    // perform a resolve NS w/callback
    dns.resolveFuture[js.Array[String]](domain, RRTYPE_NS) foreach { addresses =>
      console.log("resolve:NS/Future: addresses =>", addresses.mkString(", "))
    }

    // perform a resolve MX w/callback
    dns.resolveFuture[js.Array[MX]](domain, RRTYPE_MX) foreach { response =>
      console.log("resolve:MX/Future: response => %j", response)
    }

    // perform a resolve SOA w/callback
    dns.resolveFuture[SOA](domain, RRTYPE_SOA) foreach { response =>
      console.log("resolve:SOA/Future: response => %j", response)
    }
  }

}
