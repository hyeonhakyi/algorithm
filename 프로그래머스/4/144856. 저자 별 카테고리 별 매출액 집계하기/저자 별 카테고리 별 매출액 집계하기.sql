-- 코드를 입력하세요
SELECT
    a.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    sum(s.SALES * b.PRICE) as TOTAL_SALES
from
    BOOK as b
join
    AUTHOR as a on b.AUTHOR_ID = a.AUTHOR_ID
join
    BOOK_SALES as s on b.BOOK_ID = s.BOOK_ID
where
    date_format(s.SALES_DATE,'%Y-%m-%d') like '2022-01-%'
group by
    a.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY
order by 
    a.AUTHOR_ID,
    b.CATEGORY desc