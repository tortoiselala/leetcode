# https://leetcode-cn.com/problems/nth-highest-salary/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    select distinct Salary
    from Employee t1
    where N = (
        select count(distinct t2.Salary)
        from Employee t2
        where t2.Salary >= t1.Salary
    )
  );
END

# https://leetcode-cn.com/problems/rank-scores/
select Score, Rank from (
    select
)