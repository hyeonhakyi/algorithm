select
    d.DEPT_ID,
    d.DEPT_NAME_EN,
    round(avg(e.SAL),0) as AVG_SAL
from
    HR_DEPARTMENT as d
join
    HR_EMPLOYEES as e on d.DEPT_ID = e.DEPT_ID
group by
    d.DEPT_NAME_EN
order by    
    AVG_SAL desc 