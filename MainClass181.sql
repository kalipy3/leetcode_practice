/*
 * MainClass181.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
 //送分题 请直接看sql语句：


//方法一 自链接
select e1.Name as Employee
from employee e1, employee e2
where e1.ManagerId= e2.Id
and e1.Salary > e2.Salary

//方法二 子链接
select e.Name as Employee
from employee e
where salary > (select salary from employee where Id = e.ManagerId)


