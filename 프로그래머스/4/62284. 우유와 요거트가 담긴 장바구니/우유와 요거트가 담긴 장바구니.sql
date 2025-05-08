-- 코드를 입력하세요
SELECT distinct c1.CART_ID
from CART_PRODUCTS as c1
join CART_PRODUCTS as c2 on c1.CART_ID = c2.CART_ID
where c1.NAME like 'Milk'
and c2.NAME like 'Yogurt'
order by CART_ID