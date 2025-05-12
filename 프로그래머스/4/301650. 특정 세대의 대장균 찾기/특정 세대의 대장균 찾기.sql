-- 코드를 작성해주세요
select e3.ID
from ECOLI_DATA as e1
join ECOLI_DATA as e2 on e1.ID = e2.PARENT_ID
join ECOLI_DATA as e3 on e2.ID = e3.PARENT_ID
where e1.PARENT_ID is null
order by e3.ID