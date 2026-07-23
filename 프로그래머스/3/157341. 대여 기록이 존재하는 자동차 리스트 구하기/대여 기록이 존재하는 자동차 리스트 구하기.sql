select
    distinct cc.CAR_ID
from
    CAR_RENTAL_COMPANY_CAR as cc
join
    CAR_RENTAL_COMPANY_RENTAL_HISTORY as ch on cc.CAR_ID = ch.CAR_ID
where
    cc.CAR_TYPE like '세단'
    and date_format(ch.START_DATE,'%Y-%m-%d') like '2022-10%'
order by
    cc.CAR_ID desc