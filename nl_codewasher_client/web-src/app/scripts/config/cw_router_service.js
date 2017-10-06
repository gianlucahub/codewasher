(function() {
	'use strict';

	angular.module('cw.config').factory(
			'RouterService',
			function($location) {
				this.url;
				return {
					getArticle : function(id) {
						$location.path('/neues_leben_codewasher/article/' + id);
					},
					toPage : function(page) {
						$location.path('/neues_leben_codewasher/page/' + page);
					},
                    toPageArticles : function(category) {
						$location.path('/neues_leben_codewasher/articles/' + category);
					},
					setUrl : function(urlParm) {
						this.url = urlParm;
					}
				}	
			});
		
}());
