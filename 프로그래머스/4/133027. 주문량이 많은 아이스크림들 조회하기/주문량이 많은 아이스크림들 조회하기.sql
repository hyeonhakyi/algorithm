select
    j.FLAVOR as FLAVOR
from
    FIRST_HALF as h
join
    (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
        from JULY
        group by FLAVOR) as j on h.FLAVOR = j.FLAVOR
group by
    FLAVOR
order by
    sum(h.TOTAL_ORDER+ j.TOTAL_ORDER) desc limit 3