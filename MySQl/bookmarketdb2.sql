create database bookmaketdb;
use bookmaketdb;
create table book(
	bookId varchar(20) primary key,
    name	varchar(20),
    unitprice int,
    author varchar(20),
    description varchar(500),
	publisher	varchar(20),
    category	varchar(20),
    unitsInStock long,
    releaseDate varchar(20),
	conditione varchar(20),
    fileName varchar(20)
    
);
insert into book values(2,2,2,2,2,2,2,2,2,2,2);
delete from book where 2;
select * from book;