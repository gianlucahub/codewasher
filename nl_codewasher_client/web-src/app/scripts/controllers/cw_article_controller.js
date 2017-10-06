(function() {
	'use strict';

	angular.module('cw.controllers').controller('ArticleController',
			function($route, $scope, $timeout, qarticle, qurl, RouterService, ArticleService) {

				var articleCtrl = this;
				articleCtrl.article = qarticle;
				articleCtrl.replyInputOn = false;
		        
				var title = qarticle.title;
	            var description = qarticle.content;
	            var keywords = qarticle.keyWords;
	            
	            RouterService.setUrl(qurl);
                	            	            
				jQuery("meta[name='description']").attr("content", description);
	            jQuery("meta[name='keywords']").attr("content", keywords);
                jQuery(document).prop('title', title);
	            jQuery("meta[property='og:url']").attr("content", qurl);
                jQuery("meta[property='og:title']").attr("content", title);
                jQuery("meta[property='og:description']").attr("content", description);
                jQuery("meta[property='og:image']").attr("content", "");
        
        
                $scope.$watch ("articleCtrl.article", function(newValue, oldValue) {
                    if(typeof(newValue) !== "undefined" && newValue!== null) {
                        $timeout(prettyPrint, 0);               
                    }  
                });
                                
				articleCtrl.getArticle = function(id) {
					RouterService.getArticle(id);
				};

				articleCtrl.createEmptyReply = function(articleId) {
					ArticleService.createEmptyReply(articleId).then(function(result) {
						articleCtrl.replyInput = result;
						articleCtrl.replyInputOn = true;
					}, function failure(error) {

					});
				};
				
				articleCtrl.addReply = function(reply) {
					ArticleService.addReply(reply).then(function(result) {
						articleCtrl.replyInputOn = false;
						$route.reload();
					}, function failure(error) {

					});
				};
				
				articleCtrl.cancelReply = function() {
					articleCtrl.replyInputOn = false;
				};
        
			});
}());
