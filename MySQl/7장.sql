DROP DATABASE IF EXISTS market_db; -- 만약 market_db가 존재하면 우선 삭제한다.
CREATE DATABASE market_db;

USE market_db;
CREATE TABLE member -- 회원 테이블
( mem_id  		CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  mem_name    	VARCHAR(10) NOT NULL, -- 이름
  mem_number    INT NOT NULL,  -- 인원수
  addr	  		CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  phone1		CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2		CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 평균 키
  debut_date	DATE  -- 데뷔 일자
);
CREATE TABLE buy -- 구매 테이블
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   mem_id  	CHAR(8) NOT NULL, -- 아이디(FK)
   prod_name 	CHAR(6) NOT NULL, --  제품이름
   group_name 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 가격
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (mem_id) REFERENCES member(mem_id)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

SELECT * FROM member;
SELECT * FROM buy;

create view v_member
	as
		select mem_id,mem_name,addr from member;
        
select * from v_member;
select * from member;
select mem_name, addr
 from v_member
 where addr in("서울","경기");
 
 
 select b.mem_id,m.mem_name, b.prod_name, m.addr,concat(m.phone1,m.phone2) '연락처'
	from buy b
		inner join member m
        on b.mem_id=m.mem_id;
        
create view v_memberbuy
as
 select b.mem_id,m.mem_name, b.prod_name, m.addr,concat(m.phone1,m.phone2) '연락처'
	from buy b
		inner join member m
        on b.mem_id=m.mem_id;
        
select * from v_memberbuy where mem_name='블랙핑크';

create view v_viewrest1
as 
	select b.mem_id `Member id` , m.mem_name as `Member Name`,b.prod_name "product Name",concat(m.phone1,m.phone2) as "ofice phon"
	from buy b
		inner join member m
        on b.mem_id=m.mem_id;
        
select distinct `Member id`, `Member Name`, `product Name`, `ofice phon` from v_viewrest1;

update v_member set addr='부산' where mem_id="blk";
select mem_id,addr from member where mem_id="blk";
select mem_id,addr from v_member where mem_id="blk";		

insert into v_member(mem_id,mem_name,addr) values ("bts","방탄소년단","경기");

create view v_height167
as
	select * from member where height >=167;

select * from v_height167;

delete from v_height167 where height <167;

insert into v_height167 values("tra","티아라",6,"서울",null,null,159,"2005-01-01");
select * from v_height167;
select * from v_height167 where mem_id="tra";
select * from member where mem_id="tra";

alter view v_height167
as
	select*from member where height>=167
    with check option;
    
insert into v_height167 values("tob","텔레토비",4,"영국",null,null,140,"1995-01-01");


drop procedure if exists user_proc;
delimiter $$
create procedure user_proc()
begin
	select *from member where mem_number <= 5;
end $$
delimiter ;

call user_proc();

drop procedure if exists user_proc1;
delimiter $$
create procedure user_proc1(in userName varchar(10))
    begin
    select *from member where mem_name= userName;
end $$
delimiter ;

call user_proc1("에이핑크");


drop procedure if exists user_proc2;
delimiter $$
create procedure user_proc2(
	in userMember int,
    in userheight int
)
begin
select * from member 
	where mem_number > userMember and height > userheight;
end $$
delimiter ;

call user_proc2(5,165);

drop procedure if exists user_proc3;
delimiter $$
create procedure user_proc3(
	in txtvalue char(10),
    out outvalue int
)
begin
insert into notable values(null,txtvalue);
select max(id) into outvalue from notable;
end $$
delimiter ;
desc notable;

create table if not exists notable(
	id int auto_increment primary key,
    txt char(10));
    
call user_proc3('테스트1',@myvalue);
select concat('입력된 id 값 ==>',@myvalue);

drop procedure if exists ifelse_proc;
delimiter $$
create procedure ifelse_proc(
	in memName varchar(10)
) 
begin
	declare debutyear int;
    select year(debut_date) into debutyear From member
		where mem_name=memName;
        if(debutyear>=2015)then
			select '신인 가수네요. 화이팅 하세요.' as "메세지" ;
		else
         select '고참 가수네요. 그동안 수고하셨습니다.' as "메세지" ;
         end if;
end $$
delimiter ;

call ifelse_proc("blk");


drop procedure if exists dynamic_proc;
delimiter $$
create procedure dynamic_proc(
	in tableName varchar(20)
)
begin
	set @sqlquery = concat('select * from ',tableName);
    prepare stmt from @sqlquery;
    execute stmt;
    deallocate prepare stmt;
end $$
delimiter ;

call dynamic_proc('member');    


