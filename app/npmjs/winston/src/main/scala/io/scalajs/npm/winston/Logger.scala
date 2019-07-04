package io.scalajs.npm.winston

/**
  * Winston Logger
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "Logger")
class Logger(options: ConfigurationOptions) extends js.Object {

  ///////////////////////////////////////////////////////////////////////////////////////////
  //        Constructor
  ///////////////////////////////////////////////////////////////////////////////////////////

  protected def this() = this(js.native)

  ///////////////////////////////////////////////////////////////////////////////////////////
  //        Properties
  ///////////////////////////////////////////////////////////////////////////////////////////

  var exitOnError: Boolean = js.native

  val filters: js.Array[js.Function] = js.native

  var level: String = js.native

  val rewriters: js.Array[js.Function] = js.native

  var transports: Transports = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////
  //        Methods
  ///////////////////////////////////////////////////////////////////////////////////////////

  def add(transport: Transport, options: FileTransportOptions = js.native): Unit = js.native

  def cli(): Unit = js.native

  def configure(options: ConfigurationOptions): Unit = js.native

  def debug(message: String): Unit = js.native

  def debug(level: String, message: String, metadata: js.Any*): Unit = js.native

  def error(message: String): Unit = js.native

  def error(level: String, message: String, args: js.Any*): Unit = js.native

  def info(message: String): Unit = js.native

  def info(level: String, message: String, args: js.Any*): Unit = js.native

  def log(message: String): Unit = js.native

  def log(level: String, message: String, args: js.Any*): Unit = js.native

  def profile(name: String): Unit = js.native

  def query(options: QueryOptions, callback: js.Function2[WinstonError, js.Any, Any]): Unit = js.native

  def remove(name: String): Unit = js.native

  def remove(transport: Transport): Unit = js.native

  def silly(message: String): Unit = js.native

  def silly(level: String, message: String, args: js.Any*): Unit = js.native

  def stream(options: StreamingOptions): Readable = js.native

  def warn(message: String): Unit = js.native

  def warn(level: String, message: String, args: js.Any*): Unit = js.native

  def verbose(message: String): Unit = js.native

  def verbose(level: String, message: String, args: js.Any*): Unit = js.native

}
