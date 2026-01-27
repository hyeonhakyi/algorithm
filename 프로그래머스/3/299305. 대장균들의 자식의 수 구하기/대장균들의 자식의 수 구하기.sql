select
    e.ID,
    count(e1.PARENT_ID) as CHILD_COUNT
from
    ECOLI_DATA as e
left join
    ECOLI_DATA as e1 on e.ID = e1.PARENT_ID
group by
    e.ID
order by
    e.ID