package neues_leben.codewasher.models;

import java.util.Date;

public class CWStatistic {

	private int id;
	private String page;
	private Date statisticDate;

	public int getId() {
		return id;
	}

	public String getPage() {
		return page;
	}

	public Date getStatisticDate() {
		return statisticDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}

}
