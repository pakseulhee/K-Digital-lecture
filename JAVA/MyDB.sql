select email from employees;
desc tab;

select name ||'''s ID: '|| id ||', weight is '||weight ||'kg' from student;
select ename||'('|| job ||') , '|| ename|| '''' ||job|| ''''  from emp; 
select name, birthday from student where birthday like '____-02%';
select name, tel, instr(tel, '3') from student where deptno1 = 101;
select name, replace(jumin, substr(jumin,7,7), '*******') "jumin" 
from student;

select name, tel, replace(tel, substr(tel, -4,4), '****') "replace" 
from student where deptno1 = 101; --뒤에서 4번째에서 시작해서 4개
