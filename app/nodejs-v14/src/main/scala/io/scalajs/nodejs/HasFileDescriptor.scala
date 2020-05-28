package io.scalajs.nodejs

import scala.scalajs.js

trait HasFileDescriptor extends js.Object {
  def fd: FileDescriptor
}
