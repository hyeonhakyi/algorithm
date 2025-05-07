-- 코드를 입력하세요
SELECT year(o.SALES_DATE) as YEAR, month(o.SALES_DATE) as MONTH,
u.GENDER,
count(distinct u.USER_ID) as USERS
from USER_INFO as u
join ONLINE_SALE as o on u.USER_ID = o.USER_ID
group by YEAR, MONTH, u.GENDER
having u.GENDER is not null
order by YEAR, MONTH, u.GENDER