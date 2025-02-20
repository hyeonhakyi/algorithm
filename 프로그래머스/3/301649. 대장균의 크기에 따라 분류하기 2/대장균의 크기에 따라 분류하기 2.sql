select ID,
        case
            when d.r >= 0.75 then 'CRITICAL'
            when d.r >= 0.5 then 'HIGH'
            when d.r >= 0.25 then 'MEDIUM'
            else 'LOW'
        end as COLONY_NAME
from (
        select ID, PERCENT_RANK() over (order by SIZE_OF_COLONY) as r
        from ECOLI_DATA
) d
order by d.ID;