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
