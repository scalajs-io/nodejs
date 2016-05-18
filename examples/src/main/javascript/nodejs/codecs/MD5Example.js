/**
 * MD5 Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const filename = process.argv[2];
    const crypto = require("crypto");
    const fs = require("fs");

    const md5sum = crypto.createHash("md5");

    const stream = fs.ReadStream(filename);
    stream.on("data", function (d) {
        md5sum.update(d);
    });

    stream.on("end", function () {
        var md5 = md5sum.digest("hex");
        console.log(md5 + "  " + filename);
    });

})();