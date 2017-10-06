package neues_leben.codewasher.models;

import java.util.Date;

public class CWReply {

	private int articleId;
	private String content;
	private int id;
	private String name;
	private Date replyDate;

	public int getArticleId() {
		return articleId;
	}

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

}
