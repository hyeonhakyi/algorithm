select count(*) as FISH_COUNT
from FISH_NAME_INFO n join FISH_INFO i
on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME in ('BASS','SNAPPER');