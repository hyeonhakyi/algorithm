SELECT b.AUTHOR_ID, a.AUTHOR_NAME,b.CATEGORY,sum(b.PRICE * bs.SALES) as TOTAL_SALES
from BOOK as b
join AUTHOR as a
on b.AUTHOR_ID = a.AUTHOR_ID
join BOOK_SALES as bs
on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE like '2022-01-%'
group by b.AUTHOR_ID,
a.AUTHOR_NAME,
b.CATEGORY
order by AUTHOR_ID,
CATEGORY desc;