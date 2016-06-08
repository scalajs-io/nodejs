/**
 * VM Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const util = require('util');
    const vm = require('vm');

    const sandbox = {
        animal: 'cat',
        count: 2
    };

    const script = vm.createScript('count += 1; name = "kitty";');

    const context = vm.createContext(sandbox);
    for (var i = 0; i < 10; ++i) {
        script.runInContext(context);
    }

    console.log(util.inspect(sandbox));

    // { animal: 'cat', count: 12, name: 'kitty' }

})();