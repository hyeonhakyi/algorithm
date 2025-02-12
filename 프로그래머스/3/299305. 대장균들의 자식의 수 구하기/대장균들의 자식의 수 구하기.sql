select a.ID, count(b.id) as CHILD_COUNT
from ECOLI_DATA as a
left join ECOLI_DATA as b on a.ID = b.PARENT_ID
group by a.ID
order by a.ID 