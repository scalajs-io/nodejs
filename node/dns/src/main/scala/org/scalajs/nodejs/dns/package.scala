package org.scalajs.nodejs

/**
  * dns package object
  * @author lawrence.daniels@gmail.com
  */
package object dns {

  type RRType = String

  // IPV4 addresses, default
  val RRTYPE_A: RRType = "A"

  // IPV6 addresses
  val RRTYPE_AAAA: RRType = "AAAA"

  // mail exchange records
  val RRTYPE_MX: RRType = "MX"

  // text records
  val RRTYPE_TXT: RRType = "TXT"

  // SRV records
  val RRTYPE_SRV: RRType = "SRV"

  // PTR records
  val RRTYPE_PTR: RRType = "PTR"

  // name server records
  val RRTYPE_NS: RRType = "NS"

  // canonical name records
  val RRTYPE_CNAME: RRType = "CNAME"

  // start of authority record
  val RRTYPE_SOA: RRType = "SOA"

  // name authority pointer record
  val RRTYPE_NAPTR: RRType = "NAPTR"

}
