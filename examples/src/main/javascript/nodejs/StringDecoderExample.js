/**
 * String Decoder Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const StringDecoder = require('string_decoder').StringDecoder;
    const decoder = new StringDecoder('utf8');

    const cent = new Buffer([0xC2, 0xA2]);
    console.log(decoder.write(cent));

    const euro = new Buffer([0xE2, 0x82, 0xAC]);
    console.log(decoder.write(euro));

})();
