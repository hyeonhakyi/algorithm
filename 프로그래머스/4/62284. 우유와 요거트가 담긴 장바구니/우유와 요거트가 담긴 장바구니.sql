SELECT a.CART_ID
from CART_PRODUCTS as a
join CART_PRODUCTS as b
on a.CART_ID = b.CART_ID
where a.NAME like 'Milk'
and b.NAME like 'Yogurt'
order by CART_ID