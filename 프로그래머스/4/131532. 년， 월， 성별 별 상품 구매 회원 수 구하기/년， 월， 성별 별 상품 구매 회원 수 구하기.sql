SELECT year(o.SALES_DATE) as YEAR,
        month(o.SALES_DATE) as MONTH,
        u.GENDER as GENDER,
        count(distinct o.USER_ID) as USERS
from USER_INFO as u
join ONLINE_SALE as o
on u.USER_ID = o.USER_ID
group by YEAR,MONTH,GENDER
having GENDER is not null
order by YEAR,MONTH,GENDER;