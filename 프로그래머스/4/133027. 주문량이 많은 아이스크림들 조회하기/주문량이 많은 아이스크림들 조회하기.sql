-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF as f
join (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
        from JULY
        group by FLAVOR) as j on f.FLAVOR = j.FLAVOR
group by f.FLAVOR
order by (j.TOTAL_ORDER+f.TOTAL_ORDER) desc
limit 3