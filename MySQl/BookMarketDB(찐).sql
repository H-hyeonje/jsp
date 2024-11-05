drop database BookMarketDB;
create database BookMarketDB;
USE BookMarketDB;

CREATE TABLE IF NOT EXISTS book(
	bookid VARCHAR(10) NOT NULL,
	bookname VARCHAR(20),
	unitPrice  INTEGER,
	author VARCHAR(20),
	bookdescription TEXT,
	publisher VARCHAR(20),
   	category VARCHAR(20),	
	unitsInStock LONG,
	releaseDate   VARCHAR(20),
	bookcondition VARCHAR(20),
	fileName  VARCHAR(20),
	PRIMARY KEY (bookid)
)default CHARSET=utf8;
select * from book;
desc book;
INSERT INTO book VALUES('ISBN1234', 'C# 프로그래밍', 27000, '우재남','C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.', '한빛아카데미', 'IT모바일', 1000,  '2022/10/06', 'new', 'ISBN1234.png');
INSERT INTO book VALUES('ISBN1235', '자바마스터', 30000, '송미영', '자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. 자바의 이론적 개념→기본 예제→프로젝트 순으로 단계별 학습이 가능하며, 각 챕터의 프로젝트를 실습하면서 온라인 서점을 완성할 수 있도록 구성하였습니다.', '한빛아카데미', 'IT모바일',1000, '2023/01/01', 'new', 'ISBN1235.png');
INSERT INTO book VALUES('ISBN1236', '파이썬 프로그래밍', 30000, '최성철', '파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 또한 프로그래밍의 기초 원리를 이해하면서 파이썬으로 데이터를 처리하는 기법도 배웁니다.', '한빛아카데미', 'IT모바일', 1000, '2023/01/01', 'new', 'ISBN1236.png');
select * from book;
select * from book;

create table member ( 
    id varchar(10) not null,
    password varchar(10) not null,
    name varchar(10) not null,
    gender varchar(4),
    birth  varchar(10),
    mail  varchar(30),
    phone varchar(20),
    address varchar(90),
    regist_day varchar(50),    
    primary key(id) 
) default CHARSET=utf8;

select * from member;
Select * From member where id='aaa' and password='1234';
Select * From member where id=? and password=?;

CREATE TABLE board (
       num int not null auto_increment,
       id varchar(10) not null,
       name varchar(10) not null,
       subject varchar(100) not null,
       content text not null,
       regist_day varchar(30),
       hit int,
       ip varchar(20),
       PRIMARY KEY (num)
)default CHARSET=utf8;

select * from board;
desc board;
Select count(*) from board;
UPDATE member set name='히바맨' where id='aaa';
select * FROM member;
insert into board(id,name,subject,content,regist_day,hit,ip) values('aaa','aaa','aaa','aaaa',now(),1,'a');
delete from member where num=2;
Select * from board;
Select count(*) from board;