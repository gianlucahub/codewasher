package neues_leben.codewasher.jdbc;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import neues_leben.codewasher.jdbc.interfaces.CWContentDaoInterface;
import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWArticleContent;
import neues_leben.codewasher.models.CWContent;
import neues_leben.codewasher.models.CWReply;

@Service("cwContentDao")
public class CWContentDao extends CWDataSourceProvider implements CWContentDaoInterface {

	private final Logger logger = LoggerFactory.getLogger(CWContentDao.class.getName());

	private final String sqlArticle = "select art.id as article_id, art.title, art.content, art.macro_category, art.repliable, art.key_words, art.icon_path, art.article_date, rpl.id as reply_id, rpl.name, rpl.content as reply_content, rpl.reply_date from NL_CODEWASHER_REPLY rpl RIGHT JOIN NL_CODEWASHER_ARTICLE art ON art.id = rpl.article_id ";
	private final String sqlArticleContent = "select * from NL_CODEWASHER_ARTICLE_CONTENT where article_id = ?";
	private final String sqlContent = "select id , title, content, page, page_position_id from NL_CODEWASHER_CONTENT ";

	@Override
	public CWArticle getArticle(int id) {
		getLogger().info("getArticle id: " + id);
		List<Map<String, Object>> articles = getJdbcTemplate().queryForList(sqlArticle + " WHERE art.id= ?", new Object[] { id });
		return articlesMapper(articles).iterator().next() != null ? articlesMapper(articles).iterator().next() : null;
	}

	@Override
	public List<CWArticleContent> getArticleContents(int articleId) {
		getLogger().info("getArticleContents articleid: " + articleId);
		List<CWArticleContent> contents = getJdbcTemplate().query(sqlArticleContent, new Object[] { articleId }, articleContentMapper);
		return contents;
	}

	@Override
	public Set<CWArticle> getArticlesByMacroCategory(String macroCategory) {
		getLogger().info("getArticlesByMacroCategory macrocategory: " + macroCategory);
		List<Map<String, Object>> articles = getJdbcTemplate().queryForList(sqlArticle + " WHERE macro_category = ?",
				new Object[] { macroCategory });
		return articlesMapper(articles);
	}

	@Override
	public CWContent getContentByPageAndPagePositionId(String page, String pagePositionId) {
		getLogger().info("getContentByPageAndPagePositionId Page: " + page + " PositionId " + pagePositionId);
		CWContent content = getJdbcTemplate().queryForObject(sqlContent + " WHERE page = ? and page_position_id = ?",
				new Object[] { page, pagePositionId }, contentMapper);
		return content;
	}

	@Override
	public List<CWContent> getContentsByPage(String page) {
		getLogger().info("getContentsByPage Page: " + page);
		List<CWContent> contents = getJdbcTemplate().query(sqlContent + " WHERE page = ? ", new Object[] { page }, contentMapper);
		return contents;
	}

	@Override
	public CWReply addReply(CWReply reply) {
		getLogger().info("addReply by " + reply.getName());
		getJdbcTemplate().update("insert into NL_CODEWASHER_REPLY (content, name, article_id) values (?, ?, ?)", reply.getContent(),
				reply.getName(), reply.getArticleId());
		return reply;
	}

	private RowMapper<CWArticleContent> articleContentMapper = (rs, rowNum) -> {
		CWArticleContent content = null;

		content = new CWArticleContent();
		content.setId(rs.getInt("id"));
		content.setContent(rs.getString("content"));
		content.setContentCode(rs.getString("content_code"));
		content.setContentImage(rs.getString("content_image"));
		content.setSortId(rs.getInt("sort_id"));

		return content;
	};
	private RowMapper<CWContent> contentMapper = (rs, rowNum) -> {
		CWContent content = null;

		content = new CWContent();
		content.setId(rs.getInt("id"));
		content.setTitle(rs.getString("title"));
		content.setContent(rs.getString("content"));
		content.setPage(rs.getString("page"));
		content.setPagePositionId(rs.getString("page_position_id"));

		return content;
	};

	private Set<CWArticle> articlesMapper(List<Map<String, Object>> rows) {
		Map<Integer, CWArticle> articleCheck = new HashMap<>();
		Set<CWArticle> articles = new TreeSet<>();

		rows.forEach(row -> {
			CWArticle article = articleCheck.get(row.get("article_id"));
			if (article == null) {
				article = new CWArticle();
				article.setId((Integer) row.get("article_id"));
				article.setTitle((String) row.get("title"));
				article.setContent((String) row.get("content"));
				article.setMacroCategory((String) row.get("macro_category"));
				article.setRepliable((Boolean) row.get("repliable"));
				article.setKeyWords((String) row.get("key_words"));
				article.setIconPath((String) row.get("icon_path"));
				article.setArticleDate((Date) row.get("article_date"));
				articleCheck.put(article.getId(), article);

				List<CWArticleContent> contents = getArticleContents(article.getId());
				Collections.sort(contents);
				article.setArticleContents(contents);
			}

			if (row.get("reply_id") != null) {
				CWReply reply = new CWReply();
				reply.setId((Integer) row.get("reply_id"));
				reply.setName((String) row.get("name"));
				reply.setContent((String) row.get("reply_content"));
				reply.setReplyDate((Date) row.get("reply_date"));
				reply.setArticleId((Integer) row.get("article_id"));

				article.getReplies().add(reply);
			}

			articles.add(article);

		});

		return articles;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
