package io.scalajs.nodejs
package path

import org.scalatest.FunSpec

class PathTest extends FunSpec {
  describe("Path") {
    it("supports join()") {
      assert(Path.win32.toNamespacedPath("c:\\foo\\bar") === "\\\\?\\c:\\foo\\bar")
      assert(Path.posix.toNamespacedPath("c:\\foo\\bar") === "c:\\foo\\bar")
    }
  }
}
