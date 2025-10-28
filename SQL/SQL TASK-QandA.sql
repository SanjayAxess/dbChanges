CREATE DATABASE CompanyDB;
USE CompanyDB;
CREATE TABLE department (
    deptno INT PRIMARY KEY,
    dname VARCHAR(30) NOT NULL,
    loc VARCHAR(30)
);
CREATE TABLE employees (
    empno INT PRIMARY KEY,
    ename VARCHAR(30) NOT NULL,
    job VARCHAR(30),
    mgr INT,
    hiredate DATE,
    sal DECIMAL(10,2),
    comm DECIMAL(10,2),
    deptno INT,
    FOREIGN KEY (deptno) REFERENCES department(deptno)
);
CREATE TABLE salgrades (
    grade INT PRIMARY KEY,
    losal DECIMAL(10,2),
    hisal DECIMAL(10,2)
);
CREATE TABLE bonus (
    empno INT,
    job VARCHAR(30),
    sal DECIMAL(10,2),
    comm DECIMAL(10,2),
    FOREIGN KEY (empno) REFERENCES employees(empno)
);

show tables;

INSERT INTO department (deptno, dname, loc) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

INSERT INTO employees (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000.00, NULL, 20),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, NULL, 30),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, NULL, 10);

INSERT INTO salgrades (grade, losal, hisal) VALUES
(1, 700.00, 1200.00),
(2, 1201.00, 1400.00),
(3, 1401.00, 2000.00),
(4, 2001.00, 3000.00),
(5, 3001.00, 9999.00);

INSERT INTO bonus (empno, job, sal, comm) VALUES
(7499, 'SALESMAN', 1600.00, 300.00),
(7654, 'SALESMAN', 1250.00, 1400.00),
(7844, 'SALESMAN', 1500.00, 0.00),
(7900, 'CLERK', 950.00, NULL);




use companydb;
show tables;
select * from department;


-- 1) Display all the employee who are earning more than all the managers?

select * from employees where sal> all
(select distinct sal from employees  where job='manager' ) ;              -- 2975,2850, 2450


-- 2) Display all the employees who are earning more than any of the manager? 

select * from employees where sal> any
(select distinct sal from employees where job='manager') ;              -- 2975,2850, 2450



-- 3) Select employee number, job and salary of all the Analyst who are earning more  than any of the manager?

select empno, job, sal from employees where job='analyst' and sal> any
(select distinct sal from employees where job='manager');               -- 2975,2850, 2450


-- 4) select all the employees who worked in NEW YORK?

select * from employees
where deptno=(select deptno from department where loc='new york');

select * from employees e join department d on e.deptno=d.deptno where d.loc='new york';

-- 5) Select department name and location of all the employees working for 'CLERK'?

 select deptno, dname, loc from department where deptno in
(select deptno from employees where job='clerk');


 select d.dname, d.loc, e.ename, e.deptno from department d join employees e on d.deptno=e.deptno where e.job='clerk' ; 

-- 6) Select all the department information for all the manager?

select * from employees e join department d on e.deptno=d.deptno where e.job='manager' ;

-- 7) Display all the manager and clerk who works in accounting and marketing department?

	select * from employees 
    where job in ('manager','clerk') and deptno in
	(select deptno from department where dname in ('Accounting','sales'));


	select * from employees e 
     join department d on e.deptno=d.deptno
	where e.job in ('manager','clerk') and
     d.dname in ('Accounting','sales');    


-- 8) Display all the sales man who are not located at DALLAS?

select e.ename, e.deptno from employees e 
where e.job='salesman';

-- 9) Select all the employees who are earning same as SMITH?
select * from employees where sal =
(select sal from employees where ename='FORD');


-- 10) display all the details of all the employees who job is not same as SMITH?

select * from employees where job not in
(select job from employees where ename='FORD');


  -- List the employees working in research department
  
  select * from employees e 
  join department d on e.deptno=d.deptno  
  where d.dname = 'research';
  
  select * from employees 
  where deptno =
  (select deptno from department where dname='research');

-- 2. List employees who are located in New York and Chicago

  select * from employees e 
  join department d on e.deptno=d.deptno  
  where d.loc in ('new york', 'chicago');


-- 3. Display the department name in which ANALYSTS are working

  select e.ename,e.deptno, e.job, d.dname from employees e 
  join department d on e.deptno=d.deptno  
  where e.job='analyst';



-- 4. Display employees who are reporting to JONES
select * from employees where mgr=
(select empno from employees where ename='jones');

-- 5. Display all the employees who are reporting to Jones Manager

select * from employees where mgr=
(select mgr from employees where ename='jones');

-- 6. Display all the managers in SALES and ACCOUNTING department

(select * from employees where job='manager' and deptno in
(select deptno from department where dname in ('accounting', 'sales')));


-- 7. Display all the employee names in Research and Sales Department who are having at least 1 person reporting to them

select * from employees 
where job='manager' and deptno in 
(select  deptno from department where dname in ('research','sales'));


-- 8. Display all employees who do not have any reportees

select * from employees where empno not in
(select distinct mgr from employees);

--  9. List employees who are having at least 2 reporting

USE CompanyDB;
SELECT e.empno, e.ename, COUNT(r.empno) AS reportees FROM employees e
JOIN employees r ON e.empno = r.mgr
GROUP BY e.empno, e.ename
HAVING COUNT(r.empno) >= 2;


-- 10. List the department names which are having more than 5 employees
	
    
    select count(e.deptno), e.deptno, d.dname from employees e
    join department d on e.deptno=d.deptno
	group by e.deptno
    having count(e.deptno)>4;
    
-- 11. List department name having at-least 3 salesman

    select count(e.deptno), e.deptno, d.dname from employees e
    join department d on e.deptno=d.deptno
	group by e.deptno
    having count(e.deptno)>=3;


-- 12. List employees from research and accounting having at-least 2 reporting

SELECT e.empno, e.ename, d.dname, COUNT(r.empno) AS reportees FROM employees e
JOIN department d ON e.deptno = d.deptno
JOIN employees r ON e.empno = r.mgr
WHERE d.dname IN ('Research', 'Accounting')
GROUP BY e.empno, e.ename, d.dname
HAVING COUNT(r.empno) >= 2;

USE CompanyDB;
SELECT e.empno, e.ename, COUNT(r.empno) AS reportees FROM employees e
JOIN employees r ON e.empno = r.mgr
GROUP BY e.empno, e.ename, d.dname
HAVING COUNT(r.empno) >= 2;

-- 13. Display second max salary
	select max(salary) from employees where sal<(select max(salary) from employees);
    
-- 14. Display 4th max salary
	select distinct sal from employees
    order by sal desc
    limit 1 offset 3;

-- 15. Display 5th max salary  

SELECT Sal
FROM (
    SELECT Sal, DENSE_RANK() OVER (ORDER BY Sal DESC) AS ranks
    FROM Employees
) AS RankedSalaries
WHERE Ranks = 5;


-- 16.Write a query to get 4th max salary from EMP table

select sal from
(select sal, dense_Rank() over (order by sal desc) as ranks from employees )as salaryranking
where ranks=4;

select distinct sal from employees
order by sal desc
limit 1 offset 3;

-- 17. Write a query to get 2nd & 6th max salary from EMP table

	select distinct sal from
	(select sal, dense_rank() over (order by sal desc) as ranks from employees)as salary_ranking
	where ranks in (2,6);
    
    use companydb;
    SELECT DISTINCT
    (SELECT sal FROM EMPloyees ORDER BY sal DESC LIMIT 1, 1) AS second_max_salary,
     (SELECT sal FROM EMPloyees ORDER BY sal DESC LIMIT 5, 1) AS sixth_max_salary;

    
-- 18. Write a query to get first 3 salaries from the EMP table
	
    select distinct sal from employees
    order by sal asc
    limit 3;
	
-- 19. Write a query to get 2nd least salary from the EMP table
	
    select distinct sal from employees
    order by sal asc
    limit 2;
	

-- 20. Write a query to get least 3 salaries from the EMP table

	select distinct sal from employees
    order by sal asc
    limit 3;
	

-- 21. List all the employees whose salaries are greater than their respective departmental average salary.

select e.ename, e.deptno,e.sal from employees e where e.sal> 
(select Avg(e_sal.sal) as avg_sal from employees e_sal where e_sal.deptno=e.deptno);


SELECT e.empname, e.deptno, e.salary
FROM employees e
JOIN (
    SELECT deptno, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY deptno
) d_avg ON e.deptno = d_avg.deptno
WHERE e.salary > d_avg.avg_salary;

