package io.scalajs.nodejs.process

import com.thoughtworks.enableMembersIf

import scala.scalajs.js
import scala.scalajs.js.|

@enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
@js.native
trait Reporter extends js.Object {
  def getReport(err: io.scalajs.nodejs.Error = js.native): Reporter = js.native

  def directory: String            = js.native
  def directory_=(v: String): Unit = js.native

  def filename: String            = js.native
  def filename_=(v: String): Unit = js.native

  def signal: String            = js.native
  def signal_=(v: String): Unit = js.native

  def reportOnFatalError: Boolean            = js.native
  def reportOnFatalError_=(v: Boolean): Unit = js.native

  def reportOnSignal: Boolean            = js.native
  def reportOnSignal_=(v: Boolean): Unit = js.native

  def reportOnUncaughtException: Boolean            = js.native
  def reportOnUncaughtException_=(v: Boolean): Unit = js.native
}

@js.native
trait Report extends js.Object {
  var header: js.Object                            = js.native
  var javascriptStack: JavascriptStack             = js.native
  var nativeStack: js.Array[NativeStackInfo]       = js.native
  var javascriptHeap: JavascriptHeap               = js.native
  var resourceUsage: ReportResourceUsage           = js.native
  var uvthreadResourceUsage: UvThreadResourceUsage = js.native
  var libuv: js.Array[Libuv]                       = js.native
  var environmentVariables: js.Dictionary[String]  = js.native
  var userLimits: js.Dictionary[UserLimit]         = js.native
  val sharedObjects: js.Array[String]              = js.native
}

@js.native
trait Header extends js.Object {
  var arch: String                                  = js.native
  var commandLine: js.Array[String]                 = js.native
  var componentVersions: ComponentVersion           = js.native
  var cpus: js.Array[Cpu]                           = js.native
  var cwd: String                                   = js.native
  var dumpEventTime: String                         = js.native
  var event: String                                 = js.native
  var filename: String | Null                       = js.native
  var glibcVersionCompiler: String                  = js.native
  var glibcVersionRuntime: String                   = js.native
  var host: String                                  = js.native
  var networkInterfaces: js.Array[NetworkInterface] = js.native
  var nodejsVersion: String                         = js.native
  var osMachine: String                             = js.native
  var osName: String                                = js.native
  var osRelease: String                             = js.native
  var osVersion: String                             = js.native
  var platorm: String                               = js.native
  var processId: Int                                = js.native
  var release: ReleaseInfo                          = js.native
  var reportVersion: Int                            = js.native
  var trigger: String                               = js.native
  var wordSize: Int                                 = js.native
}
@js.native
trait Cpu extends js.Object {
  var model: String = js.native
  var speed: Int    = js.native
  var user: Int     = js.native
  var nice: Int     = js.native
  var sys: Int      = js.native
  var idle: Int     = js.native
  var irq: Int      = js.native
}

@js.native
trait NetworkInterface extends js.Object {
  var name: String             = js.native
  var internal: Boolean        = js.native
  var mac: String              = js.native
  var address: String          = js.native
  var netmask: String          = js.native
  var family: String           = js.native
  var scopeId: js.UndefOr[Int] = js.native
}

@js.native
trait JavascriptStack extends js.Object {
  var message: String         = js.native
  var stack: js.Array[String] = js.native
}

@js.native
trait NativeStackInfo extends js.Object {
  var pc: String     = js.native
  var symbol: String = js.native
}

@js.native
trait JavascriptHeap extends js.Object {
  var totalMemory: Int          = js.native
  var totalCommittedMemory: Int = js.native
  var usedMemory: Int           = js.native
  var availableMemory: Int      = js.native
  var memoryLimit: Int          = js.native
  var heapSpaces: HeapSpaces    = js.native
}

@js.native
trait HeapSpaces extends js.Object {
  var read_only_space: JsHeapSpace         = js.native
  var new_space: JsHeapSpace               = js.native
  var old_space: JsHeapSpace               = js.native
  var code_space: JsHeapSpace              = js.native
  var map_space: JsHeapSpace               = js.native
  var large_object_space: JsHeapSpace      = js.native
  var code_large_object_space: JsHeapSpace = js.native
  var new_large_object_space: JsHeapSpace  = js.native
}

@js.native
trait JsHeapSpace extends js.Object {
  var memorySize: Int      = js.native
  var committedMemory: Int = js.native
  var capacity: Int        = js.native
  var used: Int            = js.native
  var available: Int       = js.native
}

@js.native
trait ReportResourceUsage extends js.Object {
  var userCpuSeconds: Double        = js.native
  var kernelCpuSeconds: Double      = js.native
  var cpuConsumptionPercent: Double = js.native
  var maxRss: Int                   = js.native
  var pageFaults: PageFaults        = js.native
  var fsActivity: FsActivity        = js.native
}

@js.native
trait PageFaults extends js.Object {
  var IORequired: Int    = js.native
  var IONotRequired: Int = js.native
}

@js.native
trait UvThreadResourceUsage extends js.Object {
  var userCpuSeconds: Double        = js.native
  var kernelCpuSeconds: Double      = js.native
  var cpuConsumptionPercent: Double = js.native
  var fsActivity: FsActivity        = js.native
}

@js.native
trait FsActivity extends js.Object {
  var reads: Int  = js.native
  var writes: Int = js.native
}

@js.native
trait Libuv extends js.Object {
  var `type`: String     = js.native
  var is_active: Boolean = js.native
  var address: String    = js.native

  var is_referenced: js.UndefOr[Boolean] = js.native
  var details: js.UndefOr[String]        = js.native
  var repeat: js.UndefOr[Int]            = js.native
  var firesInMsFromNow: js.UndefOr[Int]  = js.native
  var expired: js.UndefOr[Boolean]       = js.native
  var width: js.UndefOr[Int]             = js.native
  var height: js.UndefOr[Int]            = js.native
  var fd: js.UndefOr[Int]                = js.native
  var writeQueueSize: js.UndefOr[Int]    = js.native
  var readable: js.UndefOr[Boolean]      = js.native
  var writable: js.UndefOr[Boolean]      = js.native
  var signum: js.UndefOr[Int]            = js.native
  var signal: js.UndefOr[String]         = js.native
}

@js.native
trait UserLimit extends js.Object {
  var soft: Int | String
  var hard: Int | String
}
