SELECT distinct a.CART_ID
from CART_PRODUCTS as a
inner join CART_PRODUCTS as b
on a.CART_ID = b.CART_ID
where a.name like 'Yogurt'
and b.name like 'Milk'
order by CART_ID;
