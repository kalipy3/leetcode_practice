/*
 * MainClass180.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

!!!!!注意连续出现，不是having的思路


//方法一
链接：https://leetcode-cn.com/problems/consecutive-numbers/solution/sql-server-jie-fa-by-neilsons/
SELECT DISTINCT Num as ConsecutiveNums FROM (
SELECT Num,COUNT(1) as SerialCount FROM 
(SELECT Id,Num,
row_number() over(order by id) -
ROW_NUMBER() over(partition by Num order by Id) as SerialNumberSubGroup
FROM Logs) as Sub
GROUP BY Num,SerialNumberSubGroup HAVING COUNT(1) >= 3) as Result


//方法二
链接：https://leetcode-cn.com/problems/consecutive-numbers/solution/zhao-dao-lian-xu-chu-xian-ci-shu-da-yu-d-mswy/
//cast()用法:https://blog.csdn.net/qq_35118528/article/details/100140692
/*请问 id-cast( ) 的用法是什么？能解释一下吗？ 评论区：
相同的num值 是连续的，则id-cast( ) 结果就是相同的，通过这个值的数量就可以来判定 有多少个连续次数的num取值了！！！
这个是先把cast()算出来再用id减去它的意思，没有id-cast()这个函数
*/
select distinct Num AS ConsecutiveNums
from
(select Num,Id-cast((row_number() over(partition by Num order by Id asc)) as signed) as ranking
from Logs) as t
group by Num,ranking
having count(*)>=3

//方法三
链接：https://leetcode-cn.com/problems/consecutive-numbers/solution/mysql-80-chuang-kou-han-shu-lagexprn-lea-a2jp/
# Write your MySQL query statement below
select distinct num as ConsecutiveNums 
from (select num, 
             lag(num, 1, null) over (order by id) lag_num, 
             lead(num, 1, null) over (order by id) lead_num
      from logs) l
where l.Num = l.lag_num
  and l.Num = l.lead_num


