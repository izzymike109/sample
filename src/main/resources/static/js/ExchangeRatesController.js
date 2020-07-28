
'use strict'
var module = angular.module('exchangeRates.controllers', []);
module.controller("ExchangeRatesController", ["$scope", "ExchangeRatesService",
    function($scope, RatesService) {
        $scope.rate = {
            currency: null,
            provider: null,
            value: null,
            fee: null,
            date: null
        };

        $scope.currencies = [];
        $scope.amount = null;
        $scope.currencyFrom = null;
        $scope.currencyTo = null;

        $scope.getBestRates = function() {
            RatesService.getBestRates($scope.amount, $scope.currencyFrom, $scope.currencyTo).then(function(value) {
                console.log(value.data);
                $scope.bestrates= value.data;
                $scope.errorMessage = null;
            }, function(reason) {
                $scope.errorMessage = reason.data.message;
                console.log("An Error has occurred: " + $scope.errorMessage);
            }, function(value) {
                console.log("no further handler/callback");
            });
        }

        $scope.getLatest = function() {
            RatesService.getLatest().then(function(value) {
                console.log(value.data);
                $scope.latest= value.data;
            }, function(reason) {
                console.log("An Error has occurred");
            }, function(value) {
                console.log("no further handler/callback");
            });
        }

        $scope.getCurrencies = function() {
            RatesService.getCurrencies().then(function(value) {
                console.log(value.data);
                $scope.currencies= value.data;
            }, function(reason) {
                console.log("An Error has occurred");
            }, function(value) {
                console.log("no further handler/callback");
            });
        }

        $scope.getCurrencies();
    }
]);