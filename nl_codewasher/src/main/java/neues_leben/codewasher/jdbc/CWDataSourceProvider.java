package neues_leben.codewasher.jdbc;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;

import neues_leben.DbManager;

public abstract class CWDataSourceProvider extends DbManager {

	@Resource(name = "dataSource")
	private DataSource dataSource;

	@Override
	public abstract Logger getLogger();

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
