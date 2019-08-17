-- 176. Second Highest Salary
--
-- Create table If Not Exists Employee (Id int, Salary int)
-- Truncate table Employee
-- insert into Employee (Id, Salary) values ('1', '100')
-- insert into Employee (Id, Salary) values ('2', '200')
-- insert into Employee (Id, Salary) values ('3', '300')
--
-- Write a SQL query to get the second highest salary from the Employee table.
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
--
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+

-- # Write your MySQL query statement below

SELECT max(Salary)  as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee)

-- Using max() will return a NULL if the value doesn't exist.
-- So there is no need to UNION a NULL. Of course,
-- if the second highest value is guaranteed to exist,
-- using LIMIT 1,1 will be the best answer.

