create database E_commerce;
use E_commerce;

use employeOracle;
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
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, null, 10);


use staffdetails;
select *from emplist;
select *from department;
show databases;

-- 1) Employees earning more than all managers
SELECT e.*
FROM emp e
WHERE e.sal > ALL (SELECT sal FROM emp WHERE job = 'MANAGER');

-- 2) Employees earning more than any manager
SELECT e.*
FROM emp e
WHERE e.sal > ANY (SELECT sal FROM emp WHERE job = 'MANAGER');

-- 3) Analyst empno, job, sal earning more than any manager
SELECT e.empno, e.job, e.sal
FROM emp e
WHERE e.job = 'ANALYST'
  AND e.sal > ANY (SELECT sal FROM emp WHERE job = 'MGR');
  
  -- 4) Employees who worked in NEW YORK
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE UPPER(d.loc) = 'NEW YORK';

-- 5) Department name and location of all employees working as 'CLERK'
SELECT DISTINCT d.dname, d.loc
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job = 'CLERK';

-- 6) All department information for all managers
SELECT DISTINCT d.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job = 'MANAGER';

-- 7) Managers and clerks who work in Accounting and Marketing
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job IN ('MANAGER','CLERK')
  AND d.dname IN ('ACCOUNTING','MARKETING');

-- 8) Salesmen not located at DALLAS
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job = 'SALESMAN'
  AND UPPER(d.loc) <> 'DALLAS';

-- 9) Employees earning the same as SMITH
SELECT e.*
FROM emp e
WHERE e.sal = (SELECT sal FROM emp WHERE ename = 'SMITH');

-- 10) Employees whose job is not same as SMITH
SELECT e.*
FROM emp e
WHERE e.job <> (SELECT job FROM emp WHERE ename = 'SMITH');


-- 11) Employees working in Research department
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE d.dname = 'RESEARCH';

-- 12) Employees located in New York and Chicago
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE d.loc IN ('NEW YORK','CHICAGO');

-- 13) Department name in which Analysts are working
SELECT DISTINCT d.dname
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job = 'ANALYST';

-- 14) Employees reporting to JONES
SELECT e.*
FROM emp e
WHERE e.mgr = (SELECT empno FROM emp WHERE ename = 'JONES');

-- 15) Employees reporting to Jones’s manager
SELECT e.*
FROM emp e
WHERE e.mgr = (SELECT mgr FROM emp WHERE ename = 'JONES');

-- 16) All managers in SALES and ACCOUNTING department
SELECT e.*
FROM emp e
JOIN dept d ON d.deptno = e.deptno
WHERE e.job = 'MANAGER'
  AND d.dname IN ('SALES','ACCOUNTING');

-- 17) Employee names in Research and Sales who have at least 1 reportee
SELECT m.ename, m.empno, m.job, m.deptno
FROM emp m
JOIN dept d ON d.deptno = m.deptno
WHERE d.dname IN ('RESEARCH','SALES')
  AND EXISTS (SELECT 1 FROM emp r WHERE r.mgr = m.empno);

-- 18) Employees who do not have any reportees
SELECT e.*
FROM emp e
WHERE NOT EXISTS (SELECT 1 FROM emp r WHERE r.mgr = e.empno);

-- 19) Employees having at least 2 reportees
SELECT m.empno, m.ename, COUNT(*) AS reportees
FROM emp m
JOIN emp r ON r.mgr = m.empno
GROUP BY m.empno, m.ename
HAVING COUNT(*) >= 2;

-- 20) Department names having more than 5 employees
SELECT d.dname, COUNT(*) AS headcount
FROM dept d
JOIN emp e ON e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(*) > 5;

-- 21) Departments having at least 3 salesmen
SELECT d.dname, COUNT(*) AS salesmen
FROM dept d
JOIN emp e ON e.deptno = d.deptno
WHERE e.job = 'SALESMAN'
GROUP BY d.dname
HAVING COUNT(*) >= 3;

-- 22) Employees from Research and Accounting having at least 2 reporting
SELECT m.empno, m.ename, d.dname, COUNT(*) AS reportees
FROM emp m
JOIN dept d ON d.deptno = m.deptno
JOIN emp r ON r.mgr = m.empno
WHERE d.dname IN ('RESEARCH','ACCOUNTING')
GROUP BY m.empno, m.ename, d.dname
HAVING COUNT(*) >= 2;

-- 23) Second max salary
SELECT MAX(sal) AS second_max_sal
FROM emp
WHERE sal < (SELECT MAX(sal) FROM emp);

-- 24) Fourth max salary (analytic, handles ties)
SELECT sal AS fourth_max_sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS rn
  FROM emp
)
WHERE rn = 4;

-- 25) Fifth max salary
SELECT sal AS fifth_max_sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS rn
  FROM emp
)
WHERE rn = 5;

-- 26) 4th max salary (same as above for clarity)
SELECT sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS rn
  FROM emp
)
WHERE rn = 4;

-- 27) 2nd & 6th max salary
SELECT sal, rn
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS rn
  FROM emp
)
WHERE rn IN (2,6)
ORDER BY rn;

-- 28) First 3 salaries (highest)
SELECT sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS rn
  FROM emp
)
WHERE rn <= 3
ORDER BY sal DESC;

-- 29) 2nd least salary
SELECT sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal ASC) AS rn
  FROM emp
)
WHERE rn = 2;

-- 30) Least 3 salaries
SELECT sal
FROM (
  SELECT DISTINCT sal, DENSE_RANK() OVER (ORDER BY sal ASC) AS rn
  FROM emp
)
WHERE rn <= 3
ORDER BY sal ASC;

-- 31) Employees whose salary > their departmental average
SELECT e.*
FROM emp e
WHERE e.sal > (
  SELECT AVG(e2.sal) FROM emp e2
  WHERE e2.deptno = e.deptno
);



