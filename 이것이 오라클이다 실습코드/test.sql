--1. dept ���̺��� ����Ͽ� deptno�� �μ�#, dname�� �μ���, loc�� ��ġ�� ������ �����Ͽ� ����ϼ���.
select deptno "#", dname "�μ���", loc "��ġ" from dept;

--2. ���� ���̺�(professor)�� ����Ͽ� 'ȫ�浿(����)' �� ���� ������(����) �������� �ϰ� �÷����� ������ ���� ����ϼ���.
select name ||'('|| position ||')' "������" from professor;

--3. Between �����ڸ� ����Ͽ� student ���̺��� �����԰� 60kg~80kg�� ����� �̸��� ü���� ����ϼ���.
select name, weight from student where weight between 60 and 80;

--4. like �����ڸ� ����Ͽ� student ���̺��� ���� "��" ���� ����� ��ȸ�ϼ���.
select name from student where name like '��%';

--5. student ���̺��� jumin Į���� ����ؼ� �¾ ���� 8���� ����� �̸��� ��������� ����ϼ���.
select name, substr(jumin,1,6) "birthday" from student where substr(jumin,3,2) = 08;

--6. professor ���̺��� 101�� �а� �������� �̸��� �޿�, bonus, ������ ����ϼ���. ��, ������ (pay*12+bonus)�� ����ϰ� bonus�� ���� ������ bonus��0���� ó���Ͽ� ����ϼ���.
select name, pay, nvl(bonus,0) "bonus", pay*12+nvl(bonus,0) "����" from professor where deptno = 101;

--7. student ���̺��� jumin Į���� �����Ͽ� �л����� �̸��� �¾ ��, �׸��� �б⸦ ����ϼ���. �¾ ���� 01~03���� 1/4�б�, 04~06���� 2/4�б�, 07~09���� 3/4�б�, 10~12���� 4/4�б�� ����ϼ���.
select name, substr(jumin, 3, 2) month, decode(substr(jumin, 3, 2),01,'1/4�б�',02,'1/4�б�',03,'1/4�б�',
                                                                    04,'2/4�б�',05,'2/4�б�',06,'2/4�б�',
                                                                    07,'3/4�б�',08,'3/4�б�',09,'3/4�б�','4/4�б�')"�б�"from student;

--8. professor ���̺��� �а����� �������� ��� �޿��� ����Ͻÿ�.
select avg(pay) from professor group by deptno;

--9. professor ���̺��� ��� �޿��� 450 �̻��� �μ��� �μ���ȣ�� ��ձ޿��� ���ϼ���.
select deptno, avg(pay) from professor group by deptno having avg(pay)>=450;

--10. gogak ���̺�� gift ���̺��� join�Ͽ� ���� ���ϸ��� ����Ʈ���� �ִ� ���� �� �ִ� ��ǰ�� ��ȸ�Ͽ� ���� �̸��� ��ǰ���� ����ϼ���.
select k.gname, g.gname from gogak k, gift g where k.point between g.g_start and g.g_end;

--11. 10�� �������� ��ȸ�� ��ǰ�� �̸��� �ʿ� ������ �� ������ ��ȸ�ϼ���.
select k.gname, count(g.gname) from gogak k, gift g where k.point between g.g_start and g.g_end group by k.gname;


--12. student ���̺�� professor ���̺��� join �Ͽ� �л��̸��� �������� �̸��� ����ϼ���. ��, ���������� �������� ���� �л��� ��ܵ� �Բ� ����ϼ���.
select s.name, p.name from student s, professor p where s.profno = p.profno(+);

--13. emp2 ���̺��� ��ȸ�Ͽ� ������ �߿��� �ڽ��� ������ ��տ����� ���ų� ���� �޴� ������� �̸��� ����, ���� ������ ����ϼ���.
select name, emp_type, pay from emp2 where pay >= (select avg(pay) from emp2);

--14. Professor ���̺��� �ɽ� ������ ���� �Ի��Ͽ� �Ի��� ���� �߿��� 
--������ �������� ������ ���� �޴� ������ �̸��� �޿�, �Ի����� ����ϼ���.
select name, pay, (select hiredate from professor where pay<550)
from professor
where hiredate =(select hiredate from professor where hiredate = '81/10/23' );

--15. emp2 ���̺��� ����Ͽ� ��ü ���� �� ���� ������ �ּ� �����ں��� ������ ���� ����� �̸��� ����, ������ ����ϼ���. 
--��, ���� ��� ������ õ ���� ���� ��ȣ�� �� ǥ�ø� �ϼ���.
select name, emp_type, to_char(pay, '9,999,999,999')||'��'
from emp2
where pay > (select min(pay) from emp2 where position = '����');
