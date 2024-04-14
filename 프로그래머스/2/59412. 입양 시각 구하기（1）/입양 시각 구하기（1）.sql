select hour(DATETIME) as hour, count(*) as count
from ANIMAL_OUTS
group by hour
having hour between 9 and 20
order by hour;