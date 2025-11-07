select
    distinct p1.CART_ID
from
    CART_PRODUCTS as p1
join
    CART_PRODUCTS as p2 on p1.CART_ID = p2.CART_ID
where
    p1.NAME like 'Milk'
    and p2.NAME like 'Yogurt'
order by
    CART_ID