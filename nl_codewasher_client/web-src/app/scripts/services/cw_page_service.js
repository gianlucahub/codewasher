(function() {
	'use strict';

	angular.module('cw.services').factory('PageService', function(Page) {

		return {
			getPage : function(page) {
				var res = Page.getPage({
					pageId : page
				}).$promise.then(function(resPage) {
					console.log('success, got data: ', resPage);
					return resPage;
				}, function(err) {
					alert('request failed');
				});
				return res;
			},
            getArticles : function(category) {
				var res = Page.getArticles({
					categoryId : category
				}).$promise.then(function(resPage) {
					console.log('success, got data: ', resPage);
					return resPage;
				}, function(err) {
					alert('request failed');
				});
				return res;
			}
		}
	});
}());
