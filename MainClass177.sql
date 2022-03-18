/*
 * MainClass177.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
//链接：https://leetcode-cn.com/problems/nth-highest-salary/solution/mysql-zi-ding-yi-bian-liang-by-luanz/
//https://leetcode-cn.com/problems/nth-highest-salary/solution/tu-jie-sqlmian-shi-ti-ru-he-cha-zhao-di-ngao-de-2/

//方法一
1. limit start, count。其中start的显示值是从start+1开始的。但此处输入不能是计算式，比如：N-1
2. 第N高的N，是通过自定义函数getNthHighestSalary的(N INT)中N传入。start必须是从N-1开始，才能显示符合题目要求的结果。比如第N=2高，如果直接用N值到limit，limit 2,1，意为从第3行开始，显示一行。所以要用N-1=1，才能表示从第二行开始。
3. 这时，应通过一个替代参数实现。MySQL自定函数中的参数是静态参数，即要先定义后使用。先用declare定义类型，后通过set进行赋值。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT 
            salary
      FROM 
            employee
      GROUP BY 
            salary
      ORDER BY 
            salary DESC
      LIMIT N, 1
  );
END

//方法二
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT 
          DISTINCT e.salary
      FROM 
          employee e
      WHERE 
          (SELECT count(DISTINCT salary) FROM employee WHERE salary>e.salary) = N-1
  );
END

//方法三
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT 
          e1.salary
      FROM 
          employee e1, employee e2 
      WHERE 
          e1.salary <= e2.salary
      GROUP BY 
          e1.salary
      HAVING 
          count(DISTINCT e2.salary) = N
  );
END

//方法四
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        SELECT 
            DISTINCT salary
        FROM 
            (SELECT 
                salary, dense_rank() over(ORDER BY salary DESC) AS rnk
             FROM 
                employee) tmp
        WHERE rnk = N
  );
END
