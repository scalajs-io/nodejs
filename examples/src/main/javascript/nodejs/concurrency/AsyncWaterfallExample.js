/**
 * Async Waterfall Example
 * @author lawrence.daniels@gmail.com
 */
(function() {
    const async = require("async");

    async.waterfall([
        function (callback) {
            callback(null, "one", "two");
        },
        function (arg1, arg2, callback) {
            // arg1 now equals "one" and arg2 now equals "two"
            callback(null, "three");
        },
        function (arg1, callback) {
            // arg1 now equals "three"
            callback(null, "done");
        }
    ], function (err, result) {
        // result now equals "done"
        console.log("result = %s", result)
    });

})();