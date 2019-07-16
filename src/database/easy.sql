# https://leetcode.com/problems/combine-two-tables/
select p.FirstName, p.LastName, a.City, a.State from Person p
left join Address a on p.PersonId = a.PersonId


# https://leetcode.com/problems/second-highest-salary/
select (
    select distinct
        Salary
    from Employee
    order by Salary desc
    limit 1 offset 1
) as SecondHighestSalary;

# https://leetcode.com/problems/employees-earning-more-than-their-managers/
select
    e1.Name as Employee
from Employee e1
right join Employee e2 on e1.ManagerId = e2.Id
where e1.Salary > e2.Salary;

# https://leetcode.com/problems/duplicate-emails/
select distinct t1.Email from Person t1
where exists (
    select * from Person t2 where t2.Email = t1.Email and t2.Id != t1.Id;
)

# https://leetcode.com/problems/customers-who-never-order/
select Name as Customers from Customers c
where not exists (
    select * from Orders o
    where o.CustomerId = c.Id
)

# https://leetcode.com/problems/delete-duplicate-emails/
delete p1 from Person p1, Person p1
where p1.Email = p2.Email and p1.Id > p2.Id

# https://leetcode.com/problems/rising-temperature/
select t1.Id as Id from Weather t1, Weather t2
where to_days (t1.RecordDate) - to_days (t2.RecordDate) = 1
and t1.Temperature > t2.Temperature

# https://leetcode.com/problems/big-countries/
select name, population, area from World where area > 3000000 or population > 25000000

# https://leetcode.com/problems/classes-more-than-5-students/
select class from courses
group by class
having count(student) >= 5

# https://leetcode.com/problems/not-boring-movies/
select class from courses
group by class
having count(distinct student) >= 5
