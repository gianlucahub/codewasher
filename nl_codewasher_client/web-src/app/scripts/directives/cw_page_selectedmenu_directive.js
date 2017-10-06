(function () {
    'use strict';

    angular.module('cw.directives').directive('selectedmenu', function () {
            return {
                restrict: 'A',
                link: function (scope, element, attr) {
                    element.on('click', function (event) {
                        element.parent().parent().children().removeClass('active'); 
                        element.parent().addClass('active');   
                    });
                }
            }
	})
}());
