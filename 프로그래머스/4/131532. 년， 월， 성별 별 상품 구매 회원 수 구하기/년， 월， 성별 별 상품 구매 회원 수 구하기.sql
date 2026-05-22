select
    year(s.SALES_DATE) as YEAR,
    month(s.SALES_DATE) as MONTH,
    i.GENDER,
    count(distinct s.USER_ID) as USERS
from
    USER_INFO as i
join
    ONLINE_SALE as s on i.USER_ID = s.USER_ID
group by
    YEAR,
    MONTH,
    i.GENDER
having
    i.GENDER is not null
order by
    YEAR,
    MONTH,
    i.GENDER