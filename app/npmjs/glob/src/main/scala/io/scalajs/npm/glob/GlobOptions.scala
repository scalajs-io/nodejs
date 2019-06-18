package io.scalajs.npm.glob

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Glob Options
  * @param cwd        The current working directory in which to search.
  *                   Defaults to [[io.scalajs.nodejs.process.cwd() process.cwd()]].
  * @param root       The place where patterns starting with / will be mounted onto.
  *                   Defaults to path.resolve(options.cwd, "/") (/ on Unix systems, and C:\ or some such on Windows.)
  * @param dot        Include .dot files in normal matches and globstar matches.
  *                   Note that an explicit dot in a portion of the pattern will always match dot files.
  * @param nomount    By default, a pattern starting with a forward-slash will be "mounted" onto the root setting,
  *                   so that a valid filesystem path is returned. Set this flag to disable that behavior.
  * @param mark       Add a / character to directory matches. Note that this requires additional stat calls.
  * @param nosort     Don't sort the results.
  * @param stat       Set to true to stat all results.
  *                   This reduces performance somewhat, and is completely unnecessary, unless readdir is presumed
  *                   to be an untrustworthy indicator of file existence.
  * @param silent     When an unusual error is encountered when attempting to read a directory, a warning will
  *                   be printed to stderr. Set the silent option to true to suppress these warnings.
  * @param strict     When an unusual error is encountered when attempting to read a directory, the process will
  *                   just continue on in search of other matches. Set the strict option to raise an error in these cases.
  * @param cache      See cache property above. Pass in a previously generated cache object to save some fs calls.
  * @param statCache  A cache of results of filesystem information, to prevent unnecessary stat calls.
  *                   While it should not normally be necessary to set this, you may pass the statCache from
  *                   one glob() call to the options object of another, if you know that the filesystem will not
  *                   change between calls. (See "Race Conditions" below.)
  * @param symlinks   A cache of known symbolic links. You may pass in a previously generated symlinks object to
  *                   save lstat calls when resolving ** matches.
  * @param sync       DEPRECATED: use glob.sync(pattern, opts) instead.
  * @param nounique   In some cases, brace-expanded patterns can result in the same file showing up multiple times
  *                   in the result set. By default, this implementation prevents duplicates in the result set.
  *                   Set this flag to disable that behavior.
  * @param nonull     Set to never return an empty set, instead returning a set containing the pattern itself.
  *                   This is the default in glob(3).
  * @param debug      Set to enable debug logging in minimatch and glob.
  * @param nobrace    Do not expand {a,b} and {1..3} brace sets.
  * @param noglobstar Do not match ** against multiple filenames. (Ie, treat it as a normal * instead.)
  * @param noext      Do not match +(a|b) "extglob" patterns.
  * @param nocase     Perform a case-insensitive match. Note: on case-insensitive filesystems, non-magic patterns
  *                   will match by default, since stat and readdir will not raise errors.
  * @param matchBase  Perform a basename-only match if the pattern does not contain any slash characters.
  *                   That is, *.js would be treated as equivalent to ** / *.js, matching all js files in all directories.
  * @param nodir      Do not match directories, only files. (Note: to match only directories,
  *                   simply put a / at the end of the pattern.)
  * @param ignore     Add a pattern or an array of glob patterns to exclude matches. Note: ignore patterns are always
  *                   in dot:true mode, regardless of any other settings.
  * @param follow     Follow symlinked directories when expanding ** patterns. Note that this can result in a lot of
  *                   duplicate references in the presence of cyclic links.
  * @param realpath   Set to true to call fs.realpath on all of the results. In the case of a symlink that cannot
  *                   be resolved, the full absolute path to the matched entry is returned (though it will usually
  *                   be a broken symlink)
  * @param absolute   Set to true to always receive absolute paths for matched files. Unlike realpath, this also
  *                   affects the values returned in the match event.
  * @author lawrence.daniels@gmail.com
  */
class GlobOptions(val cwd: js.UndefOr[String] = js.undefined,
                  val root: js.UndefOr[String] = js.undefined,
                  val dot: js.UndefOr[Boolean] = js.undefined,
                  val nomount: js.UndefOr[Boolean] = js.undefined,
                  val mark: js.UndefOr[Boolean] = js.undefined,
                  val nosort: js.UndefOr[Boolean] = js.undefined,
                  val stat: js.UndefOr[Boolean] = js.undefined,
                  val silent: js.UndefOr[Boolean] = js.undefined,
                  val strict: js.UndefOr[Boolean] = js.undefined,
                  val cache: js.UndefOr[Boolean] = js.undefined,
                  val statCache: js.UndefOr[Boolean] = js.undefined,
                  val symlinks: js.UndefOr[Boolean] = js.undefined,
                  val sync: js.UndefOr[Boolean] = js.undefined,
                  val nounique: js.UndefOr[Boolean] = js.undefined,
                  val nonull: js.UndefOr[Boolean] = js.undefined,
                  val debug: js.UndefOr[Boolean] = js.undefined,
                  val nobrace: js.UndefOr[Boolean] = js.undefined,
                  val noglobstar: js.UndefOr[Boolean] = js.undefined,
                  val noext: js.UndefOr[Boolean] = js.undefined,
                  val nocase: js.UndefOr[Boolean] = js.undefined,
                  val matchBase: js.UndefOr[Boolean] = js.undefined,
                  val nodir: js.UndefOr[Boolean] = js.undefined,
                  val ignore: js.UndefOr[String | js.Array[String]] = js.undefined,
                  val follow: js.UndefOr[Boolean] = js.undefined,
                  val realpath: js.UndefOr[Boolean] = js.undefined,
                  val absolute: js.UndefOr[Boolean] = js.undefined) extends js.Object
