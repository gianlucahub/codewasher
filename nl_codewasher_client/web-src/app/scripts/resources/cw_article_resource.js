(function() {
	'use strict';

	angular.module('cw.resources').factory('Article',
			function($resource, CW_URLS) {
				return $resource(CW_URLS.BASE_PREFIX + '/:articleId', {}, {
					getArticle : {
						method : 'GET',
						params : {
							articleId : '@id'
						},
						url : CW_URLS.GET_ARTICLE
					},
					createEmptyReply : {
						method : 'GET',
						params : {
							articleId : '@id'
						},
						url : CW_URLS.CREATE_EMPTY_REPLY
					},
					addReply: {
		                method: 'PUT',
		                url: CW_URLS.ADD_REPLY
					}
				});
			});
}());
