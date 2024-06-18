select sum(score) SCORE, e.emp_no, e.emp_name, e.position, e.email
from HR_EMPLOYEES e
    join HR_GRADE g on e.emp_no = g.emp_no
where year = 2022
group by e.emp_no
order by 1 desc
limit 1