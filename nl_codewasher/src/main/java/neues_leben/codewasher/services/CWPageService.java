package neues_leben.codewasher.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neues_leben.codewasher.jdbc.interfaces.CWContentDaoInterface;
import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWArticleCategory;
import neues_leben.codewasher.models.CWContent;
import neues_leben.codewasher.models.CWPage;
import neues_leben.codewasher.services.interfaces.CWArticleServiceInterface;
import neues_leben.codewasher.services.interfaces.CWPageServiceInterface;

@Service
public class CWPageService extends CWStatisticService implements CWPageServiceInterface {

	private final Logger logger = LoggerFactory.getLogger(CWPageService.class.getName());

	@Autowired
	private CWArticleServiceInterface articleService;

	@Autowired
	private CWContentDaoInterface contentDao;

	@Override
	public Map<String, CWContent> getContentsByPage(String page) {
		getLogger().debug("getContentsByPage - Start");
		getLogger().info("getContentsByPage page: " + page);

		List<CWContent> contents = contentDao.getContentsByPage(page);
		Map<String, CWContent> contentsMap = contents.stream()
				.collect(Collectors.toMap(content -> content.getPagePositionId(), content -> content));

		getLogger().debug("getContentsByPage - End");
		return contentsMap;
	}

	@Override
	public CWPage getPage(String pageId) {
		getLogger().debug("getPage - Start");
		getLogger().info("get page: " + pageId);

		CWPage page = new CWPage();

		Map<String, Set<CWArticle>> articles = Arrays.stream(CWArticleCategory.values()).collect(
				Collectors.toMap(category -> category.name(), category -> articleService.getArticlesByMacroCategory(category.name())));
		page.setArticles(articles);

		Map<String, CWContent> contents = getContentsByPage(pageId);
		page.setContents(contents);

		getLogger().debug("getPage - End");
		return page;
	}

	@Override
	public CWPage getArticles(String categoryId) {
		getLogger().debug("getArticles - Start");
		getLogger().info("get category: " + categoryId);

		CWPage page = new CWPage();

		Set<CWArticle> articles = articleService.getArticlesByMacroCategory(categoryId);
		page.setArticleSet(articles);

		Map<String, CWContent> contents = getContentsByPage("articles");
		contents.get("title").setTitle(CWArticleCategory.valueOf(categoryId).getTitle());
		page.setContents(contents);

		getLogger().debug("getArticles - End");
		return page;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
