select *
from worker
where salary = (
select max(salary) as LargestSalary
from worker
);