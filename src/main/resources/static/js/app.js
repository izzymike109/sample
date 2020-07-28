
'use strict'
var demoApp = angular.module('exchangeRates', ['ui.bootstrap', 'exchangeRates.controllers',
    'exchangeRates.services'
]);
demoApp.constant("CONSTANTS", {
    getBestRates: "/rates/bestrates",
    getLatest: "/rates/latest",
    getCurrencies: "/rates/currencies"
});