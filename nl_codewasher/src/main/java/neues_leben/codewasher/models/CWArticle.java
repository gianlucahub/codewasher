package neues_leben.codewasher.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CWArticle implements Comparable<CWArticle> {

	private int id;
	private List<CWArticleContent> articleContents;
	private Date articleDate;
	private Map<String, Set<CWArticle>> articles;
	private String content;
	private String keyWords;
	private String macroCategory;
	private boolean repliable;
	private List<CWReply> replies = new ArrayList<>();
	private String title;
	private String iconPath;

	@Override
	public int compareTo(CWArticle o) {
		return this.title.compareTo(o.getTitle());
	}

	public List<CWArticleContent> getArticleContents() {
		return articleContents;
	}

	public Date getArticleDate() {
		return articleDate;
	}

	public Map<String, Set<CWArticle>> getArticles() {
		return articles;
	}

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public String getMacroCategory() {
		return macroCategory;
	}

	public List<CWReply> getReplies() {
		return replies;
	}

	public String getTitle() {
		return title;
	}

	public boolean isRepliable() {
		return repliable;
	}

	public void setArticleContents(List<CWArticleContent> articleContents) {
		this.articleContents = articleContents;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	public void setArticles(Map<String, Set<CWArticle>> articles) {
		this.articles = articles;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public void setMacroCategory(String macroCategory) {
		this.macroCategory = macroCategory;
	}

	public void setRepliable(boolean repliable) {
		this.repliable = repliable;
	}

	public void setReplies(List<CWReply> replies) {
		this.replies = replies;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

}
