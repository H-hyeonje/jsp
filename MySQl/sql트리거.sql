create database market;
use market;
create table member(
	id varchar(10) not null ,
    name varchar(10) not null,
    adress char(2) null,
    tel char(10),
    height int not null default 160,
    date date,
	constraint pk primary key (id)
)default charset utf8;

drop table member;

insert into member(id,name,adress,tel,date) values("가","나","가","가","2022-01-01");

select * from member;
create table buy(
	no int auto_increment not null,
    id varchar(10) not null,
    product varchar(10) not null,
    price int,
    qnt int default 1,
    constraint pk primary key(no),
    constraint fk foreign key (id) references member (id)
    on update cascade
);

alter table buy
	add regi_date date;
    
drop table buy;
select * from buy;

alter table member
	drop column height;
    
alter table buy
	add constraint price_check check(price<=100000);
    
insert into buy (id,price,product) value("가",100001,"가나");

alter table buy
	drop constraint price_check;
    
alter table buy
	 add constraint 
     foreign key (id) references member(id)
     on update cascade;
     
     
drop table member,buy;


use market_db;
create table if not exists trigger_table (id int, txt varchar(10));
insert into trigger_table values(1,"레드벨벳");
insert into trigger_table values(2,"잇지");
insert into trigger_table values(2,"블랙핑크");

drop trigger if exists myTrigger;
delimiter &&
	create trigger myTrigger
	after delete
    on trigger_table
    for each row
begin
	set @msg="가수 그룹이 삭제됨";
end &&
delimiter ;

set @msg ='';
insert into trigger_table values(4,'마마무');
select @msg;
update trigger_table set txt = '블핑' where id=3;
select @msg;

delete from trigger_table where id=4;
select @msg;

select * from member;

create table singer (select mem_id,mem_name,mem_number,addr from member);
select * from singer;

drop trigger if exists inset_backup;
delimiter &&
create trigger inset_backup
	after insert
    on member
    for each row
begin
	insert into singer values(new.mem_id,new.mem_name,new.mem_number,new.addr);
end &&
delimiter ;


create table backup_singer(
	mem_id   char(8) not null,
    mem_name varchar(10) not null,
    mem_number int not null,
    addr  char(2) not null,
    modtype  char(2),
    moddate  date,
	moduser  varchar(30)
);

drop trigger if exists singer_updateTrg;
delimiter &&
create trigger singer_updatetrg
	after update
    on singer
    for each row
begin
	insert into backup_singer values(old.mem_id, old.mem_name,old.mem_number,old.addr, '수정',curdate(),current_user());
end &&
delimiter ;

drop trigger if exists singer_deletetrg;
delimiter &&
create trigger singer_deletetrg
	after delete
    on singer
    for each row
begin
 insert into backup_singer values(old.mem_id,old.mem_name,old.mem_number,old.addr,'삭제',curdate(),current_user());
 end &&
delimiter ;

update singer set addr ='영국' where mem_id="BLK";
delete from singer where mem_number>=7;

select * from backup_singer;

select * from member;
insert into member value("aa","aa",5,"cc","001","002",170,"2015-09-21");
delete from member where mem_id="aa";
select * from singer;
delete from singer where mem_id='bb';

show function status;