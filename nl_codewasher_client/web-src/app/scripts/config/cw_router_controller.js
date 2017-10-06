(function () {
    'use strict';

    angular.module('cw.config').controller(
        'RouterController',
        function (RouterService) {
            var routerCtrl = this;
            routerCtrl.routerService = RouterService;

            routerCtrl.toPage = function (page) {
                RouterService.toPage(page);
            };

            routerCtrl.toPageArticles = function (category) {
                RouterService.toPageArticles(category);
            };
            
        });
}());
