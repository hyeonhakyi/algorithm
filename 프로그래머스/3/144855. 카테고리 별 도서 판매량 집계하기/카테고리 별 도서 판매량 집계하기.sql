-- 코드를 입력하세요
SELECT b.CATEGORY, sum(bs.SALES)
from BOOK as b
join BOOK_SALES as bs on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by CATEGORY