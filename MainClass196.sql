/*
 * MainClass196.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//方法一
delete from Person 
where Id not in (
    select * from(
        select min(Id)
        from Person
        group by Email) t);

注意：在MYSQL中，不能先Select一个表的记录，再按此条件Update和Delete同一个表的记录，否则会出错：You can't specify target table 'xxx' for update in FROM clause.

解决方法：使用嵌套Select——将Select得到的查询结果作为中间表，再Select一遍中间表作为结果集，即可规避错误。

另外，请注意本题题意，提示要用Delete删除重复项，所以以下傻白甜方法不能使用 T-T

select min(Id), Email
from Person
group by Email;

//方法二
delete p1
from Person p1 ,Person s1 
where p1.email = s1.email and p1.id > s1.id
