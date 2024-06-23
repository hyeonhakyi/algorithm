select h.FLAVOR
from FIRST_HALF as h
join (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
     from JULY
     group by FLAVOR) as b
on h.FLAVOR = b.FLAVOR
order by (h.TOTAL_ORDER + b.TOTAL_ORDER) desc
limit 3;