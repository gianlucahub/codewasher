(function() {
	'use strict';

	var urlPrefix = '$urlprefix';
	//var urlPrefix = 'http://localhost:8080/nl_codewasher/neues_leben_codewasher/';
	//var urlPrefix = 'http://www.codewasher.com/nl_codewasher/neues_leben_codewasher/';
	
	angular.module('cw.config').constant('CW_URLS', {

		BASE_PREFIX : urlPrefix,
		GET_PAGE : urlPrefix + 'page/:pageId/get',
		GET_ARTICLES : urlPrefix + 'page/:categoryId/getArticles',
		GET_ARTICLE : urlPrefix + 'article/:articleId/get',
		CREATE_EMPTY_REPLY : urlPrefix + 'reply/:articleId/createEmptyReply',
		ADD_REPLY : urlPrefix + 'reply/add',
		
	});
}());
