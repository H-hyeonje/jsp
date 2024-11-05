create database test10;
use test10;
create table test(
	id varchar(30) primary key,
    password varchar(30),
    name varchar(30)
);

insert into test values("a","1234","김광수");

select * from test;