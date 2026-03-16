select
    j.FLAVOR
from
    FIRST_HALF as f
join
    JULY as j on f.FLAVOR = j.FLAVOR
group by
    j.FLAVOR
order by
    sum(j.TOTAL_ORDER + f.TOTAL_ORDER) desc limit 3