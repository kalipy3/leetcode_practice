/*
 * MainClass184.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
 //方法一 评论区/kalipy
select d.name as department, e.name as employee, e.salary
from 
employee e,
department d,
(select max(salary) as max,departmentid from employee group by departmentid) as t
where e.salary = t.max and e.departmentid=t.departmentid and e.departmentid=d.id;

//方法一 写法二
select d.name as department, e.name as employee, e.salary
from 
employee e join
department d join
(select max(salary) as max,departmentid from employee group by departmentid) as t
on e.salary = t.max and e.departmentid=t.departmentid and e.departmentid=d.id;

//方法二 官方题解
SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Employee.DepartmentId , Salary) IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
	)

//方法三
看到官方的多字段IN的使用，确实牛逼，一般想不到，这里给出一个MYSQL8.0以后支持的窗口函数的解法；
根据部门分区，获取每个部门薪资排名的临时表，通过DepartmentId与Id字段关联，与Department连表，筛选出薪资排名第1的记录
select 
     Department
    ,Employee
    ,Salary
from (
    select
        b.name         as Department
        ,a.name        as Employee
        ,a.Salary      as Salary 
        ,dense_rank() over(partition by a.departmentId order by a.salary desc) as dr  -- 注意相同工资的都要列出来
    from Employee a
    inner join Department b
        on a.departmentId = b.id
) a 
where dr = 1

