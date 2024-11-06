USE MARKET_DB;
select *
	FROM BUY;
SELECT *
	FROM member;
    
select *
	FROM BUY
    inner join member
    ON BUY.MEM_ID=MEMBER.MEM_ID
    order by MEMBER.ADDR desc;
    
    
select MEM_ID ,MEM_NAME, PROD_NAME,ADDR, concat(PHONE1,PHONE2) '연락처'
	FROM BUY
    inner join MEMBER
    ON buy.MEM_ID =MEMBER.MEM_ID;
    
    
select BUY.MEM_ID ,MEM_NAME, PROD_NAME,ADDR, concat(PHONE1,PHONE2) '연락처'
	FROM BUY
    inner join MEMBER
    ON buy.MEM_ID =MEMBER.MEM_ID;
    
select BUY.MEM_ID, MEMBER.MEM_NAME, buy.prod_name, MEMBER.ADDR,concat(MEMBER.PHONE1,MEMBER.PHONE2) '연락처'
	from BUY
		inner join MEMBER
        ON buy.mem_id=member.mem_id;
        
select B.MEM_ID, M.MEM_NAME, B.PROD_NAME, M.ADDR,concat(M.PHONE1,M.PHONE2) '연락처'
	FROM BUY B
		INNER JOIN MEMBER M
        ON B.MEM_ID=M.MEM_ID;
        
select B.MEM_ID, M.MEM_NAME, B.PROD_NAME, M.ADDR,concat(M.PHONE1,M.PHONE2) '연락처'
	FROM BUY B
		INNER JOIN MEMBER M
        ON B.MEM_ID=M.MEM_ID
        order by M.MEM_ID;
        
select M.MEM_ID, M.MEM_NAME, B.PROD_NAME, M.ADDR
	FROM MEMBER M
		left outer join buy b
        ON M.MEM_ID=B.MEM_ID
        order by M.MEM_ID;
        
select M.MEM_ID,M.MEM_NAME, B.PROD_NAME,M.ADDR
	FROM member M
		right outer JOIN BUY B
        ON B.MEM_ID=M.MEM_ID
        order by M.MEM_ID;
        
create TABLE EMP_TABLE (
	EMP CHAR(4),
    MANGER CHAR(4),
    PHONE varchar(8)
    );
    
insert INTO EMP_TABLE values('대표',NULL,'0000');
insert INTO EMP_TABLE values('영업이사','대표','1111');
insert INTO EMP_TABLE values('관리이사','대표','2222');
insert INTO EMP_TABLE values('정보이사','대표','3333');
insert INTO EMP_TABLE values('영업과장','영업이사','1111-1');
insert INTO EMP_TABLE values('경리부장','관리이사','2222-1');
insert INTO EMP_TABLE values('인사부장','관리이사','2222-2');
insert INTO EMP_TABLE values('개발팀장','정보이사','3333-1');
insert INTO EMP_TABLE values('개발주임','정보이사','3333-1-1');

select A.EMP "직원", B.EMP "직속상관", B.PHONE "지속상관연락처"
	from EMP_TABLE A
		inner JOIN EMP_TABLE B
        ON A.MANGER =B.EMP
        where A.EMP='경리부장';
        
DROP procedure if exists IFPROC3;
DELIMITER $$
create procedure IFPROC3()
	begin
		declare DEBUTDATE DATE;
        declare CURDATE DATE;
        declare DAYS INT;
        
	select debut_date INTO DEBUTDATE
		from market_db.member
        where MEM_ID ='APN';
        
set CURDATE = current_date();
SET DAYS = datediff(CURDATE,DEBUTDATE);

IF (DAYS/365) >= 5 THEN
	select concat('데뷔한 지',DAYS,'일이나 지났습니다. 핑순이들 축하합니다.!') AS'축';
else
	select concat('데뷔한 지',DAYS,'일 밖에 안되엇네요. 핑순이들 화이딩~!') AS '축';
end if;
END $$
DELIMITER ;
CALL IFPROC3();

select MEM_ID, SUM(PRICE*AMOUNT) "총구매 액"
	FROM BUY
    group by MEM_ID
    order by SUM(PRICE*AMOUNT) desc;
    
select B.MEM_ID,M.MEM_NAME, SUM(PRICE*AMOUNT) "총구매 액"
	from BUY B
		inner JOIN member M
		ON B.MEM_ID=M.mem_id
	group by B.MEM_ID
    order by SUM(PRICE*AMOUNT) DESC;
    
select M.MEM_ID,M.MEM_NAME, SUM(PRICE*AMOUNT) "총구매액",
	CASE
		WHEN (SUM(PRICE*AMOUNT) >=1500) THEN '최우수고객'
        WHEN (SUM(PRICE*AMOUNT) >=1000) THEN '우수고객'
        WHEN (SUM(PRICE*AMOUNT) >=1) THEN '일반고객'
        ELSE "유령 고객"
        END "회원등급"
	fROM buy B
		right outer JOIN member M
		ON B.mem_id=M.mem_id
        group by M.mem_id
        order by SUM(price*AMOUNT) DESC;
