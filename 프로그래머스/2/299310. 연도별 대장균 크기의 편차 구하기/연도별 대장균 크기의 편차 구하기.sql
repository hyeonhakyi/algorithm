select YEAR(DIFFERENTIATION_DATE) as YEAR,
        b.YEAR_MAX - a.SIZE_OF_COLONY as YEAR_DEV,
        ID
from ECOLI_DATA a 
inner join (select YEAR(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as YEAR_MAX
           from ECOLI_DATA
           group by YEAR) b
on year(a.DIFFERENTIATION_DATE) = b.year
order by YEAR,YEAR_DEV