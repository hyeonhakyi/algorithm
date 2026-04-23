with base as(
    select 
        id,
        percent_rank() over (order by SIZE_OF_COLONY desc ) as per
    from
        ECOLI_DATA
)

select
    id,
    case 
        when per <= 0.25 then 'CRITICAL'
        when per <= 0.5 then 'HIGH'
        when per <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from
    base
order by
    id