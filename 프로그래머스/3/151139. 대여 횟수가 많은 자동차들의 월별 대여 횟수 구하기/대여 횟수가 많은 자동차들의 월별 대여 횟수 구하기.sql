select
    month(START_DATE) as MONTH,
    CAR_ID,
    count(*) as RECORDS
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where
    date_format(START_DATE,'%Y-%m-%d') >= '2022-08-01'
    and date_format(START_DATE,'%Y-%m-%d') < '2022-11-01'
    and CAR_ID IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE >= '2022-08-01'
            AND START_DATE < '2022-11-01'
        GROUP BY
            CAR_ID
        HAVING
            COUNT(*) >= 5
    )
group by
    MONTH,
    CAR_ID
order by
    MONTH,
    CAR_ID desc