create database login_crud;
use login_crud;
create table member(
  id varchar(30) primary key,
  pw varchar(30),
  age int
);

select * from member;
Select * from member;
Select * from member;
Select * from member ORDER BY id desc;
update member set pw='55',age=555 where id='44ffssf';