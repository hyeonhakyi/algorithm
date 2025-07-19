-- 코드를 입력하세요
SELECT
    year(s.SALES_DATE) as YEAR,
    month(s.SALES_DATE) as MONTH,
    i.GENDER as GENDER,
    count(distinct i.USER_ID) as USERS
from
    USER_INFO as i
join
    ONLINE_SALE as s on i.USER_ID = s.USER_ID
group by
    YEAR,
    MONTH,
    GENDER
having
    i.GENDER is not null
order by
    YEAR,
    MONTH,
    GENDER