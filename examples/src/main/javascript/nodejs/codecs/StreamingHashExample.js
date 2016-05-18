/**
 * Streaming Hash Example
 */
(function () {

    const crypto = require("crypto");
    const fs = require("fs");
    const hash = crypto.createHash("sha256");

    const input = fs.createReadStream("test.js");
    input.pipe(hash).pipe(process.stdout);

})();