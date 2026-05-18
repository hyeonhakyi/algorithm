select
    p.PRODUCT_ID,
    p.PRODUCT_NAME,
    sum(p.PRICE * o.AMOUNT) as TOTAL_SALES
from
    FOOD_PRODUCT as p
join
    FOOD_ORDER as o on p.PRODUCT_ID = o.PRODUCT_ID
where
    date_format(o.PRODUCE_DATE,'%Y-%m-%d') like '2022-05%'
group by
    p.PRODUCT_ID,
    p.PRODUCT_NAME
order by
    TOTAL_SALES desc,
    p.PRODUCT_ID