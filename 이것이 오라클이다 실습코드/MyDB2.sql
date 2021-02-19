create table Temp (
no number
);

insert into temp values(200);
alter table temp read only;
alter table temp read write;
alter table temp
add(name varchar2(10));

create table vt1
( col1 number,
  col2 number,
  col3 number generated always as (col1+col2) virtual);
  
insert into vt1 (col1, col2) values(10,20);
insert into vt1 (col1, col2) values(30,40);
--가상 컬럼이 있는 경우는 반드시 컬럼명을 입력해줘야 한다.

alter table vt1
add(col4 generated always as (col1*col2) virtual);

create table salew10
( no number,
  pcode char(4),
  pdate char(8),
  pqty number,
  bpungi number(1) generated always as (
    case when substr(pdate, 5, 2) in (01,02,03) then 1
         when substr(pdate, 5, 2) in (04,05,06) then 2
         when substr(pdate, 5, 2) in (07,08,09) then 3
         when substr(pdate, 5, 2) in (10,11,12) then 4
    end)virtual);
    
insert into salew10 (no, pcode, pdate, pqty)
values(100, '1001', '20210217', 5);

--연습문제 1
create table new_emp(
    no number(5),
    name varchar2(20),
    hiredate date,
    bonus number(6,2));
    
--연습문제 2
create table new_emp2
as select no, name, hiredate from new_emp;

--연습문제 3
create table new_emp3
as select * from new_emp2 where 1=2 ;

--연습문제 4
alter table new_emp2
add (birthday date default sysdate);

--연습문제 5
alter table new_emp2
rename column birthday to birth;

--연습문제 6
alter table new_emp2
modify (no number(7));

--연습문제 7
alter table new_emp2
drop column birth;

--연습문제 8
truncate table new_emp2;

--연습문제 9
drop table new_emp2 purge; --쓰레기통에서도 완전 삭제
drop table new_emp purge;
drop table new_emp3 purge;
drop table new_salew10 purge;


insert into dept2 (dcode, dname, pdept, area)
    values('9000','temp_1','1006','temp area');

insert into dept2 values ('9000','temp_2','1006','temp area');
insert into dept2 (dcode, dname, pdept) values ('9000','temp_3','1006');

drop table temp purge;

create table temp
(no number constraint temp_py primary key,
name varchar2(20) not null,
addr varchar2(30),
joindate date default sysdate);

insert into temp (no, name, addr) values (102, 'park',null);
insert into temp values (102, 'park',null,'2021/02/17');

create table professor2
as select * from professor where 1=2;

insert into professor2
select * from professor;

create table prof_3
(profno number,
name varchar2(35));

create table prof_4
(profno number,
name varchar2(35));

insert all
when profno between 1000 and 1999 then into prof_3 values(profno, name)
when profno between 2000 and 2999 then into prof_4 values(profno, name)
select profno, name
from professor;

truncate table prof_3;
truncate table prof_4;
drop table prof_4 purge;

update professor
set bonus = bonus+200
where position = '조교수';
commit;
rollback;

select * FROM professor;

--김현정 교수와 같은 직급을 
--가진 교수중 급여가 250미만인 교수의 급여를 15% 인상
update professor
set pay = pay*1.15
where position = 
(select position from professor
where name ='김현정') and pay < 250;

select * from professor;

delete from dept2
where dcode>= 9000;


create table member1(
    id char(20) primary key,
    height number(10,2) default 0
);

insert into member1 values ('hong', 173.5);

update member1
set height = 180
where id = 'hong';

select height from member1 where id = 'hong';

delete from member1
where height = 180;

create table new_emp1(
no number(4) constraint emp1_name_pk primary key,
name varchar2(20) constraint emp1_name_nn not null,
jumin varchar2(13) constraint emp1_jumin_nn not null
                    constraint emp1_jumin_uk unique,
loc_code number(1) constraint emp1_area_ck check(loc_code<5),
deptno varchar2(6) constraint emp1_deptno_fk references dept2(dcode)
);

insert into new_emp1 values(101, 'hong', '1111111111111', 3, '1010');

select * from new_emp1;

create table tcons(
no number(5) constraint tcons_no_pk primary key,
name varchar2(20) constraint tcons_name_nn not null,
jumin varchar(13) constraint tcons_jumin_nn not null
                  constraint tcons_jumin_uk unique,
area number(1) constraint tcons_area_ck check(area<5),
deptno varchar2(6) constraint tcons_deptno_fk references dept2(dcode)
);