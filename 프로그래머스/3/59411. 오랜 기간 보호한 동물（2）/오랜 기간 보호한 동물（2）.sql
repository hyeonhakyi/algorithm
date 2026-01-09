select
    i.ANIMAL_ID,
    i.NAME
from
    ANIMAL_INS as i
join
    ANIMAL_OUTS as o on i.ANIMAL_ID = o.ANIMAL_ID
order by
    datediff(i.DATETIME,o.DATETIME)
limit 
    2