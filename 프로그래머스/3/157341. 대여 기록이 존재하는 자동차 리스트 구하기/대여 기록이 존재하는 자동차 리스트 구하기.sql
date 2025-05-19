-- 코드를 입력하세요
SELECT distinct c.CAR_ID
from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.CAR_ID = h.CAR_ID
where c.CAR_TYPE like '세단'
and month(h.START_DATE) = 10
order by CAR_ID desc