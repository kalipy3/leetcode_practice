/*
 * MainClass178.sql
 * Copyright (C) 2022 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
 //两种方法都请掌握

//方法一
//链接：https://leetcode-cn.com/problems/rank-scores/solution/si-da-pai-ming-han-shu-he-guan-jian-zi-b-qvaz/
select
    score,
    DENSE_RANK() OVER (
        ORDER BY score desc
    ) `rank`
FROM
    Scores; 

//方法二 
//链接：https://leetcode-cn.com/problems/rank-scores/solution/fen-cheng-liang-ge-bu-fen-xie-hui-rong-yi-hen-duo-/
/*
最后的结果包含两个部分，第一部分是降序排列的分数，第二部分是每个分数对应的排名。

第一部分不难写：

select a.Score as Score
from Scores a
order by a.Score DESC

比较难的是第二部分。假设现在给你一个分数X，如何算出它的排名Rank呢？
我们可以先提取出大于等于X的所有分数集合H，将H去重后的元素个数就是X的排名。比如你考了99分，但最高的就只有99分，那么去重之后集合H里就只有99一个元素，个数为1，因此你的Rank为1。
先提取集合H：

select b.Score from Scores b where b.Score >= X;

我们要的是集合H去重之后的元素个数，因此升级为：

select count(distinct b.Score) from Scores b where b.Score >= X as Rank;
*/
而从结果的角度来看，第二部分的Rank是对应第一部分的分数来的，所以这里的X就是上面的a.Score，把两部分结合在一起为：

select a.score as Scores,
(select count(distinct b.score) from Scores b where b.score >= a.score) as `rank`
from Scores a
order by a.score DESC


