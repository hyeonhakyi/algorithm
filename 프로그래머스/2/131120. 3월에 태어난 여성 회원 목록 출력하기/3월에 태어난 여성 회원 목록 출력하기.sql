select MEMBER_ID,MEMBER_NAME,GENDER,date_format(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE 
where month(DATE_OF_BIRTH) like 3
and TLNO is not null
and GENDER like 'W'
order by MEMBER_ID