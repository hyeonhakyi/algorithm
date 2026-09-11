select
    year(s.SALES_DATE) as YEAR,
    month(s.SALES_DATE) as MONTH,
    i.GENDER,
    count(distinct i.USER_ID) as USERS
from
    USER_INFO as i
join
    ONLINE_SALE as s on i.USER_ID = s.USER_ID
where
    i.GENDER is not null
group by
    YEAR,
    MONTH,
    i.GENDER
order by
    YEAR,
    MONTH,
    i.GENDER