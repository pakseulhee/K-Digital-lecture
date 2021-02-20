select name, to_char(birthday, 'rr/mm/dd') birthday from student;

select empno, ename, hiredate
from emp
where to_char(hiredate, 'mm') in (01, 02,  03);

select empno, ename, hiredate, to_char(sal*12+comm, '$99,999') sal,  to_char((sal*12+comm)*1.15, '$99,999') "15% up"  
from emp 
where comm is not null;

select nvl2(comm,'exist', 'null') "nvl2" from emp where deptno =30;

select name, jumin, decode(substr(jumin,7,1), 1, 'man', 2, 'woman') "gender" 
from student where deptno1 = 101; 

select name, tel, decode(substr(tel,1,2), 02, 'seoul', 05, 'others') "location" 
from student where deptno1 = 101;

select name, tel, decode(substr(tel,1,instr(tel,')',1)-1),
            02, 'seoul', 
            031, 'gyeonggi', 
            051,'busan', 
            052,'ulsan', 
            055,'gyeognam') "location" from student;
    
select empno, ename, sal, case when sal between 1 and 1000 then 'level 1'
                                when sal between 1001 and 2000 then 'level 2'
                                when sal between 2001 and 3000 then 'level 3'
                                when sal between 3001 and 4000 then 'level 4'
                                else 'level 5'
                            end "level"
from emp;

select deptno, position, round(avg(pay),2)
from professor
group by deptno, position
order by deptno, position;

select deptno, job, avg(sal), count(*)
from emp
group by deptno, job
order by 1,3 desc;

select max(sal+nvl(comm,0)) "MAX", min(sal+nvl(comm,0)) "MIN", round(avg(sal+nvl(comm,0)),2) "avg"
from emp;     

select deptno, job, round(avg(sal),1)
from emp
group by deptno, ROLLUP(job); --앞에있는 컬럼으로 소계를 한것과 같고 마지막에 전체 소계

select deptno, job, round(avg(sal),1)
from emp
group by ROLLUP(deptno, job);

select deptno, job, round(avg(sal),1)
from emp
group by cube(deptno,job);

select deptno, job, round(avg(sal),1)
from emp
group by deptno,job
order by deptno asc;

select ename, dname
from emp e, dept d
where e.deptno = d.deptno;

select s.name , p.name from student s, professor p where s.profno = p.profno;

select s.name, d1.dname, d2.dname
from student s, department d1, department d2
where s.deptno1 = d1.deptno and s.deptno2 = d2.deptno(+);
--outer join


select s.studno, s.name ,e.total, h.grade
from student s, exam_01 e, hakjum h
where s.studno = e.studno and e.total BETWEEN h.min_point and h.max_point ;

select s.name, p.name
from student s full outer join professor p on
s.profno = p.profno;

select s.name, s.deptno1, d.dname
from student s, department d
where s.deptno1 = d.deptno;

select e.name, e.pay, p.s_pay, p.e_pay
from emp2 e, p_grade p
where e.position = p.position;