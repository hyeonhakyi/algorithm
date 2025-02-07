select he.EMP_NO as EMP_NO, he.EMP_NAME as EMP_NAME, 
case
    when avg(SCORE) >= 96 then 'S'
    when avg(SCORE) >= 90 then 'A'
    when avg(SCORE)>= 80 then 'B'
else 'C'
end as GRADE,
case 
    when avg(SCORE) >= 96 then (he.SAL * 0.2)
    when avg(SCORE) >= 90 then (he.SAL * 0.15)
    when avg(SCORE) >= 80 then (he.SAL * 0.1)
else 0
end as BONUS

from HR_EMPLOYEES as he
join HR_GRADE as hg on he.EMP_NO = hg.EMP_NO
group by he.EMP_NO
order by he.EMP_NO;