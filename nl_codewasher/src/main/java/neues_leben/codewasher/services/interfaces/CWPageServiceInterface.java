package neues_leben.codewasher.services.interfaces;

import java.util.Map;

import neues_leben.codewasher.models.CWContent;
import neues_leben.codewasher.models.CWPage;

public interface CWPageServiceInterface extends CWStatisticsServiceInterface {

	Map<String, CWContent> getContentsByPage(String page);

	CWPage getPage(String page);

	CWPage getArticles(String categoryId);

}
