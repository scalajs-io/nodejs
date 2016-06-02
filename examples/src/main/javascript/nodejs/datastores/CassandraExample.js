/**
 * Cassandra Example
 * @author lawrence.daniels@gmail.com
 */
(function() {

    const cassandra = require("cassandra-driver");
    const assert = require("assert");

    dataTypes();
    
    function dataTypes() {
        // BigDecimal
        console.log("BigDecimal");
        const value0 = cassandra.types.BigDecimal(0xCAFEBABE);
        console.log(value0);
        console.log(cassandra.types.BigDecimal.toBuffer(value0));
        console.log("");

        // Integer
        console.log("Integer");
        const value1 = cassandra.types.Integer(0xCAFEBABE);
        console.log(value1);
        console.log(cassandra.types.Integer.toBuffer(value1));
        console.log("");

        // Long
        console.log("Long")
        const value2 = cassandra.types.Long(0xDEADBEEFCAFEBABE);
        console.log(value2);
        console.log(cassandra.types.Long.toBuffer(value2));
        console.log("");

        // Inet Address
        console.log("Inet Address");
        const ipAddress = Buffer.from([192, 168, 1, 5]);
        console.log(ipAddress);
        const value3 = cassandra.types.InetAddress(ipAddress);
        console.log(value3);
    }

})();