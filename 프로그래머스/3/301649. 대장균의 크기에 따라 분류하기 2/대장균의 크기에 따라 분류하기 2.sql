-- 코드를 작성해주세요
select a.ID,
    case
        when a.per <= 0.25 then 'CRITICAL'
        when a.per <= 0.5 then 'HIGH'
        when a.per <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from (select ID, percent_rank() over (order by SIZE_OF_COLONY desc) as per
     from ECOLI_DATA ) as a
order by a.ID