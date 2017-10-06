(function() {
	'use strict';

	angular.module('cw.services').factory('ArticleService', function(Article) {

		return {
			getArticle : function(article) {
				var res = Article.getArticle({
					articleId : article
				}).$promise.then(function(resArticle) {
					console.log('success, got data: ', resArticle);
					return resArticle;
				}, function(err) {
					alert('request failed');
				});
				return res;
			},
			createEmptyReply : function(article) {
				var res = Article.createEmptyReply({
					articleId : article
				}).$promise.then(function(resReply) {
					console.log('success, got data: ', resReply);
					return resReply;
				}, function(err) {
					alert('request failed');
				});
				return res;
			},
			addReply : function(reply) {
				var res = reply.$addReply().then(function(reply) {
					console.log('success, got data: ', reply);
				}, function(err) {
					alert('request failed');
				});
				return res;
			}
		}
	});
}());
