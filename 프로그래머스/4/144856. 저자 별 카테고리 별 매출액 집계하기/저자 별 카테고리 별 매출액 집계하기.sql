select
    distinct b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    sum(bs.SALES * b.PRICE) as TOTAL_SALES
from
    BOOK as b
join
    AUTHOR as a on b.AUTHOR_ID = a.AUTHOR_ID
join
    BOOK_SALES as bs on b.BOOK_ID = bs.BOOK_ID
where
    date_format(bs.SALES_DATE,'%Y-%m-%d') like '2022-01%'
group by
    b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY
order by
    b.AUTHOR_ID,
    b.CATEGORY desc 