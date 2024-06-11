SELECT distinct car.CAR_ID as CAR_ID
from CAR_RENTAL_COMPANY_CAR as car
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as history
on car.CAR_ID = history.CAR_ID
where car.CAR_TYPE like '세단'
and history.START_DATE like '2022-10-%'
order by CAR_ID desc;