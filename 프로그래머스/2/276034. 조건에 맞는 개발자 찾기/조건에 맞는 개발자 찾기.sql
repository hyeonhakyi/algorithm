select ID,EMAIL,FIRST_NAME,LAST_NAME
from DEVELOPERS 
where SKILL_CODE & (select CODE from SKILLCODES where name = 'Python')
or SKILL_CODE & (select CODE from SKILLCODES where name = 'C#')
order by ID;