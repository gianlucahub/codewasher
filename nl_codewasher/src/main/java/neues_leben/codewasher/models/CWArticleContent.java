package neues_leben.codewasher.models;

public class CWArticleContent implements Comparable<CWArticleContent> {

	private int articleId;
	private String content;
	private String contentCode;
	private String contentImage;
	private int id;
	private int sortId;

	@Override
	public int compareTo(CWArticleContent o) {
		return this.sortId > o.getSortId() ? 1 : this.sortId < o.getSortId() ? -1 : 0;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getContent() {
		return content;
	}

	public String getContentCode() {
		return contentCode;
	}

	public String getContentImage() {
		return contentImage;
	}

	public int getId() {
		return id;
	}

	public int getSortId() {
		return sortId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

}
