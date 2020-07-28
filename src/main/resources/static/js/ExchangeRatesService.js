
'use strict'
angular.module('exchangeRates.services', []).factory('ExchangeRatesService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getBestRates = function(amount, currencyFrom, currencyTo) {
        return $http.get(CONSTANTS.getBestRates, {params: {amount: amount, currencyFrom: currencyFrom.code, currencyTo: currencyTo.code}});
    }
    service.getLatest = function() {
        return $http.get(CONSTANTS.getLatest);
    }
    service.getCurrencies = function() {
        return $http.get(CONSTANTS.getCurrencies);
    }

    return service;
}]);