package io.scalajs.npm.mysql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Connection Options
  * @param host               The hostname of the database you are connecting to. (Default: localhost)
  * @param port               The port number to connect to. (Default: 3306)
  * @param localAddress       The source IP address to use for TCP connection. (Optional)
  * @param socketPath         The path to a unix domain socket to connect to. When used host and port are ignored.
  * @param user               The MySQL user to authenticate as.
  * @param password           The password of that MySQL user.
  * @param database           Name of the database to use for this connection (Optional).
  * @param charset            The charset for the connection. This is called "collation" in the SQL-level of MySQL (like utf8_general_ci). If a SQL-level charset is specified (like utf8mb4) then the default collation for that charset is used. (Default: 'UTF8_GENERAL_CI')
  * @param timezone           The timezone used to store local dates. (Default: 'local')
  * @param connectTimeout     The milliseconds before a timeout occurs during the initial connection to the MySQL server. (Default: 10000)
  * @param stringifyObjects   Stringify objects instead of converting to values. See issue #501. (Default: 'false')
  * @param insecureAuth       Allow connecting to MySQL instances that ask for the old (insecure) authentication method. (Default: false)
  * @param typeCast           Determines if column values should be converted to native JavaScript types. (Default: true)
  * @param queryFormat        A custom query format function. See Custom format.
  * @param supportBigNumbers  When dealing with big numbers (BIGINT and DECIMAL columns) in the database, you should enable this option (Default: false).
  * @param bigNumberStrings   Enabling both supportBigNumbers and bigNumberStrings forces big numbers (BIGINT and DECIMAL columns) to be always returned as JavaScript String objects (Default: false). Enabling supportBigNumbers but leaving bigNumberStrings disabled will return big numbers as String objects only when they cannot be accurately represented with [JavaScript Number objects] (http://ecma262-5.com/ELS5_HTML.htm#Section_8.5) (which happens when they exceed the [-2^53, +2^53] range), otherwise they will be returned as Number objects. This option is ignored if supportBigNumbers is disabled.
  * @param dateStrings        Force date types (TIMESTAMP, DATETIME, DATE) to be returned as strings rather then inflated into JavaScript Date objects. (Default: false)
  * @param debug              Prints protocol details to stdout. (Default: false)
  * @param trace              Generates stack traces on Error to include call site of library entrance ("long stack traces"). Slight performance penalty for most calls. (Default: true)
  * @param multipleStatements Allow multiple mysql statements per query. Be careful with this, it could increase the scope of SQL injection attacks. (Default: false)
  * @param flags              List of connection flags to use other than the default ones. It is also possible to blacklist default ones. For more information, check Connection Flags.
  * @param ssl                object with ssl parameters or a string containing name of ssl profile. See SSL options.
  */
@ScalaJSDefined
class ConnectionOptions(var host: js.UndefOr[String] = js.undefined,
                        var port: js.UndefOr[Int] = js.undefined,
                        var localAddress: js.UndefOr[String] = js.undefined,
                        var socketPath: js.UndefOr[String] = js.undefined,
                        var user: js.UndefOr[String] = js.undefined,
                        var password: js.UndefOr[String] = js.undefined,
                        var database: js.UndefOr[String] = js.undefined,
                        var charset: js.UndefOr[String] = js.undefined,
                        var timezone: js.UndefOr[String] = js.undefined,
                        var connectTimeout: js.UndefOr[Boolean] = js.undefined,
                        var stringifyObjects: js.UndefOr[Boolean] = js.undefined,
                        var insecureAuth: js.UndefOr[Boolean] = js.undefined,
                        var typeCast: js.UndefOr[Boolean] = js.undefined,
                        var queryFormat: js.UndefOr[String] = js.undefined,
                        var supportBigNumbers: js.UndefOr[Boolean] = js.undefined,
                        var bigNumberStrings: js.UndefOr[Boolean] = js.undefined,
                        var dateStrings: js.UndefOr[String] = js.undefined,
                        var debug: js.UndefOr[Boolean] = js.undefined,
                        var trace: js.UndefOr[Boolean] = js.undefined,
                        var multipleStatements: js.UndefOr[Boolean] = js.undefined,
                        var flags: js.UndefOr[String] = js.undefined,
                        var ssl: js.UndefOr[SSLOptions] = js.undefined) extends js.Object
