angular.module('myApp.services', [])

    .factory('Core', function () {
        return {
            greet:'Welcome',
            baseUrl: 'http://localhost:9000',
            product: {}
        }
    });