angular.module('myApp.services', [])

    .factory('Core', function () {
        return {
            greet:'Welcome',
            baseUrl: 'http://localhost:8080/api',
            product: {}
        }
    });