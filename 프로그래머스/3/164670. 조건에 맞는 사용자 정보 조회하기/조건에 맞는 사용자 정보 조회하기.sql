select
    u.USER_ID,
    u.NICKNAME,
    concat(u.CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2) as 전체주소,
    concat(left(u.TLNO,3),"-",mid(u.TLNO,4,4),"-",right(u.TLNO,4)) as 전화번호
from
    USED_GOODS_BOARD as b
join
    USED_GOODS_USER as u on b.WRITER_ID = u.USER_ID
group by
    b.WRITER_ID
having
    count(b.WRITER_ID) >= 3
order by
    b.WRITER_ID desc 