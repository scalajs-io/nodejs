/**
 * jwt-simple Example
 * @author lawrence.daniels@gmail.com
 */
(function() {

    var jwt = require('jwt-simple');
    var payload = { foo: 'bar' };
    var secret = 'xxx';

    // encode 
    var token = jwt.encode(payload, secret);

    // decode 
    var decoded = jwt.decode(token, secret);
    console.log(decoded); //=> { foo: 'bar' } 
    
})();