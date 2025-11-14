CREATE DATABASE NewCompany;
USE NewCompany;
CREATE TABLE department (
    deptno INT PRIMARY KEY,
    depname VARCHAR(50),
    loc VARCHAR(50)
);

CREATE TABLE employees (
    empno INT PRIMARY KEY,
    ename VARCHAR(50),
    job VARCHAR(30),
    manager INT,
    hiredate DATE,
    salary DECIMAL(10,2),
    commission DECIMAL(10,2),
    deptno INT,
    FOREIGN KEY (deptno) REFERENCES department(deptno)
);

CREATE TABLE salgrades (
    grade INT PRIMARY KEY,
    lowsalary DECIMAL(10,2),
    highsal DECIMAL(10,2)
);

CREATE TABLE bonus (
    empno INT,
    job VARCHAR(30),
    salary DECIMAL(10,2),
    comm DECIMAL(10,2),
    FOREIGN KEY (empno) REFERENCES employees(empno)
);

INSERT INTO department (deptno, depname, loc)
VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'MARKETING', 'BOSTON');

INSERT INTO employees (empno, ename, job, manager, hiredate, salary, commission, deptno) VALUES
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000.00, NULL, 20),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250.00, 500.00, 30),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, NULL, 10),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100.00, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, NULL, 30),
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800.00, NULL, 20),
(7950, 'DAVID', 'MANAGER', 7839, '1983-04-15', 2600.00, NULL, 40),
(7960, 'ROBERT', 'CLERK', 7950, '1983-06-20', 900.00, NULL, 40),
(7970, 'TOM', 'SALESMAN', 7950, '1983-07-11', 1550.00, 200.00, 40);

INSERT INTO salgrades (grade, lowsalary, highsal)
VALUES
(1, 700, 1200),
(2, 1201, 1400),
(3, 1401, 2000),
(4, 2001, 3000),
(5, 3001, 9999);

INSERT INTO bonus (empno, job, salary, comm)
VALUES
(7499, 'SALESMAN', 1600.00, 300.00),
(7521, 'SALESMAN', 1250.00, 500.00),
(7839, 'PRESIDENT', 5000.00, NULL),
(7788, 'ANALYST', 3000.00, NULL);

SELECT * FROM department;
SELECT * FROM employees;
SELECT * FROM salgrades;
SELECT * FROM bonus;

-- 1) Display all the employee who are earning more than all the managers?

SELECT empno, ename, job, salary
FROM employees
WHERE salary > ALL (
    SELECT salary
    FROM employees
    WHERE job = 'MANAGER'
);

-- 2) Display all the employees who are earning more than any of the managers?

SELECT empno, ename, job, salary
FROM employees
WHERE salary > ANY (
    SELECT salary
    FROM employees
    WHERE job = 'MANAGER'
);

select * from employees where salary > any
(select distinct salary from employees where job='manager') ; 

-- 3) Select employee number, job and salary of all the Analysts who are earning more than any of the managers?

SELECT empno, ename, job, salary
FROM employees
WHERE job = 'ANALYST'
  AND salary > ANY (
      SELECT salary
      FROM employees
      WHERE job = 'MANAGER'
  );
  
  -- 4) Select all the employees who worked in NEW YORK?
  
SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE d.loc = 'NEW YORK';

-- 5) Select department name and location of all the employees working as ‘CLERK’?

SELECT DISTINCT d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.job = 'CLERK';

------ 6) Select all the department information for all the managers?

SELECT DISTINCT d.deptno, d.depname, d.loc
FROM department d
JOIN employees e ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';

----- 7) Display all the MANAGER and CLERK who work in ACCOUNTING and MARKETING departments?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.job IN ('MANAGER', 'CLERK')
AND d.depname IN ('ACCOUNTING', 'MARKETING');
  
  ------- 8) Display all the SALESMAN who are not located at DALLAS?
  
  SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.job = 'SALESMAN'
  AND d.loc <> 'DALLAS';
  
  ------ 9) Select all the employees who are earning the same salary as SMITH?
  
  SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.salary = (
    SELECT salary 
    FROM employees 
    WHERE ename = 'SMITH'
);

------ 10) Display all the details of employees whose job is not the same as SMITH?

SELECT e.empno, e.ename, e.job, e.manager, e.hiredate, e.salary, e.deptno
FROM employees e
WHERE e.job <> (
    SELECT job 
    FROM employees 
    WHERE ename = 'SMITH'
);

------ 11) List the employees working in the RESEARCH department?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE d.depname = 'RESEARCH';

------- 12) List employees who are located in NEW YORK and CHICAGO?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE d.loc IN ('NEW YORK', 'CHICAGO');

-- 13) Display the department name in which ANALYSTS are working?

SELECT DISTINCT d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.job = 'ANALYST';

-- 14) Display employees who are reporting to JONES?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.manager = (
    SELECT empno 
    FROM employees 
    WHERE ename = 'JONES'
);

-- 15) Display all the employees who are reporting to JONES’s manager?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.manager = (
    SELECT manager 
    FROM employees 
    WHERE ename = 'JONES'
);

-- 16) Display all the managers in SALES and ACCOUNTING departments?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.job = 'MANAGER'
  AND d.depname IN ('SALES', 'ACCOUNTING');
  
  (select * from employees where job='manager' and deptno in
(select deptno from department where depname in ('accounting', 'sales')));

-- 17. Display all the employee names in Research and Sales Department who are having at least 1 person reporting to them?

select * from employees 
where job='manager' and deptno in 
(select  deptno from department where depname in ('research','sales'));

-- -- 8. Display all employees who do not have any reportees?

SELECT e.empno, e.ename, e.job, e.salary, d.depname, d.loc
FROM employees e
JOIN department d ON e.deptno = d.deptno
WHERE e.empno NOT IN (
    SELECT DISTINCT manager 
    FROM employees 
    WHERE manager IS NOT NULL
);

-- 19) List employees who are having at least 2 reporting?

SELECT m.empno, m.ename, m.job, COUNT(e.empno) AS reportees_count
FROM employees m
JOIN employees e ON m.empno = e.manager
GROUP BY m.empno, m.ename, m.job
HAVING COUNT(e.empno) >= 2;

-- 20) List the department names which are having more than 5 employees?

SELECT d.deptno, d.depname, d.loc, COUNT(e.empno) AS total_employees
FROM department d
JOIN employees e ON d.deptno = e.deptno
GROUP BY d.deptno, d.depname, d.loc
HAVING COUNT(e.empno) > 5;

-- 21) List department names having at least 3 SALESMAN?

SELECT d.deptno, d.depname, d.loc, COUNT(e.empno) AS salesman_count
FROM department d
JOIN employees e ON d.deptno = e.deptno
WHERE e.job = 'SALESMAN'
GROUP BY d.deptno, d.depname, d.loc
HAVING COUNT(e.empno) >= 3;

-- 22) List employees from RESEARCH and ACCOUNTING having at least 2 reporting?

SELECT e.ename AS manager_name, e.job, d.depname, COUNT(m.empno) AS reportee_count
FROM employees e
JOIN employees m ON e.empno = m.manager
JOIN department d ON e.deptno = d.deptno
WHERE d.depname IN ('RESEARCH', 'ACCOUNTING')
GROUP BY e.ename, e.job, d.depname
HAVING COUNT(m.empno) >= 2;

-- 23. Display second max salary?

SELECT MAX(salary) AS Second_Max_Salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);

-- 24) Display 4th max salary?

SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 3, 1;

-- 25) Display 5th Maximum Salary (MySQL)?

SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 4, 1;

-- 26) Write a query to get 4th maximum salary from EMP table?

SELECT MIN(salary) AS Fourth_Max_Salary
FROM (
    SELECT DISTINCT salary
    FROM employees
    ORDER BY salary DESC
    LIMIT 4
) AS temp;


-- 27) Write a query to get 2nd & 6th max salary from EMP table?

SELECT salary AS Second_And_Sixth_Max_Salary
FROM (
    SELECT DISTINCT salary
    FROM employees
    ORDER BY salary DESC
    LIMIT 6
) AS temp
ORDER BY salary ASC
LIMIT 2;

-- 28) Write a query to get first 3 salaries from the EMP table?

SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 3;

-- 29) Write a query to get the 2nd least salary from the EMP table?

SELECT DISTINCT salary
FROM employees
ORDER BY salary ASC
LIMIT 1, 1;

-- 30) Write a query to get the least 3 salaries from the EMP table?

SELECT DISTINCT salary
FROM employees
ORDER BY salary ASC
LIMIT 3;

-- 31) List all employees whose salaries are greater than their respective departmental average salary?

SELECT e.empno, e.ename, e.job, e.salary, e.deptno
FROM employees e
WHERE e.salary > (
    SELECT AVG(salary)
    FROM employees
    WHERE deptno = e.deptno
);