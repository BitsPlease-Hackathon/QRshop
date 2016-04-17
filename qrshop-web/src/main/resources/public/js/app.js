angular.module('myApp', ['ngRoute', 'myApp.controllers', 'myApp.services'])

    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeCtrl'
                })

                .when('/products', {
                    templateUrl: 'partials/products.html',
                    controller: 'ProductCtrl'
                })

                .when('/products/edit', {
                    templateUrl: 'partials/editProduct.html',
                    controller: 'ProductEditor'
                })

                .when('/orders', {
                    templateUrl: 'partials/orders.html',
                    controller: 'OrderCtrl'
                })

                .otherwise({
                    redirectTo: '/'
                });
        }
    ]);