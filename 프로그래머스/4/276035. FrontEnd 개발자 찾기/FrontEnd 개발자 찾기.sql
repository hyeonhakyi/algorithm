select
    distinct d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
from
    SKILLCODES as s
join
    DEVELOPERS as d on (s.CODE & d.SKILL_CODE) = s.CODE
where
    s.CATEGORY like 'Front End'
order by
    ID