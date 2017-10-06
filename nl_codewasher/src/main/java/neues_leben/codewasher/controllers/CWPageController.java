package neues_leben.codewasher.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neues_leben.codewasher.models.CWPage;
import neues_leben.codewasher.services.interfaces.CWPageServiceInterface;
import neues_leben.codewasher.services.interfaces.CWStatisticsServiceInterface;

@RestController
public class CWPageController extends CWController {

	private final Logger logger = LoggerFactory.getLogger(CWPageController.class.getName());

	@Autowired
	private CWPageServiceInterface pageService;

	@RequestMapping(value = "/page/{id}/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public CWPage getPage(@PathVariable("id") String pageId) {
		getLogger().debug("getPage - Start ");
		getLogger().info("getPage " + pageId);

		CWPage page = pageService.getPage(pageId);
		insertStatistic(pageId);

		getLogger().debug("getPage - End ");
		return page;
	}

	@RequestMapping(value = "/page/{category}/getArticles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public CWPage getArticles(@PathVariable("category") String categoryId) {
		getLogger().debug("getArticles - Start ");
		getLogger().info("getPage " + categoryId);

		CWPage page = pageService.getArticles(categoryId);
		insertStatistic(categoryId);

		getLogger().debug("getArticles - End ");
		return page;
	}

	@Override
	public CWStatisticsServiceInterface getStatisticService() {
		return pageService;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
