select p.PRODUCT_ID, p.PRODUCT_NAME, sum(o.AMOUNT * p.PRICE) as TOTAL_SALES
from FOOD_PRODUCT as p
join FOOD_ORDER as o on p.PRODUCT_ID = o.PRODUCT_ID
where date_format(PRODUCE_DATE,'%Y-%m-%d') like '2022-05%'
group by p.PRODUCT_ID
order by TOTAL_SALES desc,  p.PRODUCT_ID