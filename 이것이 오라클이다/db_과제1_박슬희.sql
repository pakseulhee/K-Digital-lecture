create table Student (
No number constraint no_pk primary key
          constraint no_nn not null,
name char(10),
det char(20),
addr char(80),
tel char(20)
);

insert into Student values(1,'ȫ�浿','�����а�','����','010-1111-1111');
insert into Student values(2,'��浿','���а�','����','010-2222-2222');
