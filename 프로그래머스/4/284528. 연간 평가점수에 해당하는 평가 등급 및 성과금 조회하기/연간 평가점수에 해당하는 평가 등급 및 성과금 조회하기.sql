select he.EMP_NO, he.EMP_NAME,
    case 
        when avg(hg.SCORE) >= 96 then 'S'
        when avg(hg.SCORE) >= 90 then 'A'
        when avg(hg.SCORE) >= 80 then 'B'
        else 'C'
    end as GRADE,
    case 
        when avg(hg.SCORE) >= 96 then (he.SAL*0.2)
        when avg(hg.SCORE) >= 90 then (he.SAL*0.15)
        when avg(hg.SCORE) >= 80 then (he.SAL*0.10)
        else 0
    end as BONUS
from HR_EMPLOYEES as he
join HR_GRADE as hg on he.EMP_NO = hg.EMP_NO
group by he.EMP_NO
order by he.EMP_NO