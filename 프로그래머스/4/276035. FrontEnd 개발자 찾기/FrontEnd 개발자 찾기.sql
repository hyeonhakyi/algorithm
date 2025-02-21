select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS as d
join SKILLCODES as s on s.CODE = d.SKILL_CODE&s.CODE
where s.CATEGORY like 'Front End'
order by d.ID