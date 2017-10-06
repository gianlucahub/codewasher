package neues_leben;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DbManager {

	private JdbcTemplate jdbcTemplate;

	public abstract DataSource getDataSource();
	public abstract Logger getLogger();

	protected JdbcTemplate getJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
}
