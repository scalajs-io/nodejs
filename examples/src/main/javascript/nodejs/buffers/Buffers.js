/**
 * Buffers Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const buf1 = Buffer.from('ABC');
    const buf2 = Buffer.from('BCD');
    const buf3 = Buffer.from('ABCD');

    // Prints: 0
    console.log(buf1.compare(buf1));
    // Prints: -1
    console.log(buf1.compare(buf2));
    // Prints: 1
    console.log(buf1.compare(buf3));
    // Prints: 1
    console.log(buf2.compare(buf1));
    // Prints: 1
    console.log(buf2.compare(buf3));

    // produces sort order [buf1, buf3, buf2]
    console.log([buf1, buf2, buf3].sort(Buffer.compare));

    // iterate the 3rd buffer
    const it = buf3.entries();
    var result = null;
    do {
        result = it.next();
        console.log(result);
    } while (!result.done);

})();