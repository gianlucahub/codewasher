package neues_leben.codewasher.controllers;

import org.slf4j.Logger;

import neues_leben.codewasher.models.CWStatistic;
import neues_leben.codewasher.services.interfaces.CWStatisticsServiceInterface;

public abstract class CWController {

	public abstract Logger getLogger();
	public abstract CWStatisticsServiceInterface getStatisticService();

	public void insertStatistic(String pageId) {
		getLogger().debug("insertStatistic - Start ");
		getLogger().info("insertStatistic page: " + pageId);

		CWStatistic statistic = new CWStatistic();
		statistic.setPage(pageId);
		getStatisticService().insertStatistic(statistic);

		getLogger().debug("insertStatistic - End ");
	}
}
