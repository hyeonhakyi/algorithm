-- 코드를 작성해주세요
select 
    i.ID,
    n.FISH_NAME,
    max(i.LENGTH) as LENGTH
from
    FISH_INFO as i
join
    FISH_NAME_INFO as n on i.FISH_TYPE = n.FISH_TYPE
where
    (i.FISH_TYPE,i.LENGTH) in (select 
                            FISH_TYPE,
                            max(LENGTH)
                       from 
                            FISH_INFO 
                       group by 
                            FISH_TYPE)
group by 
    i.ID,
    n.FISH_NAME
order by 
    i.ID