(function () {
    'use strict';

    angular.module('cw.controllers').controller(
        'PageController',
        function (qpage, qurl, RouterService) {

            var pageCtrl = this;
            pageCtrl.page = qpage;
     
            var title = qpage.contents['title'].title;
            var description = qpage.contents['title'].content;
            var keyWords = qpage.contents['keyWords'].content;
            
            RouterService.setUrl(qurl);
            
            jQuery("meta[name='description']").attr("content", description);
            jQuery("meta[name='keywords']").attr("content", keyWords);
            jQuery(document).prop('title', title);
            jQuery("meta[property='og:url']").attr("content", qurl);
            jQuery("meta[property='og:title']").attr("content", title);
            jQuery("meta[property='og:description']").attr("content", description);
            jQuery("meta[property='og:image']").attr("content", "");
            
            pageCtrl.getArticle = function (id) {
                RouterService.getArticle(id);
            };

        });
}());