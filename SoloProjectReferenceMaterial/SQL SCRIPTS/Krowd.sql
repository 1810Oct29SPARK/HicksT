CREATE USER juntos
IDENTIFIED BY juntos2

QUOTA 10M ON users;

GRANT CREATE SESSION GRANT ANY PRIVILEGE TO juntos;

GRANT connect to juntos;
GRANT resource to juntos;
GRANT create session TO juntos;
GRANT create table TO juntos;
GRANT create view TO juntos;

conn juntos/juntos2


CREATE TABLE USERS (
       USER_ID INT PRIMARY KEY,
       FIRSTNAME VARCHAR(30),
       LASTNAME VARCHAR(30),
       USERNAME VARCHAR(30),
       EMAIL VARCHAR(30),
       TOKEN_SCORE INT,
       PASSWORD VARCHAR(30),
       PHOTO_ID INT
)

CREATE SEQUENCE user_seq START WITH 1;
CREATE OR REPLACE TRIGGER USER_ID_CREATOR
BEFORE INSERT ON USERS
FOR EACH ROW

BEGIN
SELECT user_seq.NEXTVAL
INTO   :new.user_id
FROM   dual;
END;

commit;

CREATE SEQUENCE event_seq START WITH 100;
CREATE OR REPLACE TRIGGER EVENT_ID_CREATOR
BEFORE INSERT ON EVENTS
FOR EACH ROW

BEGIN
SELECT event_seq.NEXTVAL
INTO   :new.event_id
FROM   dual;
END;

commit;

create table COMMENTS (
	COMMENT_ID INT PRIMARY KEY,
	DATA VARCHAR(250),
	EVENT_ID INT,
    CREATED DATE,
    USER_ID INT
);
/

ALTER TABLE COMMENTS
    ADD FOREIGN KEY (EVENT_ID)
    REFERENCES EVENTS (EVENT_ID);
    
ALTER TABLE COMMENTS 
    ADD FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID);

COMMIT;

CREATE TABLE EVENTS (
       EVENT_ID INT PRIMARY KEY,
       EVENT_NAME VARCHAR(30),
       EVENT_LOCATION VARCHAR(30),
       EVENT_DESCRIPTION VARCHAR(30),
       EVENT_TYPE VARCHAR(30),
       EVENT_DATE DATE,
       USER_ID INT,
       PHOTO_URL VARCHAR(200),
       CREATED DATE
)

COMMIT;

ALTER TABLE COMMENTS ADD PRIMARY KEY(COMMENT_ID);

ALTER TABLE EVENTS
DROP COLUMN PHOTO_ID;

COMMIT;

ALTER TABLE USERS ADD PHOTO_URL VARCHAR (250);

COMMIT;

insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (15, 'Raine', 'Kirton', 'rkirton0', 'rkirton0@tiny.cc', 9, 'jBTuWlLjpHBE', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (1, 'Ethelind', 'Flintoff', 'eflintoff0', 'eflintoff0@thetimes.co.uk', 0, 'vR8HZYA5EH', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (2, 'Lauretta', 'Stemson', 'lstemson1', 'lstemson1@irs.gov', 6, 'EqiX4vrjRW', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (3, 'Ed', 'Moresby', 'emoresby2', 'emoresby2@cnet.com', 0, 'eGNggjZ', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (4, 'Lorne', 'Barszczewski', 'lbarszczewski3', 'lbarszczewski3@adobe.com', 7, 'WT7Z9yGiSD', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (5, 'Marylynne', 'Wilbor', 'mwilbor4', 'mwilbor4@csmonitor.com', 6, '8UPZ1l23Tbg', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (6, 'Cyril', 'Guslon', 'cguslon5', 'cguslon5@parallels.com', 2, 'EjkG99', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (7, 'Starr', 'Leads', 'sleads6', 'sleads6@howstuffworks.com', 4, 'JCbgOm6Sq9f', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (8, 'Joanne', 'Malster', 'jmalster7', 'jmalster7@techcrunch.com', 8, '3tf88I', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (9, 'Jolee', 'Nicolls', 'jnicolls8', 'jnicolls8@ifeng.com', 7, 'WQxVk2FGeAmQ', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (10, 'Gothart', 'Caze', 'gcaze9', 'gcaze9@wunderground.com', 7, 'LYaecdo', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (11, 'Nonah', 'Budcock', 'nbudcocka', 'nbudcocka@arizona.edu', 2, 'DRYXL9', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (12, 'Catharine', 'Whybrow', 'cwhybrowb', 'cwhybrowb@google.com', 7, 'zs1JGZQ6', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (13, 'Guinevere', 'Pickard', 'gpickardc', 'gpickardc@zimbio.com', 3, '0AGuJTW6A', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (14, 'Terrence', 'Vannacci', 'tvannaccid', 'tvannaccid@businesswire.com', 1, 'wMqfswh', null);
insert into USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, EMAIL, TOKEN_SCORE, PASSWORD, PHOTO_URL) values (16, 'Terrence', 'Vannacci', 'tvannaccid', 'tvannaccid@businesswire.com', 1, 'wMqfswh', null);

COMMIT;

-- EVENTS FILL FOR TESTIN
-- COMMENTS FILL FOR TESTING

COMMIT;

--hello

--PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION PAY ATTENTION
-- @TROY
-- ONLY ADD IF YOU HAVE PHOTO_ID, INSTEAD OF PHOTO_URL

--ALTER TABLE USERS
--MODIFY PHOTO_URL VARCHAR2(200);

--
-- CREATION OF THE JUNCTION TABLE USER_EVENTS
--
-- TABLE ROLE:::
-- USERS WHO FOLLOW EVENTS WILL BE UPDATED TO THIS TABLE 
-- 
-- DATA RETRIEVAL:
-- SEARCH FOR USER FOLLOWING LIST BY SEARCHING WHERE THE EVENT ID IS = TO ?
-- ALL RETURNED DATA DISPLAYS ALL USERS WHO FOLLOW THAT EVENT


CREATE TABLE USER_EVENTS(
    USER_ID NOT NULL,
    EVENT_ID NOT NULL,
    CONSTRAINT PK_USER_EVENTS PRIMARY KEY
    (
    USER_ID,
    EVENT_ID
    ),
    FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
    FOREIGN KEY (EVENT_ID) REFERENCES EVENTS (EVENT_ID)
)
-- TEST SCRIPT FOR PULLING USER/EVENT DATA 
SELECT FIRSTNAME, LASTNAME
FROM USER_EVENTS
JOIN USERS ON USERS.USER_ID = USER_EVENTS.USER_ID
JOIN EVENTS ON EVENTS.EVENT_ID = USER_EVENTS.EVENT_ID;

CREATE TABLE USER_FRIENDS(
    USER_ID NOT NULL,
    FOLLOWING_USER_ID NOT NULL,
    CONSTRAINT PK_USER_FRIENDS PRIMARY KEY
    (
    USER_ID,
    FOLLOWING_USER_ID
    ),
    FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
    FOREIGN KEY (FOLLOWING_USER_ID) REFERENCES USERS (USER_ID)
)
-- TEST SCRIPT FOR PULLING USER/FOLLOWING USER DATA 
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME
FROM USER_FRIENDS
JOIN USERS A ON A.USER_ID = USER_FRIENDS.USER_ID
JOIN USERS B ON B.USER_ID = USER_FRIENDS.USER_ID;


COMMIT;

insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (1, null, 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (3, 'Best Event Ever', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (4, 'Ive Never Been TO Better', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (5, 'Troys bash too cool!', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (6, 'Frat 201 always got the best parties', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (7, 'Joes B-day bash too lit', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (8, 'Krowd always hosting the best events', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (9, 'Having the best time at Elias Magic party', 1, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (10, 'Best time ever at 201, no surprise!', 2, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (11, 'Nicks party is so fun', 2, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (12, 'BRO! YOUVE NEVER BEEN TO ONE OF CARLOS PARTIES???', 2, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (13, 'Shout Out to Kaleigh for invite to the BEST EVENT OF 2019', 2, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);
insert into COMMENTS (COMMENT_ID, DATA , EVENT_ID, CREATED, USER_ID) values (14, 'Krowd! you Really Did you Thing With This One!', 2, TO_DATE ('2018-06-09 13:40:32','yyyy-mm-dd hh24:mi:ss'), 16);


COMMIT;



INSERT INTO USER_EVENTS (USER_ID, EVENT_ID) VALUES (16,1);

COMMIT;

ALTER TABLE EVENTS
ADD EVENTS_MAXGUESTS INT;


COMMIT;

ALTER TABLE EVENTS 
MODIFY EVENT_DESCRIPTION VARCHAR2(250);

--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (1, null, '9430 Elgar Street', null, null,TO_DATE ('2018-02-18 00:52:40','yyyy-mm-dd hh24:mi:ss'), 15,TO_DATE('2018-01-21 01:27:17','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (2, null, '9430 Elgar Street', null, null,TO_DATE ('2018-02-18 00:52:40','yyyy-mm-dd hh24:mi:ss'), 16,TO_DATE('2018-01-21 01:27:17','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (3, null, '990 Carioca Lane', null, null,TO_DATE ('2018-06-27 08:04:45','yyyy-mm-dd hh24:mi:ss'), 17, TO_DATE('2018-03-04 10:59:11','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (4, null, '620 Mifflin Lane', null, null, TO_DATE('2018-10-21 01:54:33','yyyy-mm-dd hh24:mi:ss'), 18, TO_DATE('2018-11-17 02:20:23','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (5, null, '993 Farragut Parkway', null, null, TO_DATE('2018-02-12 16:16:43','yyyy-mm-dd hh24:mi:ss'), 19, TO_DATE('2018-06-10 17:54:00','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (6, null, '971 Arapahoe Pass', null, null, TO_DATE('2018-12-23 23:10:13','yyyy-mm-dd hh24:mi:ss'), 20, TO_DATE('2018-05-06 03:44:37','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (7, null, '24 Carey Parkway', null, null, TO_DATE('2018-08-16 10:17:10','yyyy-mm-dd hh24:mi:ss'), 21, TO_DATE('2018-07-10 16:34:19','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (8, null, '4262 Northwestern Junction', null, null, TO_DATE('2018-10-13 22:02:21','yyyy-mm-dd hh24:mi:ss'), 22, TO_DATE('2018-12-27 21:17:46','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (9, null, '7 Sachs Terrace', null, null, TO_DATE('2018-02-15 03:50:25','yyyy-mm-dd hh24:mi:ss'), 23, TO_DATE('2018-12-18 12:25:45','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (10, null, '31 Hermina Alley', null, null, TO_DATE('2018-11-28 07:00:00','yyyy-mm-dd hh24:mi:ss'), 24, TO_DATE('2018-05-31 11:07:58','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (11, null, '8791 Dovetail Hill', null, null, TO_DATE('2018-11-26 20:36:54','yyyy-mm-dd hh24:mi:ss'), 25, TO_DATE('2018-10-06 14:12:40','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (12, null, '57 Manufacturers Road', null, null, TO_DATE('2018-07-20 03:55:49','yyyy-mm-dd hh24:mi:ss'), 26, TO_DATE('2019-01-07 16:35:51','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (13, null, '700 Blaine Center', null, null, TO_DATE('2018-04-25 12:19:44','yyyy-mm-dd hh24:mi:ss'), 27, TO_DATE('2018-07-27 04:49:50','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (14, null, '60 Monica Circle', null, null, TO_DATE('2018-07-21 12:40:07','yyyy-mm-dd hh24:mi:ss'), 28, TO_DATE('2018-09-05 14:00:41','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (15, null, '3762 Leroy Plaza', null, null, TO_DATE('2018-01-13 05:59:10','yyyy-mm-dd hh24:mi:ss'), 29, TO_DATE('2018-02-28 18:13:41','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (16, null, '5765 Memorial Circle', null, null, TO_DATE('2018-08-13 17:45:46','yyyy-mm-dd hh24:mi:ss'), 30, TO_DATE('2018-05-07 13:50:09','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (17, null, '55 Crescent Oaks Road', null, null, TO_DATE('2018-02-08 18:47:19','yyyy-mm-dd hh24:mi:ss'), 31, TO_DATE('2018-05-28 12:27:49','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (18, null, '5589 Raven Street', null, null, TO_DATE('2018-03-09 05:36:19','yyyy-mm-dd hh24:mi:ss'), 32, TO_DATE('2018-03-13 21:46:41','yyyy-mm-dd hh24:mi:ss'), null);
--insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL) values (19, null, '4 Old Gate Pass', null, null, TO_DATE('2018-09-11 19:01:24','yyyy-mm-dd hh24:mi:ss'), 33, TO_DATE('2018-10-20 23:46:43','yyyy-mm-dd hh24:mi:ss'), null);

COMMIT;

insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (1, '', '9430 Elgar Street', '', 'Outdoors',TO_DATE ('2018-02-18 08:52:40','yyyy-mm-dd hh24:mi:ss'), 15,TO_DATE('2018-01-21 01:27:17','yyyy-mm-dd hh24:mi:ss'), 'http://www.peeblescycling.org/wp-content/uploads/2011/11/road1rev.jpg', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (2, '', '9430 Elgar Street', 'Swing by for some late night hoops set to upbeat urban music.', 'Sports',TO_DATE ('2018-02-18 00:52:40','yyyy-mm-dd hh24:mi:ss'), 16,TO_DATE('2018-01-21 01:27:17','yyyy-mm-dd hh24:mi:ss'), 'https://i.ytimg.com/vi/YIQfEYYnRZc/maxresdefault.jpg', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (3, '', '990 Carioca Lane', '', '',TO_DATE ('2018-06-27 08:04:45','yyyy-mm-dd hh24:mi:ss'), 17, TO_DATE('2018-03-04 10:59:11','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (4, '', '620 Mifflin Lane', '', 'Food & Drink', TO_DATE('2018-10-21 01:54:33','yyyy-mm-dd hh24:mi:ss'), 18, TO_DATE('2018-11-17 02:20:23','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (5, '', '993 Farragut Parkway', '', 'Food & Drink', TO_DATE('2018-02-12 16:16:43','yyyy-mm-dd hh24:mi:ss'), 19, TO_DATE('2018-06-10 17:54:00','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (6, '', '971 Arapahoe Pass', '', '', TO_DATE('2018-12-23 23:10:13','yyyy-mm-dd hh24:mi:ss'), 20, TO_DATE('2018-05-06 03:44:37','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (7, '', '24 Carey Parkway', '', 'Sports', TO_DATE('2018-08-16 10:17:10','yyyy-mm-dd hh24:mi:ss'), 21, TO_DATE('2018-07-10 16:34:19','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (8, '', '4262 Northwestern Junction', '', 'Volunteering', TO_DATE('2018-10-13 22:02:21','yyyy-mm-dd hh24:mi:ss'), 22, TO_DATE('2018-12-27 21:17:46','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (9, '', '7 Sachs Terrace', '', 'Art', TO_DATE('2018-02-15 03:50:25','yyyy-mm-dd hh24:mi:ss'), 23, TO_DATE('2018-12-18 12:25:45','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (10, '', '31 Hermina Alley', '', 'Art', TO_DATE('2018-11-28 07:00:00','yyyy-mm-dd hh24:mi:ss'), 24, TO_DATE('2018-05-31 11:07:58','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (11, '', '8791 Dovetail Hill', '', 'Music', TO_DATE('2018-11-26 20:36:54','yyyy-mm-dd hh24:mi:ss'), 25, TO_DATE('2018-10-06 14:12:40','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (12, '', '57 Manufacturers Road', '', 'Volunteering', TO_DATE('2018-07-20 03:55:49','yyyy-mm-dd hh24:mi:ss'), 26, TO_DATE('2019-01-07 16:35:51','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (13, '', '700 Blaine Center', '', 'Music', TO_DATE('2018-04-25 12:19:44','yyyy-mm-dd hh24:mi:ss'), 27, TO_DATE('2018-07-27 04:49:50','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (14, '', '60 Monica Circle', '', 'Outdoors', TO_DATE('2018-07-21 12:40:07','yyyy-mm-dd hh24:mi:ss'), 28, TO_DATE('2018-09-05 14:00:41','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (15, '', '3762 Leroy Plaza', '', 'Outdoors', TO_DATE('2018-01-13 05:59:10','yyyy-mm-dd hh24:mi:ss'), 29, TO_DATE('2018-02-28 18:13:41','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (16, '', '5765 Memorial Circle', '', 'Outdoors', TO_DATE('2018-08-13 17:45:46','yyyy-mm-dd hh24:mi:ss'), 30, TO_DATE('2018-05-07 13:50:09','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (17, '', '55 Crescent Oaks Road', '', 'Outdoors', TO_DATE('2018-02-08 18:47:19','yyyy-mm-dd hh24:mi:ss'), 31, TO_DATE('2018-05-28 12:27:49','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (18, '', '5589 Raven Street', '', 'Art', TO_DATE('2018-03-09 05:36:19','yyyy-mm-dd hh24:mi:ss'), 32, TO_DATE('2018-03-13 21:46:41','yyyy-mm-dd hh24:mi:ss'), '', 5);
insert into EVENTS (EVENT_ID, EVENT_NAME, EVENT_LOCATION, EVENT_DESCRIPTION, EVENT_TYPE, EVENT_DATE, USER_ID, CREATED, PHOTO_URL, EVENTS_MAXGUESTS) values (19, '', '4 Old Gate Pass', '', 'Volunteering', TO_DATE('2018-09-11 19:01:24','yyyy-mm-dd hh24:mi:ss'), 33, TO_DATE('2018-10-20 23:46:43','yyyy-mm-dd hh24:mi:ss'), '', 5);

COMMIT;COMMIT;


ALTER TABLE USERS
DROP COLUMN FOLLOWING_USER_ID;