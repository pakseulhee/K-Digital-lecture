--1. dept ���̺��� ����Ͽ� deptno�� �μ�#, dname�� �μ���, loc�� ��ġ�� ������ �����Ͽ� ����ϼ���.
select dcode as "�μ�#", dname as "�μ���", area as "��ġ" from dept2;
--2. ���� ���̺�(professor)�� ����Ͽ� 'ȫ�浿(����)' �� ���� ������(����) �������� �ϰ� �÷����� ������ ���� ����ϼ���.
select name||'('||position||')' as "������" from professor;
--3. Between �����ڸ� ����Ͽ� student ���̺��� �����԰� 60kg~80kg�� ����� �̸��� ü���� ����ϼ���.
select name, weight from student where weight between 60 and 80;
--4. like �����ڸ� ����Ͽ� student ���̺��� ���� "��" ���� ����� ��ȸ�ϼ���.
select name from student where name like '��%';
--5. student ���̺��� jumin Į���� ����ؼ� �¾ ���� 8���� ����� �̸��� ��������� ����ϼ���.
select name, substr(jumin, 3, 2) "�������" from student where substr(jumin, 3, 2) = '08';
--6. professor ���̺��� 101�� �а� �������� �̸��� �޿�, bonus, ������ ����ϼ���. ��, ������ (pay*12+bonus)�� ����ϰ� bonus�� ���� ������ bonus��0���� ó���Ͽ� ����ϼ���.
select name, pay, bonus, (pay*12+nvl(bonus,0)) "����" from professor where deptno=101;
--7. student ���̺��� jumin Į���� �����Ͽ� �л����� �̸��� �¾ ��, �׸��� �б⸦ ����ϼ���. �¾ ���� 01~03���� 1/4�б�, 04~06���� 2/4�б�, 07~09���� 3/4�б�, 10~12���� 4/4�б�� ����ϼ���.
select name, substr(jumin,3,2) "�����", 
            case when (substr(jumin,3,2)) between '01' and '03' then '1/4�б�'
                   when (substr(jumin,3,2)) between '04' and '06' then '2/4�б�'
	     when (substr(jumin,3,2)) between '07' and '09' then '3/4�б�'
	     when (substr(jumin,3,2)) between '10' and '12' then '4/4�б�' 
                   else '���¾'
             end "�б�" from student;
--8. professor ���̺��� �а����� �������� ��� �޿��� ����Ͻÿ�.
select deptno, round(avg(nvl(pay,0)),2) "��ձ޿�" from professor group by deptno;
--9. professor ���̺��� ��� �޿��� 450 �̻��� �μ��� �μ���ȣ�� ��ձ޿��� ���ϼ���.
select deptno, avg(nvl(pay,0)) from professor group by deptno  having avg(pay)>450;
--10. gogak ���̺�� gif ���̺��� join�Ͽ� ���� ���ϸ��� ����Ʈ���� �ִ� ���� �� �ִ� ��ǰ�� ��ȸ�Ͽ� ���� �̸��� ��ǰ���� ����ϼ���.
select go.gname "����", go.point "POINT", gi.gname "��ǰ��" from gogak go, gift gi where go.point between gi.g_start and gi.g_end;
--11. 10�� �������� ��ȸ�� ��ǰ�� �̸��� �ʿ� ������ �� ������ ��ȸ�ϼ���.
select gi.gname "��ǰ��", count(*) "�ʿ����" from gogak go, gift gi where go.point between gi.g_start and gi.g_end group by gi.gname;
--12. student ���̺�� professor ���̺��� join �Ͽ� �л��̸��� �������� �̸��� ����ϼ���. ��, ���������� �������� ���� �л��� ��ܵ� �Բ� ����ϼ���.
select s.name "�л��̸�", p.name "�����̸�" from student s, professor p where s.profno=p.profno(+);
--13. emp2 ���̺��� ��ȸ�Ͽ� ������ �߿��� �ڽ��� ������ ��տ����� ���ų� ���� �޴� ������� �̸��� ����, ���� ������ ����ϼ���.
select name "����̸�", position "����", pay "�޿�" from emp2 a where pay>=(select avg(pay) from emp2 b where a.position=b.position);
--14. Professor ���̺��� �ɽ� ������ ���� �Ի��Ͽ� �Ի��� ���� �߿��� ������ �������� ������ ���� �޴� ������ �̸��� �޿�, �Ի����� ����ϼ���.
select name, pay, hiredate from professor where
hiredate = (select hiredate from professor where name='�ɽ�') and
pay < (select pay from professor where name='������');
--15. emp2 ���̺��� ����Ͽ� ��ü ���� �� ���� ������ �ּ� �����ں��� ������ ���� ����� �̸��� ����, ������ ����ϼ���. ��, ���� ��� ������ õ ���� ���� ��ȣ�� �� ǥ�ø� �ϼ���.
select name "�̸�", position "����", to_char(pay,'L999,999,999')||' ��' "����" from emp2 where
pay > any (select pay from emp2 where position = '����');