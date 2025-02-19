select f.ID
from ECOLI_DATA as f
join ECOLI_DATA as s on s.ID = f.PARENT_ID
join ECOLI_DATA as t on t.ID = s.PARENT_ID
where t.PARENT_ID is null
order by f.ID;