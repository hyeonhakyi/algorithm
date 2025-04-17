select a.CART_ID
from CART_PRODUCTS as a
join CART_PRODUCTS as b on a.CART_ID = b.CART_ID
where a.NAME like 'Yogurt'
and b.NAME like 'Milk'
order by CART_ID 