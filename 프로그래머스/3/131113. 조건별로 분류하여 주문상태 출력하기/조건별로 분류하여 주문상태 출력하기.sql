SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, '%Y-%m-%d') as OUT_DATE,
        case
            when '2022-05-01' >= OUT_DATE then '출고완료'
            when '2022-05-01' < OUT_DATE then '출고대기'
        else '출고미정'
        end as 출고여부
from FOOD_ORDER
order by ORDER_ID asc;