package neues_leben.codewasher.jdbc.interfaces;

import java.util.List;
import java.util.Set;

import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWArticleContent;
import neues_leben.codewasher.models.CWContent;
import neues_leben.codewasher.models.CWReply;

public interface CWContentDaoInterface {

	CWReply addReply(CWReply reply);

	CWArticle getArticle(int id);

	List<CWArticleContent> getArticleContents(int articleId);

	Set<CWArticle> getArticlesByMacroCategory(String macroCategory);

	CWContent getContentByPageAndPagePositionId(String page, String pagePositionId);

	List<CWContent> getContentsByPage(String page);
}
