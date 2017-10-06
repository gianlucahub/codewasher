package neues_leben.codewasher.models;

import java.util.Map;
import java.util.Set;

public class CWPage {

	private Map<String, CWContent> contents;
	private Map<String, Set<CWArticle>> articles;
	private Set<CWArticle> articleSet;

	public Map<String, Set<CWArticle>> getArticles() {
		return articles;
	}

	public Map<String, CWContent> getContents() {
		return contents;
	}

	public void setArticles(Map<String, Set<CWArticle>> articles) {
		this.articles = articles;
	}

	public void setContents(Map<String, CWContent> contents) {
		this.contents = contents;
	}

	public Set<CWArticle> getArticleSet() {
		return articleSet;
	}

	public void setArticleSet(Set<CWArticle> articleSet) {
		this.articleSet = articleSet;
	}

}
