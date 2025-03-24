select *
from FOOD_PRODUCT 
where PRICE in (select max(PRICE)
               from FOOD_PRODUCT)