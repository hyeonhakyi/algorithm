-- 코드를 입력하세요
SELECT HISTORY_ID,CAR_ID,
    date_format(START_DATE, "%Y-%m-%d") as srart_date,
    date_format(END_DATE, "%Y-%m-%d") as end_date,
case when datediff(END_DATE,START_DATE) < 29 
    then '단기 대여'
    else '장기 대여'
    end "RENT_TYPE"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date like "2022-09-%"
order by HISTORY_ID desc;