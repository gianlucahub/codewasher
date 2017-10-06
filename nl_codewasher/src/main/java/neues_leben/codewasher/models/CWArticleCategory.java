package neues_leben.codewasher.models;

public enum CWArticleCategory {

	ANGULARJS("ANGULAR JS"), JAVA("JAVA"), WEBDEVELOPMENT("WEB DEVELOPMENT");

	CWArticleCategory(String title) {
		this.title = title;
	}

	private String title;

	public String getTitle() {
		return title;
	}

}
