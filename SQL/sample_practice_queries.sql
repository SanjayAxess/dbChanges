show databases;
create database DB1;
use DB1;
create table Emp

(EMPId numeric primary key,

EName varchar(20) not null,

ESal decimal(10,2) check(ESal>=10000),

Mobile numeric unique not null,

Age int not null,

passport varchar(13) unique);



create table emp_Bonus(

SiNo int primary key,

bonus numeric check(bonus>1000),

EmpId numeric,

foreign key (EmpId) references Emp(EMPId)

);


create table product(prod_no int primary key, prod_name varchar(50) not null, prod_count int not null);
insert into product (prod_no,prod_name,prod_count) values (001,'fan',23),(002,'fridge',25),(003,'AC',12);
select * from product;

create table customer_details(cust_id int primary key,cust_name varchar(60),cust_add varchar(150),cust_mobileno int not null);
select * from customer_details;
insert into customer_details(cust_id,cust_name,cust_add,cust_mobileno)
 values (1001,'A','bfhjsj',766765824),
 (1002,'B','werwerdssf',235134673),
 (1003,'C','fhfdcxsc',767463354);

insert into customer_details(cust_id,cust_name,cust_add,cust_mobileno)
 values (1004,'D','bdfsdfsdj',34565824),
 (1005,'E','shdghsgfhsj',92384824),
 (1006,'wwe','wesdnbhsf',5137433),
 (1007,'hf','fhfdcxsc',767463354);
 
 create table cust_prod(prod_id int, foreign key(prod_id) references product(prod_no),
 cust_id int, foreign key(cust_id) references customer_details(cust_id),
 prod_cost decimal(10,2),prod_del_status boolean);
 
 show tables;
 
 select * from cust_prod;
 insert into cust_prod values(002,1002,45000.50,true);
 insert into cust_prod values(001,1001,55000,false);
 
 update cust_prod set prod_cost = 65000.75
 where prod_id = 1;
 
 alter table cust_prod add (prod_rating  decimal(2.1));
 alter table cust_prod modify prod_rating int;
 alter table cust_prod change prod_rating prod_star int;
 alter table cust_prod rename to customer_prod;
 alter table customer_prod drop column prod_star;
 
 select * from customer_prod;
 select count(*) from customer_prod;
 
 select cust_id, cust_name from customer_details;
 select cust_id, cust_name from customer_details where cust_id = 1003;
 select cust_id, cust_name from customer_details order by cust_id desc;
 select * from customer_details limit 3;
 select * from customer_details;
 
 select * from customer_details where cust_add like 'b%';
 select max(cust_id) from customer_details;
 select avg(cust_id) from customer_details;
 
 show databases;
 use db1;
 show tables;
 
 create table dept(dept_no int primary key,dept_name varchar(50),loc varchar(30));
 select * from dept;
 insert into dept values(10,'Accounts','chennai'),
 (20,'marketing','Bangalore'),
 (30,'Finance','chennai'),
 (40,'Sales','mumbai'),
 (60,'Research','pune'),
 (50,'Operation','calcutta');
 
 drop table dept;
 set sql_safe_updates = 0;
 update dept set loc = 'nepal' where dept_no = 30;
 
 create table salgrade(grade int not null, low_sal decimal(10,2),high_sal decimal(10,2));
 insert into salgrade values(1,3532.50,6500.00),
 (2,4500,6000),(3,5000,7500),(4,5300.50,8000),(5,8001,9000);
 
 select * from salgrade;
 drop table salgrade;
 
 create table emp_dept(emp_no numeric primary key, emp_name varchar(50) not null, job varchar(30),
 manager_code int not null, hire_date date, sal decimal(10,2) not null,
 comm numeric, dept_no int, foreign key(dept_no) references dept(dept_no));
 
 select * from emp_dept;
 
 insert into emp_dept values
 (2002,'Alwin','accontant',26,date('1995-04-02'),11500,100,20),
 (35,'Ashok','saleman',27,date('1998-05-13'),12500,100,30),
 (2004,'Miller','fin',28,date('2000-06-12'),9500,200,40),
 (34,'Jothi','offboy',29,date('1999-07-24'),8500,200,10),
 (25,'Swathi','salesgirl',30,date('2002-02-01'),10000,100,20),
 (26,'Jayam','recp',31,date('1993-03-22'),11000,400,30),
 (28,'Rani','analyst',32,date('1996-01-20'),12000,500,50),
 (24,'Raja','manager',33,date('2001-04-21'),15000,400,60),
 (30,'venkat','senioranalst',34,date('2000-10-24'),10000,200,60),
 (27,'Edwar','junioranalst',35,date('2003-09-02'),10500,300,20),
 (37,'zion','manager',36,date('1997-08-16'),11000,300,40),
 (33,'mellon','pm',37,date('1992-05-15'),10000,400,50);
 
 
 insert into emp_dept values(2000,'Salmon','Asst',40,date('1993-03-17'),20000,2000,40);
 insert into emp_dept values(2001,'Akbar','clerk',25,date('1995-09-10'),10500,300,10); 
 
 select * from emp_dept
 where dept_no = (select dept_no from dept where loc = 'chennai');
 
 select count(sal),dept_no,sal from emp_dept where emp_name not like 'A%' group by dept_no,sal having count(sal)>0;
 
 show tables;
 drop table if exists emp;
 drop table if exists emp_bonus;
 drop table if exists emp_dept;
 drop table if exists dept;
 
 CREATE TABLE emp (
  empno decimal(4,0) NOT NULL,
  ename varchar(10) default NULL,
  job varchar(9) default NULL,
  mgr decimal(4,0) default NULL,
  hiredate date default NULL,
  sal decimal(7,2) default NULL,
  comm decimal(7,2) default NULL,
  deptno decimal(2,0) default NULL
);

DROP TABLE IF EXISTS dept;

CREATE TABLE dept (
  deptno decimal(2,0) default NULL,
  dname varchar(14) default NULL,
  loc varchar(13) default NULL
);

INSERT INTO emp VALUES ('7369','SMITH','CLERK','7902','1980-12-17','800.00',NULL,'20');
INSERT INTO emp VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
INSERT INTO emp VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
INSERT INTO emp VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
INSERT INTO emp VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
INSERT INTO emp VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
INSERT INTO emp VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
INSERT INTO emp VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
INSERT INTO emp VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
INSERT INTO emp VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
INSERT INTO emp VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
INSERT INTO emp VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');

INSERT INTO dept VALUES ('10','ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES ('20','RESEARCH','DALLAS');
INSERT INTO dept VALUES ('30','SALES','CHICAGO');
INSERT INTO dept VALUES ('40','OPERATIONS','BOSTON');

select * from emp;
select * from dept;
 
 select  sal as salary, comm as commission from emp
where sal < 5000;

select * 
from (select sal as salary, comm as commission from emp) x 
where salary < 5000;

select * from salgrade;

select count(sal) as 'emp salary' from emp;

select * from emp;
select distinct job as Unique_job from emp;

select sal*100 bonus_sal from emp;
SELECT 'HELLO'||ename||'YOUR SALARY is'||SAL FROM EMP;
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';
SELECT * FROM EMP WHERE JOB='CLERK' AND SAL>700;
SELECT * FROM EMP WHERE JOB='CLERK' OR JOB='ANALYST';
       SELECT ENAME, DEPTNO, SAL FROM EMP
        ORDER BY DEPTNO DESC;
	
       SELECT CONCAT(ENAME, JOB) FROM EMP;
       
       SELECT REPLACE ('SQL','L','*') FROM DUAL;
       SELECT ROUND (10.4) FROM DUAL;
       SELECT MOD (11, 2) FROM DUAL;
       select * from dept;
       select * from emp;
       select deptno from emp where job = 'clerk';

select * from emp where deptno = (select deptno from dept where loc = 'New york');

select dname,loc from dept inner join emp
on emp.deptno = dept.deptno where emp.job = 'clerk';

select * from dept inner join emp
on emp.deptno = dept.deptno where emp.job = 'manager';

select * from dept inner join emp
on emp.deptno = dept.deptno where emp.job in ('manager','clerk') and dept.dname = 'Accounting';

select * from emp join dept 
on emp.deptno = dept.deptno
where dept.loc not  in ('DALLAS');

update emp set sal = 800 where ename = 'ward';

select * from emp where sal = (select sal from emp where ename = 'smith');
SELECT DISTINCT sal
FROM emp
ORDER BY sal DESC
LIMIT 1 OFFSET 2;

(SELECT * 
FROM emp
ORDER BY sal desc
LIMIT 2, 1) UNION ALL
(SELECT * 
FROM emp
ORDER BY sal desc
LIMIT 5, 1);

select sal from emp order by sal desc limit 3;

select sal from emp order by sal asc limit 3;
select sal from emp order by sal desc limit 3,1; 

select sal from emp order by sal desc limit 1 offset 4;
select sal from emp order by sal desc limit 4,1;

select sal from emp order by sal desc limit 3,1;
select sal from emp order by sal desc limit 1,1;
select sal from emp order by sal desc limit 1 offset 1;

select count(dept.dname),dept.dname from emp join dept
on emp.deptno = dept.deptno
where dept.dname in ('Research','Sales')
group by dept.dname having count(dept.dname)>2;      
select * from emp;

select * from emp where job  in ('Manager') order by sal desc limit 1; 

select * from emp 
where sal > any (select sal from emp where job = 'Manager');

select empno,job,sal from emp 
where sal > any (select sal from emp where job = 'Manager') and job = 'Analyst';

select * from emp join dept 
on emp.deptno = dept.deptno
where dept.loc not  in ('DALLAS') and emp.job = 'SALESMAN';

select * from emp where job  != any (select job from emp where ename = ('smith'));

select * from emp join dept 
on emp.deptno = dept.deptno
where dname = 'RESEARCH';

select * from emp join dept 
on emp.deptno = dept.deptno
where dept.loc in ('CHICAGO','New York');

select dept.dname,emp.job from emp join dept 
on emp.deptno = dept.deptno
where emp.job = 'ANALYST';

select * from emp where mgr = any(select empno from emp where ename = 'jones');
select * from emp where mgr = any(select mgr from emp where ename = 'jones');

select emp.empno,emp.ename,emp.job,emp.deptno from emp join dept 
where emp.deptno = any(select deptno from dept where dname in ('Sales','Accounting'));

select deptno from dept where dname in ('Sales','Accounting');
select * from dept;
select * from emp  
where deptno = any(select deptno from dept where dname in ('Sales','Accounting'));

select * from emp where sal > any(select avg(sal) from emp group by deptno);
(select avg(sal),deptno from emp group by deptno);

select count(empno) from emp join dept on emp.deptno = dept.deptno
where emp.empno in emp.mgr; 

select count(empno),deptno from emp
where empno = any (select mgr from emp)
group by deptno;

select deptno from dept where dname in ('RESEARCH','SALES');

SELECT DISTINCT e.ename
FROM emp e
JOIN dept d
    ON e.deptno = d.deptno
WHERE d.dname IN ('Research', 'Sales');

SELECT DISTINCT empno,ename
FROM emp e join dept d on e.deptno = d.deptno
WHERE d.dname IN ('Research', 'Sales')
  AND e.empno IN (
      SELECT mgr
      FROM emp
      WHERE mgr IS NOT NULL
  );

SELECT DISTINCT empno,ename
FROM emp e join dept d on e.deptno = d.deptno
WHERE e.empno IN (
      SELECT mgr
      FROM emp
      WHERE mgr IS NULL
  );
  
  SELECT * FROM emp WHERE empno != any(select mgr from emp);
  
  select count(empno) as Employee_count ,mgr from emp where empno in (select mgr from emp where mgr is not null) 
  group by mgr; 

select  count(dept.dname) from emp join dept on
emp.deptno = dept.deptno 
where dept.dname in ('RESEARCH','SALES') group by dept.deptno;

select count(empno),deptno from emp where deptno in (select deptno from emp) group by deptno;

select dept.dname as Department_Name,count(emp.empno) as Employee_count,emp.job from emp join dept on emp.deptno = dept.deptno
where job ='salesman' group by emp.job,dept.dname having count(empno)>2;


select dept.deptno,count(emp.deptno) as Employee_count,dept.dname from emp join dept on
emp.deptno = dept.deptno group by emp.deptno,dept.dname having count(emp.deptno)>=5;

select * from dept;

SELECT e.empno, e.ename, d.dname, COUNT(r.empno) AS report_count
FROM emp e
JOIN emp r
    ON e.empno = r.mgr
JOIN dept d
    ON e.deptno = d.deptno
WHERE d.dname IN ('Research', 'Sales')
GROUP BY e.empno, e.ename, d.dname
HAVING COUNT(r.empno) = 1;

SELECT * FROM emp WHERE empno != any(select mgr from emp);

select dname,deptno from dept where dname in ('Research','Accounting');

SELECT e.empno, e.ename, COUNT(r.empno) AS report_count
FROM emp e
JOIN emp r
    ON e.empno = r.mgr
GROUP BY e.empno, e.ename 
HAVING COUNT(r.empno) >= 2;
 
