select
    year(o.SALES_DATE) as YEAR,
    month(o.SALES_DATE) as MONTH,
    i.GENDER,
    count(distinct i.USER_ID) as USERS
from
    USER_INFO as i
join
    ONLINE_SALE as o on i.USER_ID = o.USER_ID
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