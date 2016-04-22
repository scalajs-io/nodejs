/**
 * Tiny CLI
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const readline = require('readline');
    const rl = readline.createInterface(process.stdin, process.stdout);

    rl.setPrompt('OHAI> ');
    rl.prompt();

    rl.on('line', function (line) {
        switch (line.trim()) {
            case 'hello':
                console.log('world!');
                break;
            default:
                console.log('Say what? I might have heard `' + line.trim() + '`');
                break;
        }
        rl.prompt();
        
    }).on('close', function () {
        console.log('Have a great day!');
        process.exit(0);
    });

})();