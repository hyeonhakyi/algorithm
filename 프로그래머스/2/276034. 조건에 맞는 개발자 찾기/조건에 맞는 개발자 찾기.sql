select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select CODE from SKILLCODES where NAME like 'Python')
or SKILL_CODE & (select CODE from SKILLCODES where NAME like 'C#')
order by ID