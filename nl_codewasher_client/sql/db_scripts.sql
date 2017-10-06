create database neues_leben;

CREATE TABLE neues_leben.NL_CODEWASHER_ARTICLE
(
ID INT NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(250) NOT NULL,
CONTENT LONGTEXT NOT NULL,
PAGE VARCHAR(50) NOT NULL,
MACRO_CATEGORY VARCHAR(50),
REPLIABLE TINYINT(1),
ARTICLE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (ID)
);
INSERT INTO neues_leben.NL_CODEWASHER_ARTICLE(TITLE, CONTENT, PAGE, MACRO_CATEGORY, REPLIABLE) VALUES ('Create a Rest webservice with SpringMVC', 'Let''s see how to create a Rest webservice with SpringMVC.', 'ND', 'JAVA', 1);
INSERT INTO neues_leben.NL_CODEWASHER_ARTICLE(TITLE, CONTENT, PAGE, MACRO_CATEGORY, REPLIABLE) VALUES ('Build a web application structure with Gulp', 'Let''s see how to build a web application structure Gulp.', 'ND', 'WEBDEVELOPMENT', 1);
INSERT INTO neues_leben.NL_CODEWASHER_ARTICLE(TITLE, CONTENT, PAGE, MACRO_CATEGORY, REPLIABLE) VALUES ('Dynamic title in a Single Page Application by AngularJs', 'Single Page Application is currently the best practise to build the front end of an application, but it can be a bit tricky to update the title as that tag is in common
with all the views and templates of the application. So let''s see how we can manage it, easily by Angular.', 'ND', 'ANGULARJS', 1);
INSERT INTO neues_leben.NL_CODEWASHER_ARTICLE(TITLE, CONTENT, PAGE, MACRO_CATEGORY, REPLIABLE) VALUES ('Single Page Application by Angular using templates and routing', 'In this article we will see how to easily implement a Single Page Application by Angular using templates and routing.', 'ND', 'ANGULARJS', 1);

ALTER TABLE `NL_CODEWASHER_ARTICLE` ADD COLUMN KEY_WORDS LONGTEXT AFTER REPLIABLE;

DELIMITER ;;
CREATE TRIGGER `cw_article_date` BEFORE INSERT ON `nl_codewasher_article` FOR EACH ROW
BEGIN
    SET NEW.ARTICLE_DATE = NOW();
END;;
DELIMITER ;

CREATE TABLE neues_leben.NL_CODEWASHER_ARTICLE_CONTENT
(
ID INT NOT NULL AUTO_INCREMENT,
CONTENT LONGTEXT NOT NULL,
CONTENT_CODE LONGTEXT,
CONTENT_IMAGE VARCHAR(150),
ARTICLE_ID INT,
PRIMARY KEY (ID)
);
ALTER TABLE `nl_codewasher_article_content` ADD COLUMN CONTENT_IMAGE VARCHAR(150) AFTER CONTENT_CODE;
ALTER TABLE `nl_codewasher_article_content` ADD COLUMN SORT_ID SMALLINT AFTER CONTENT_IMAGE;
	

CREATE TABLE neues_leben.NL_CODEWASHER_CONTENT
(
ID INT NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(250) NOT NULL,
CONTENT LONGTEXT NOT NULL,
PAGE VARCHAR(50) NOT NULL,
PAGE_POSITION_ID VARCHAR(50),
PRIMARY KEY (ID)
);
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('Aboutme', 'I am Gianluca, working already 15 years in programming, at first on the great old As400 in Rpg, then since 2007 enjoying Java universe. Lately I fall in love with web technologies, particularly AngularJs...only 1 so far but soon I am sure I will be involved in AngularJs 2 as well :D :D :D ', 'about', 'aboutme' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('About this website', 'I made this website using Spring Core, Mvc and JdbcTemplates, AngularJs 1, Bootstrap, Npm, Bower and Gulp. Storage by MySql. It runs on Tomcat 8 and Java 8. Better graphic coming soon... I have built this website just for fun, nothing serious but maybe it will help some fellow who, like me, sometimes gets stuck and crazy with code....in this case I will be happy to be helpful...ciao!   ) ', 'about', 'aboutsite' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('Contact', 'greencard@inwind.it', 'contact', 'contact' );

INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - Home', 'The home page of the Codewasher website. There are basically some collections of articles about different topics, mainly technical solutions and suggestions, and pieces of code.', 'home', 'title' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - About me', 'Page which describes myself Gianluca De Vecchi, my professional skills and personal aspects. There are also some notes about the site.', 'about', 'title' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - Contact', 'There are some contacts to reach the author of the website, Gianluca De Vecchi. He is a programmer and makes websites. It is possible to contact him for contracts or single activities, or just to have a chat with him.', 'contact', 'title' );

INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - Home', 'codewasher homepage java angularjs programming codehelper', 'home', 'keyWords' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - About me', 'codewasher aboutme java angularjs programming codehelper', 'about', 'keyWords' );
INSERT INTO neues_leben.NL_CODEWASHER_CONTENT (TITLE, CONTENT, PAGE, PAGE_POSITION_ID) VALUES ('The codewasher - Contact', 'codewasher contact java angularjs programming codehelper', 'contact', 'keyWords' );


CREATE TABLE neues_leben.NL_CODEWASHER_REPLY
(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(250),
CONTENT TEXT,
REPLY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
ARTICLE_ID INT,
PRIMARY KEY (ID)
);

CREATE TABLE neues_leben.NL_CODEWASHER_STATISTICS
(
ID INT NOT NULL AUTO_INCREMENT,
PAGE VARCHAR(250),
STATISTIC_DATE DATETIME,
PRIMARY KEY (ID)
);


