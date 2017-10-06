package neues_leben.codewasher.services;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import neues_leben.codewasher.jdbc.interfaces.CWStatisticDaoInterface;
import neues_leben.codewasher.models.CWStatistic;
import neues_leben.codewasher.services.interfaces.CWStatisticsServiceInterface;

public abstract class CWStatisticService implements CWStatisticsServiceInterface {

	public abstract Logger getLogger();

	@Autowired
	private CWStatisticDaoInterface statisticDao;

	@Override
	public void insertStatistic(CWStatistic statistic) {
		getLogger().debug("insertStatistic - Start");
		getLogger().info("insertStatistic page: " + statistic.getPage());

		statistic.setStatisticDate(new Date());
		statisticDao.insertStatistic(statistic);

		getLogger().debug("insertStatistic - End");
	}
}
