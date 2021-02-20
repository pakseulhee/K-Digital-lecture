--1. dept 테이블을 사용하여 deptno를 부서#, dname을 부서명, loc를 위치로 별명을 설정하여 출력하세요.
select dcode as "부서#", dname as "부서명", area as "위치" from dept2;
--2. 교수 테이블(professor)을 사용하여 '홍길동(교수)' 와 같이 교수명(직급) 형식으로 하고 컬럼명은 교수님 으로 출력하세요.
select name||'('||position||')' as "교수님" from professor;
--3. Between 연산자를 사용하여 student 테이블에서 몸무게가 60kg~80kg인 사람의 이름과 체중을 출력하세요.
select name, weight from student where weight between 60 and 80;
--4. like 연산자를 사용하여 student 테이블에서 성이 "김" 씨인 사람을 조회하세요.
select name from student where name like '김%';
--5. student 테이블에서 jumin 칼럼을 사용해서 태어난 달이 8월인 사람의 이름과 생년월일을 출력하세요.
select name, substr(jumin, 3, 2) "생년월일" from student where substr(jumin, 3, 2) = '08';
--6. professor 테이블에서 101번 학과 교수들의 이름과 급여, bonus, 연봉을 출력하세요. 단, 연봉은 (pay*12+bonus)로 계산하고 bonus가 없는 교수는 bonus를0으로 처리하여 계산하세요.
select name, pay, bonus, (pay*12+nvl(bonus,0)) "연봉" from professor where deptno=101;
--7. student 테이블의 jumin 칼럼을 참조하여 학생들의 이름과 태어난 달, 그리고 분기를 출력하세요. 태어난 달이 01~03월은 1/4분기, 04~06월은 2/4분기, 07~09월은 3/4분기, 10~12월은 4/4분기로 출력하세요.
select name, substr(jumin,3,2) "출생월", 
            case when (substr(jumin,3,2)) between '01' and '03' then '1/4분기'
                   when (substr(jumin,3,2)) between '04' and '06' then '2/4분기'
	     when (substr(jumin,3,2)) between '07' and '09' then '3/4분기'
	     when (substr(jumin,3,2)) between '10' and '12' then '4/4분기' 
                   else '안태어남'
             end "분기" from student;
--8. professor 테이블에서 학과별로 교수들의 평균 급여를 출력하시오.
select deptno, round(avg(nvl(pay,0)),2) "평균급여" from professor group by deptno;
--9. professor 테이블에서 평균 급여가 450 이상인 부서의 부서번호와 평균급여를 구하세요.
select deptno, avg(nvl(pay,0)) from professor group by deptno  having avg(pay)>450;
--10. gogak 테이블과 gif 테이블을 join하여 고객의 마일리지 포인트별로 최대 받을 수 있는 상품을 조회하여 고객의 이름과 상품명을 출력하세요.
select go.gname "고객명", go.point "POINT", gi.gname "상품명" from gogak go, gift gi where go.point between gi.g_start and gi.g_end;
--11. 10번 문제에서 조회한 상품의 이름과 필요 수량이 몇 개인지 조회하세요.
select gi.gname "상품명", count(*) "필요수량" from gogak go, gift gi where go.point between gi.g_start and gi.g_end group by gi.gname;
--12. student 테이블과 professor 테이블을 join 하여 학생이름과 지도교수 이름을 출력하세요. 단, 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요.
select s.name "학생이름", p.name "교수이름" from student s, professor p where s.profno=p.profno(+);
--13. emp2 테이블을 조회하여 직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력하세요.
select name "사원이름", position "직급", pay "급여" from emp2 a where pay>=(select avg(pay) from emp2 b where a.position=b.position);
--14. Professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중에서 조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요.
select name, pay, hiredate from professor where
hiredate = (select hiredate from professor where name='심슨') and
pay < (select pay from professor where name='조인형');
--15. emp2 테이블을 사용하여 전체 직원 중 과장 직급의 최소 연봉자보다 연봉이 높은 사람의 이름과 직급, 연봉을 출력하세요. 단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요.
select name "이름", position "직급", to_char(pay,'L999,999,999')||' 원' "연봉" from emp2 where
pay > any (select pay from emp2 where position = '과장');