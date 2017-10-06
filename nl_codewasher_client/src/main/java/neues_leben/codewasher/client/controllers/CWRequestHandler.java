package neues_leben.codewasher.client.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import neues_leben.codewasher.jdbc.CWContentDao;
import neues_leben.codewasher.models.CWArticle;
import neues_leben.codewasher.models.CWContent;

public class CWRequestHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(CWRequestHandler.class.getName());

	@Override
	public void destroy() {
		logger.debug("destroy");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		logger.debug("init");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("service - Start");

		String title = null;
		String description = null;
		String keywords = null;
		String url = (String) request.getAttribute("javax.servlet.error.request_uri");

		if (url.contains("bower_components") || url.contains("iconPath")) {
			return;
		}

		WebApplicationContext wac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

		CWContentDao contentDao = wac1.getBean(neues_leben.codewasher.jdbc.CWContentDao.class);
		if (url.contains("/home")) {
			String page = url.substring(url.lastIndexOf("/") + 1, url.length());
			CWContent content = contentDao.getContentByPageAndPagePositionId(page, "title");
			title = content.getTitle();
			description = content.getContent();
			content = contentDao.getContentByPageAndPagePositionId(page, "keyWords");
			keywords = content.getContent();
		} else if (url.contains("/article/")) {
			String articleId = url.substring(url.lastIndexOf("/") + 1, url.length());
			CWArticle article = contentDao.getArticle(Integer.parseInt(articleId));
			title = article.getTitle();
			description = article.getContent();
			keywords = article.getKeyWords();
		} else if (url.contains("/articles")) {
			String page = "articles";
			CWContent content = contentDao.getContentByPageAndPagePositionId(page, "title");
			title = content.getTitle();
			description = content.getContent();
			content = contentDao.getContentByPageAndPagePositionId(page, "keyWords");
			keywords = content.getContent();
		}

		String titolo = "<title></title>";
		String kywds = "$keyWords";
		String descr = "$description";
		String facebookUrl = "$facebookUrl";
		String facebookTitle = "$facebookTitle";
		String facebookDescription = "$facebookDescription";
		String facebookImage = "$facebookImage";

		InputStream is = this.getClass().getClassLoader().getResourceAsStream("index.html");

		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String line = null;

		StringBuffer sb = new StringBuffer();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		String index = sb.toString();

		index = index.replace(titolo, "<title>" + title + "</title>");
		index = index.replace(kywds, keywords);
		index = index.replace(descr, description);

		index = index.replace(facebookUrl, url);
		index = index.replace(facebookTitle, title);
		index = index.replace(facebookDescription, description);
		index = index.replace(facebookImage, "");

		PrintWriter out = response.getWriter();
		out.println(index);

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");

		logger.debug("service - End");
	}

}
