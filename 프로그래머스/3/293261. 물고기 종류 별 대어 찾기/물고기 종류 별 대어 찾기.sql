select fi.ID, fni.FISH_NAME as FISH_NAME, fi.LENGTH
from FISH_INFO as fi
join FISH_NAME_INFO as fni on fi.FISH_TYPE = fni.FISH_TYPE
where (fi.FISH_TYPE, fi.LENGTH) in (select FISH_TYPE, max(LENGTH)
                                    from FISH_INFO 
                                    group by FISH_TYPE)
order by fi.ID