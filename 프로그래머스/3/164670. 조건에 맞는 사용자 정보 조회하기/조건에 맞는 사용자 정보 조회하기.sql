SELECT u.USER_ID, u.NICKNAME,
concat(u.CITY,' ',u.STREET_ADDRESS1,' ',STREET_ADDRESS2) as 전체주소,
concat(left(TLNO,3),'-',mid(TLNO,4,4),'-',right(TLNO,4)) as 전화번호
from USED_GOODS_BOARD as b
join USED_GOODS_USER as u
on b.WRITER_ID = u.USER_ID
group by WRITER_ID
having count(WRITER_ID) >= 3
order by u.USER_ID desc;