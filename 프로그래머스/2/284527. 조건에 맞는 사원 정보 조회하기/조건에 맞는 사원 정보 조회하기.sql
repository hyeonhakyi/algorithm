select sum(g.score) as SCORE,e.EMP_NO, e.EMP_NAME, e.POSITION,e.EMAIL
from HR_GRADE g join HR_EMPLOYEES e
on e.EMP_NO = g.EMP_NO
group by YEAR,EMP_NO
having g.YEAR = '2022'
order by 1 desc
limit 1;