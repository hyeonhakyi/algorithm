select
    p.MEMBER_NAME,
    r.REVIEW_TEXT,
    date_format(r.REVIEW_DATE,'%Y-%m-%d') as REVIEW_DATE
from
    MEMBER_PROFILE as p
join
    REST_REVIEW as r on p.MEMBER_ID = r.MEMBER_ID
where
    p.MEMBER_ID like (select MEMBER_ID
                    from REST_REVIEW
                    group by MEMBER_ID
                    order by count(*) desc
                    limit 1)
order by 
    REVIEW_DATE,
    r.REVIEW_TEXT