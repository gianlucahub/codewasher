package neues_leben.codewasher.services.interfaces;

import java.util.Map;
import java.util.Set;

import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWReply;

public interface CWArticleServiceInterface extends CWStatisticsServiceInterface {

	CWReply addReply(CWReply reply);

	CWArticle getArticle(int id);

	Set<CWArticle> getArticlesByMacroCategory(String macroCategory);

	Map<String, Set<CWArticle>> getCategorizedArticles();

}
