select count(*) FISH_COUNT, fn.FISH_NAME
from FISH_INFO as f
join FISH_NAME_INFO as fn on f.FISH_TYPE = fn.FISH_TYPE
group by fn.FISH_NAME
order by FISH_COUNT desc