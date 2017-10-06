(function () {
    'use strict';

    angular.module('cw.config').config(function ($routeProvider, $locationProvider) {
        $routeProvider.when("/", {
            templateUrl: "html/cw_home.html",
            controller: "PageController",
            controllerAs: "pageCtrl",
            resolve: {
                qpage: function (PageService) {
                    return PageService.getPage('home');
                },
                qurl: function () { 
                	return 'http://www.codewasher.com';
                }
            }
        }).when("/neues_leben_codewasher/article/:articleId", {
            templateUrl: "html/cw_article.html",
            controller: "ArticleController",
            controllerAs: "articleCtrl",
            resolve: {
                qarticle: function (ArticleService, $route) {
                    return ArticleService.getArticle($route.current.params.articleId);
                }, 
                qurl: function ($route) { 
                	return 'http://www.codewasher.com/nl_codewasher_client/neues_leben_codewasher/article/' + $route.current.params.articleId;
                }
            }
        }).when("/neues_leben_codewasher/page/home", {
            templateUrl: "html/cw_home.html",
            controller: "PageController",
            controllerAs: "pageCtrl",
            resolve: {
                qpage: function (PageService) {
                    return PageService.getPage('home');
                }, 
                qurl: function () { 
                	return 'http://www.codewasher.com';
                }
            }
        }).when("/neues_leben_codewasher/articles/:category", {
            templateUrl: "html/cw_articles.html",
            controller: "PageController",
            controllerAs: "pageCtrl",
            resolve: {
                qpage: function (PageService, $route) {
                    return PageService.getArticles($route.current.params.category);
                }, 
                qurl: function ($route) { 
                	return 'http://www.codewasher.com/nl_codewasher_client/neues_leben_codewasher/articles/' + $route.current.params.category;
                }
            }
        }).otherwise({ redirectTo: '/' });
        
        $locationProvider.html5Mode(true);
    });
}());