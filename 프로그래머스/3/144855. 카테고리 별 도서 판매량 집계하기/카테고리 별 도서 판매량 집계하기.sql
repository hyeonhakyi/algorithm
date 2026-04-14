select
    b.CATEGORY,
    sum(bs.SALES) as TOTAL_SALES
from
    BOOK as b
join
    BOOK_SALES as bs on b.BOOK_ID = bs.BOOK_ID
where
    date_format(bs.SALES_DATE, '%Y-%m-%d') like '2022-01%'
group by
    b.CATEGORY
order by    
    b.CATEGORY