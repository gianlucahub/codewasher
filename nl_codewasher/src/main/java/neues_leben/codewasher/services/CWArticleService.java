package neues_leben.codewasher.services;

import java.util.Arrays;
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
import neues_leben.codewasher.models.CWReply;
import neues_leben.codewasher.services.interfaces.CWArticleServiceInterface;

@Service
public class CWArticleService extends CWStatisticService implements CWArticleServiceInterface {

	private final Logger logger = LoggerFactory.getLogger(CWArticleService.class.getName());

	@Autowired
	private CWContentDaoInterface contentDao;

	@Override
	public CWReply addReply(CWReply reply) {
		getLogger().debug("addReply");
		return contentDao.addReply(reply);
	}

	@Override
	public CWArticle getArticle(int id) {
		getLogger().debug("getArticle - Start");
		getLogger().info("getArticle id: " + id);

		CWArticle article = contentDao.getArticle(id);
		article.setArticles(getCategorizedArticles());

		getLogger().debug("getArticle - End");
		return article;
	}

	@Override
	public Set<CWArticle> getArticlesByMacroCategory(String macroCategory) {
		getLogger().debug("getArticlesByMacroCategory - Start");
		getLogger().info("getArticlesByMacroCategory macrocategory: " + macroCategory);

		Set<CWArticle> articles = contentDao.getArticlesByMacroCategory(macroCategory);

		getLogger().debug("getArticlesByMacroCategory - End");
		return articles;
	}

	@Override
	public Map<String, Set<CWArticle>> getCategorizedArticles() {
		getLogger().debug("getCategorizedArticles - Start");

		Map<String, Set<CWArticle>> articles = Arrays.stream(CWArticleCategory.values())
				.collect(Collectors.toMap(category -> category.name(), category -> getArticlesByMacroCategory(category.name())));

		getLogger().debug("getCategorizedArticles - End");
		return articles;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
