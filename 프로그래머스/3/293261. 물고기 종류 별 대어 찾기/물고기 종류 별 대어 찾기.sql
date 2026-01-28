select
    fi.ID,
    fn.FISH_NAME,
    fi.LENGTH
from
    FISH_INFO as fi
join
    FISH_NAME_INFO as fn on fi.FISH_TYPE = fn.FISH_TYPE
where
    (fi.FISH_TYPE,fi.LENGTH) in (select FISH_TYPE,max(LENGTH)
                         from FISH_INFO 
                         group by
                            FISH_TYPE)
group by
    fi.ID,
    fn.FISH_NAME,
    fi.LENGTH
order by
    fi.ID