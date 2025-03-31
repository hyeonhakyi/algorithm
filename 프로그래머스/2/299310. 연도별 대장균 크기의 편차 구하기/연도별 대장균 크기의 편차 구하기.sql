select year(DIFFERENTIATION_DATE) as YEAR, 
        (select max(SIZE_OF_COLONY) 
            from ECOLI_DATA
            where year(DIFFERENTIATION_DATE) = YEAR)- SIZE_OF_COLONY as YEAR_DEV,
ID
from ECOLI_DATA 
order by YEAR,YEAR_DEV