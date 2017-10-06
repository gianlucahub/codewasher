package neues_leben.codewasher.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWReply;
import neues_leben.codewasher.services.interfaces.CWArticleServiceInterface;
import neues_leben.codewasher.services.interfaces.CWStatisticsServiceInterface;

@RestController
public class CWArticleController extends CWController {

	private final Logger logger = LoggerFactory.getLogger(CWArticleController.class.getName());

	@Autowired
	private CWArticleServiceInterface articleService;

	@RequestMapping(value = "/reply/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public CWReply addReply(@RequestBody CWReply reply) {
		getLogger().debug("addReply - Start");
		getLogger().info("addReply by " + reply.getName());

		reply = articleService.addReply(reply);

		getLogger().debug("addReply - End");
		return reply;
	}

	@RequestMapping(value = "/article/{id}/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public CWArticle getArticle(@PathVariable("id") Integer articleId) {
		getLogger().debug("getArticle - Start");
		getLogger().info("getArticle id: " + articleId);

		CWArticle article = articleService.getArticle(articleId);
		insertStatistic(article.getTitle());

		getLogger().debug("getArticle - End");
		return article;
	}

	@RequestMapping(value = "/reply/{id}/createEmptyReply", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public CWReply getEmptyReply(@PathVariable("id") Integer articleId) {
		getLogger().debug("getEmptyReply - Start");

		CWReply reply = new CWReply();
		reply.setArticleId(articleId);

		getLogger().debug("getEmptyReply - End");
		return reply;
	}

	@Override
	public CWStatisticsServiceInterface getStatisticService() {
		return articleService;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
