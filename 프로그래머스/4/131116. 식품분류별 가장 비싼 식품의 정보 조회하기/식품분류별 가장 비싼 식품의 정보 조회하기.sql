select
    CATEGORY,
    PRICE,
    PRODUCT_NAME
from
    FOOD_PRODUCT 
where
    (CATEGORY,PRICE) in (select CATEGORY,
                                max(price)
                          from
                                FOOD_PRODUCT
                          where
                               CATEGORY in ('과자', '국', '김치', '식용유')
                          group by
                                CATEGORY)
group by
    CATEGORY
order by
    PRICE desc