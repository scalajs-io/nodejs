(function() {

    var express = require('express')
        , csv = require('express-csv')
        , app = module.exports = express.createServer();

    app.get('/', function(req, res) {
        res.csv([
            ["a", "b", "c"]
            , ["d", "e", "f"]
        ]);
    });

    app.listen(3000);

})();