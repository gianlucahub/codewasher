package neues_leben.codewasher.models;

public class CWContent {

	private String content;
	private int id;
	private String page;
	private String pagePositionId;
	private String title;

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public String getPage() {
		return page;
	}

	public String getPagePositionId() {
		return pagePositionId;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setPagePositionId(String pagePositionId) {
		this.pagePositionId = pagePositionId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
