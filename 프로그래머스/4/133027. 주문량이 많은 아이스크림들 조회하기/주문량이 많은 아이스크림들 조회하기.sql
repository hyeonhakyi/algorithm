select
    h.FLAVOR
from
    FIRST_HALF as h
join
    JULY as j on h.FLAVOR = j.FLAVOR
group by
    h.FLAVOR
having
    sum(h.TOTAL_ORDER + j.TOTAL_ORDER)
order by
    sum(h.TOTAL_ORDER + j.TOTAL_ORDER) desc limit 3