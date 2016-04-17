angular.module('myApp.controllers', [])

    .controller('HomeCtrl', function ($scope, Core) {
        $scope.show = Core.greet;
    })

    .controller('ProductCtrl', function ($scope, $http, Core, $location) {

        $http({
            method: 'GET',
            url: Core.baseUrl + '/products'
        }).then(function (response) {
                console.log(response);
                $scope.products = response.data;
            },
            function (error) {
                console.log(error);
            });
        
        $scope.editProduct = function (product) {
            Core.product = product;
            $location.path('/products/edit');
        };

        $scope.showProduct = function (product) {
            Core.product = product;
            $location.path('/products/' + product.id);
        }

    })
    
    .controller('ProductEditor', function ($scope, Core, $http) {
        $scope.product = Core.product;

        $scope.submit = function () {
            $http({
                method: 'PUT',
                url: Core.baseUrl + '/products',
                dataType: 'json',
                data: $scope.product
            }).then()
        }
    })

    .controller('OrderCtrl', function ($scope, $http, Core) {
        $http({
            method: 'GET',
            url: Core.baseUrl + '/orders'
        }).then(function (response) {
                $scope.orders = response.data;
        
                // $http({
                //     method: 'GET',
                //     url: Core.baseUrl + '/customers/' + response.data.customer.id
                // }).then(function (response) {
                //         $scope.customer = response.data;
                //     },
                //     function (error) {
                //         console.log(error);
                //     });
            },
            function (error) {
                console.log(error);
            });
    });

