select
    distinct c.CAR_ID,
    c.CAR_TYPE,
    FLOOR(c.DAILY_FEE * 30 * (100 - p.DISCOUNT_RATE) / 100) as FEE
from
    CAR_RENTAL_COMPANY_CAR as c
join
    CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.CAR_ID = h.CAR_ID
join
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p on c.CAR_TYPE = p.CAR_TYPE
where
    c.CAR_TYPE in ('세단','SUV')
    and p.DURATION_TYPE like '30일 이상'
    and c.CAR_ID not in (select CAR_ID
                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    where START_DATE <= '2022-11-30'
                            AND END_DATE >= '2022-11-01')
having
    FEE >= 500000
    and FEE < 2000000
order by
    FEE DESC,
    c.CAR_TYPE ASC,
    c.CAR_ID DESC