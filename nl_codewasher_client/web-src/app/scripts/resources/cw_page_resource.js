(function() {
	'use strict';

	angular.module('cw.resources').factory('Page',
			function($resource, CW_URLS) {
				return $resource(CW_URLS.BASE_PREFIX + '/:pageId', {}, {
					getPage : {
						method : 'GET',
						params : {
							pageId : '@id'
						},
						url : CW_URLS.GET_PAGE
					},
                    getArticles : {
						method : 'GET',
						params : {
							categoryId : '@category'
						},
						url : CW_URLS.GET_ARTICLES
					}
				});
			});
}());
