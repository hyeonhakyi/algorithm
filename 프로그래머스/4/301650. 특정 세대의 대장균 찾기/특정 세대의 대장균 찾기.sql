select e1.ID
from ECOLI_DATA as e1
join ECOLI_DATA as e2 on e2.ID = e1.PARENT_ID
join ECOLI_DATA as e3 on e3.ID = e2.PARENT_ID
where e3.PARENT_ID is null
order by ID