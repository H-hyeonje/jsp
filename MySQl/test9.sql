-- Step1 :데이터 베이스 생성(DDL)
create database test9;

-- Step1-2 : 데이터 베이스 생성 확인 (DDL)
show databases;

-- Step1-3 : 사용선언
use test9;

-- -----------------------------------------
-- Step2 : 테이블 생성 (DDL)
create table test(
	id varchar(10),
    pw varchar(10),
    age int
);
-- Step2-1 : 테이블 확인
show tables;

-- Step2-2 : 테이블이 어떻게 만들어졌는데 확인
desc test;

-- ----------------------------------------
-- 데이터 삽입(DML)
-- table(컬럼,컬럼,컬럼,)
insert into test(id,pw,age) value("a","1234",9);
-- 순서대로면 생략가능함
insert into test value("a","1234",9);
insert into test value("b","1234",9);
insert into test value("c","1234",9);
-- 데이터 확인
select * from test;


select * from test where id='a';
select * from test;
update test set pw='aa' where id='a';
delete from test where id='a';
select * from test order by age asc;
delete from test;