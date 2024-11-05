create database bookmarketdb;
use bookmarketdb;
create table if not exists book
(
	bookid varchar(10) not null primary key,
    bookname varchar(20),
    bookunitPrice integer,
    bookauthor varchar(20),
    bookdescription text,
    bookpublisher varchar(20),
    bookcategory varchar(20),
    bookunitsInStock long,
    bookreleasdDate varchar(20),
    bookcondition varchar(20),
    bookfileName varchar(20)
    ) default charset=utf8;
    
   select * from book; 
