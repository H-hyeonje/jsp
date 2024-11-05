create database jsbookdb;
use jsbookdb;
create table if not exists member(
	id varchar(20) not null primary key,
    passwd varchar(20),
    Name varchar(30)
    );
    
select *from member;
select *from member;
insert into member values();
delete from member;