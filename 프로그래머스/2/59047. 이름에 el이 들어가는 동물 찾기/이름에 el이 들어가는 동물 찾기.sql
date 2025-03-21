select ANIMAL_ID, NAME
from ANIMAL_INS 
where NAME like '%EL%'
and ANIMAL_TYPE like 'Dog'
order by NAME