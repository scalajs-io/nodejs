package org.scalajs.nodejs.datastax

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.datastax.CassandraDriver._
import org.scalajs.nodejs.datastax.datatypes._
import org.scalajs.nodejs.datastax.datatypes._
import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * DataStax Node.js Driver for Apache Cassandra
  * @author lawrence.daniels@gmail.com
  * @version 3.0.2
  * @see https://github.com/datastax/nodejs-driver
  */
@js.native
trait CassandraDriver extends NodeModule {

  def Client: CassandraClientClass = js.native

  def policies: Policies = js.native

  def types: Types = js.native

}

/**
  * Cassandra Driver Companion
  * @author lawrence.daniels@gmail.com
  */
object CassandraDriver {

  /**
    * Convenience method for retrieving the cassandra-driver module
    * @param require the implicit [[NodeRequire require function]]
    * @return the CassandraDriver instance
    */
  def apply()(implicit require: NodeRequire) = require[CassandraDriver]("cassandra-driver")

  /**
    * Consistencies object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Consistencies extends js.Object {
    var any: ConsistencyLevel = js.native
    var one: ConsistencyLevel = js.native
    var two: ConsistencyLevel = js.native
    var three: ConsistencyLevel = js.native
    var quorum: ConsistencyLevel = js.native
    var all: ConsistencyLevel = js.native
    var localQuorum: ConsistencyLevel = js.native
    var eachQuorum: ConsistencyLevel = js.native
    var serial: ConsistencyLevel = js.native
    var localSerial: ConsistencyLevel = js.native
    var localOne: ConsistencyLevel = js.native
  }

  /**
    * Data Types object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait DataTypes extends js.Object {
    var custom: Int = js.native
    var ascii: Int = js.native
    var bigint: Int = js.native
    var blob: Int = js.native
    var boolean: Int = js.native
    var counter: Int = js.native
    var decimal: Int = js.native
    var double: Int = js.native
    var float: Int = js.native
    var int: Int = js.native
    var text: Int = js.native
    var timestamp: Int = js.native
    var uuid: Int = js.native
    var varchar: Int = js.native
    var varint: Int = js.native
    var timeuuid: Int = js.native
    var inet: Int = js.native
    var date: Int = js.native
    var time: Int = js.native
    var smallint: Int = js.native
    var tinyint: Int = js.native
    var list: Int = js.native
    var map: Int = js.native
    var set: Int = js.native
    var udt: Int = js.native
    var tuple: Int = js.native

    def getByName: js.Function1[String, Int] = js.native

  }

  /**
    * Distance object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Distance extends js.Object {
    var local: Int = js.native
    var remote: Int = js.native
    var ignored: Int = js.native
  }

  /**
    * Policies object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Policies extends js.Object {

    def DCAwareRoundRobinPolicy: js.Function1[String, Policy] = js.native

  }

  /**
    * OpCodes object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait OpCodes extends js.Object {
    var error: Int = js.native
    var startup: Int = js.native
    var ready: Int = js.native
    var authenticate: Int = js.native
    var credentials: Int = js.native
    var options: Int = js.native
    var supported: Int = js.native
    var query: Int = js.native
    var result: Int = js.native
    var prepare: Int = js.native
    var execute: Int = js.native
    var register: Int = js.native
    var event: Int = js.native
    var batch: Int = js.native
    var authChallenge: Int = js.native
    var authResponse: Int = js.native
    var authSuccess: Int = js.native

    def isInRange: js.Function1[Int, Boolean] = js.native

  }

  /**
    * Policy type
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Policy extends js.Any

  /**
    * Protocol Events object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait ProtocolEvents extends js.Object {
    var topologyChange: String = js.native
    var statusChange: String = js.native
    var schemaChange: String = js.native
  }

  /**
    * Response Error Codes object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait ResponseErrorCodes extends js.Object {
    var serverError: Int = js.native
    var protocolError: Int = js.native
    var badCredentials: Int = js.native
    var unavailableException: Int = js.native
    var overloaded: Int = js.native
    var isBootstrapping: Int = js.native
    var truncateError: Int = js.native
    var writeTimeout: Int = js.native
    var readTimeout: Int = js.native
    var readFailure: Int = js.native
    var functionFailure: Int = js.native
    var writeFailure: Int = js.native
    var syntaxError: Int = js.native
    var unauthorized: Int = js.native
    var invalid: Int = js.native
    var configError: Int = js.native
    var alreadyExists: Int = js.native
    var unprepared: Int = js.native
  }

  /**
    * Types object
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Types extends js.Object {
    var consistencies: Consistencies = js.native
    var dataTypes: DataTypes = js.native
    var distance: Distance = js.native
    var opcodes: OpCodes = js.native
    var protocolEvents: ProtocolEvents = js.native
    var responseErrorCodes: ResponseErrorCodes = js.native

    def getDataTypeNameByCode: js.Function1[js.Any, js.Any] = js.native

    def timeuuid: js.Function0[String] = js.native

    def uuid: js.Function0[String] = js.native

    def BigDecimal: BigDecimalClass = js.native

    def InetAddress: InetAddressClass = js.native

    def Integer: IntegerClass = js.native

    def LocalDate: LocalDateClass = js.native

    def LocalTime: LocalTimeClass = js.native

    def Long: LongClass = js.native

    def TimeUuid: TimeUuidClass = js.native

    def Uuid: UuidClass = js.native

  }

}