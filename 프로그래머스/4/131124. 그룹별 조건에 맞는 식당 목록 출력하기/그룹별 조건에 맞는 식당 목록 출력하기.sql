select
    m.MEMBER_NAME,
    r.REVIEW_TEXT,
    r.REVIEW_DATE
from
    MEMBER_PROFILE as m
join
    REST_REVIEW as r on m.MEMBER_ID = r.MEMBER_ID
where
    r.MEMBER_ID like (select MEMBER_ID
                   from REST_REVIEW
                   group by MEMBER_ID
                   order by count(MEMBER_ID) desc limit 1)
order by
    r.REVIEW_DATE,
    r.REVIEW_TEXT