/**
 * Memory-fs Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    var assert = require("assert");
    var MemoryFileSystem = require("memory-fs");
    var fs = new MemoryFileSystem(); // Optionally pass a javascript object

    example2();
    
    function example1() {
        fs.mkdirpSync("/a/test/dir");
        fs.writeFileSync("/a/test/dir/file.txt", "Hello World");
        fs.readFileSync("/a/test/dir/file.txt"); // returns Buffer("Hello World")

        // Async variantes too
        fs.unlink("/a/test/dir/file.txt", function (err) {
            // ...
        });

        fs.readdirSync("/a/test"); // returns ["dir"]
        fs.statSync("/a/test/dir").isDirectory(); // returns true
        fs.rmdirSync("/a/test/dir");

        fs.mkdirpSync("C:\\use\\windows\\style\\paths");
    }

    function example2() {
        var output1 = null;
        var output2 = null;
        var output3 = null;

        fs.mkdirp("/a/test/dir", function (err1) {
            assert.ifError(err1);

            fs.writeFile("/a/test/dir/file.txt", "Hello World", function (err2) {
                assert.ifError(err2);

                fs.readFile("/a/test/dir/file.txt", function (err3, data) {
                    assert.ifError(err3);
                    output1 = data; // ~> Buffer("Hello World")

                    fs.unlink("/a/test/dir/file.txt", function (err4) {
                        assert.ifError(err4);

                        fs.readdir("/a/test", function (err5, dir) {
                            assert.ifError(err5);
                            output2 = dir; // ~> ["dir"]

                            fs.stat("/a/test/dir", function (err6, stats) {
                                assert.ifError(err6);
                                output3 = stats.isDirectory(); // ~> true

                                fs.rmdir("/a/test/dir", function (err7) {
                                    assert.ifError(err7);
                                    fs.mkdirp("C:\\use\\windows\\style\\paths", function (err8) {
                                        assert.ifError(err8)

                                        console.log("output1 =", output1.toString(), output1);
                                        console.log("output2 =", output2);
                                        console.log("output3 =", output3);
                                    })
                                })
                            })
                        })
                    })
                })
            })
        });
    }

})();
