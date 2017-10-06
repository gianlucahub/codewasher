package neues_leben.codewasher.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import neues_leben.codewasher.jdbc.interfaces.CWStatisticDaoInterface;
import neues_leben.codewasher.models.CWStatistic;

@Service
public class CWStatisticDao extends CWDataSourceProvider implements CWStatisticDaoInterface {

	private final Logger logger = LoggerFactory.getLogger(CWStatisticDao.class.getName());

	@Override
	public void insertStatistic(CWStatistic statistic) {
		getLogger().info("insertStatistic Page: " + statistic.getPage());
		getJdbcTemplate().update("insert into NL_CODEWASHER_STATISTICS (PAGE, STATISTIC_DATE) values (?, ?)", statistic.getPage(),
				statistic.getStatisticDate());
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
