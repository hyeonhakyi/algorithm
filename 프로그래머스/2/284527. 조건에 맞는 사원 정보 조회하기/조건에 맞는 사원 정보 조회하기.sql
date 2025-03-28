select sum(hg.SCORE) as SCORE , he.EMP_NO, he.EMP_NAME, he.POSITION, he.EMAIL
from HR_EMPLOYEES  as he
join HR_DEPARTMENT as hd on he.DEPT_ID = hd.DEPT_ID
join HR_GRADE as hg on he.EMP_NO = hg.EMP_NO
group by YEAR,hg.EMP_NO
having hg.YEAR like '2022'
order by SCORE desc
limit 1 