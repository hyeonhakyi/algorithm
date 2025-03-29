select concat(quarter(DIFFERENTIATION_DATE),'Q') as QUARTER, count(*) as ECOLI_COUNT
from ECOLI_DATA 
group by QUARTER
order by QUARTER