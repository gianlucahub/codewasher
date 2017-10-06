//(function () {
//    'use strict';
//
//    angular.module('cw.directives').directive('codeoverflow',
//			function ($timeout) {
//            return {
//                restrict: 'A',
//                link: function (scope, element, attr) {
//                    var overflowFuncton = function () {
//                        if (element[0].offsetWidth > element[0].parentElement.offsetWidth) {
//                            element[0].css('display', 'inline-block');
//                            element[0].css('width', '1000px');
//                            element[0].css('overflow-x', 'scroll');
//                        }
//                    }
//                    $timeout(overflowFuncton, 0);
//                }
//            }
//	})
//}());
