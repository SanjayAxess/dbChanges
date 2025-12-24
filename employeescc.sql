create database employeeSCC;
use employeeSCC;
create table dept(   
  deptno     numeric(2,0),   
  dname      varchar(14),   
  loc        varchar(13),   
  constraint pk_dept primary key (deptno)   
);
create table emp(   
  empno    numeric(4,0),   
  ename    varchar(10),   
  job      varchar(9),   
  mgr      numeric(4,0),   
  hiredate date,   
  sal      numeric(7,2),   
  comm     numeric(7,2),   
  deptno   numeric(2,0),   
  constraint pk_emp primary key (empno),   
  constraint fk_deptno foreign key (deptno) references dept (deptno)   
);
insert into DEPT (DEPTNO, DNAME, LOC) 
values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept   
values(20, 'RESEARCH', 'DALLAS');

show tables;
insert into dept   
values(30, 'SALES', 'CHICAGO');

insert into dept  
values(40, 'OPERATIONS', 'BOSTON');
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
 values
 (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10);
 insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
 values
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000.00, NULL, 20),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, null, 30),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, null, 10);

SHOW COLUMNS FROM emp;
select * from emp;
select * from dept;

select * from salgrades;

# 1 
select * from emp    
where sal > (
    select sal from emp 
    where job = 'manager'
);
# 2 -- Display all the employees who are earning more than any of the manager? 
select * from emp 
where sal > any (select sal from emp where job = 'MANAGER');

#3 Select employee number, job and salary of all the Analyst who are earning more than any of the manager?
select empno, job, sal from emp 
where job = 'analyst' 
and sal > any (select sal from emp where job = 'manager');

#4 select all the employees who worked in new york?
select e.* from emp e 
join dept d on e.deptno = d.deptno 
where d.loc = 'new york';

#5 select department name and location of all the employees working for 'clerk'?
select distinct d.dname, d.loc from dept d 
join emp e on d.deptno = e.deptno 
where e.job = 'clerk';

#6 select all the department information for all the manager?

select distinct d.* from dept d 
join emp e on d.deptno = e.deptno 
where e.job = 'manager';     

#7  display all the manager and clerk who works in accounting and marketing department?

select e.* from emp e 
join dept d on e.deptno = d.deptno 
where e.job in ('manager', 'clerk') 
and d.dname in ('accounting', 'sales');

#8 display all the sales man who are not located at dallas?
select e.* from emp e 
join dept d on e.deptno = d.deptno 
where e.job = 'salesman' 
and d.loc != 'dallas';

#9 select all the employees who are earning same as smith?

select * from emp 
where sal = (select sal from emp where ename = 'smith') 
and ename != 'smith';
#10 display all the details of all the employees who job is not same as smith?

select * from emp 
where job != (select job from emp where ename = 'smith');
