-- 코드를 입력하세요
SELECT distinct cc.CAR_ID
from CAR_RENTAL_COMPANY_CAR as cc
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as rh on cc.CAR_ID = rh.CAR_ID
where cc.CAR_TYPE like '세단'
and rh.START_DATE like '2022-10%'
order by CAR_ID desc