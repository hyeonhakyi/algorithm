SELECT year(s.SALES_DATE
) as YEAR,
MONTH(s.SALES_DATE
)as MONTH,
i.GENDER,
count(DISTINCT i.USER_ID) as USERS
from USER_INFO as i
join ONLINE_SALE as s
on i.USER_ID = s.USER_ID
group by YEAR,MONTH,GENDER
having GENDER is not null
order by YEAR,MONTH,GENDER;