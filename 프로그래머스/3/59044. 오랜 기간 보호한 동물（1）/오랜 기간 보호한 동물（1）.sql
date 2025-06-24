-- 코드를 입력하세요
SELECT 
    i.NAME, i.DATETIME
from
    ANIMAL_INS as i
where
    i.ANIMAL_ID not in (select ANIMAL_ID
                       from ANIMAL_OUTS)
order by i.DATETIME
limit 3