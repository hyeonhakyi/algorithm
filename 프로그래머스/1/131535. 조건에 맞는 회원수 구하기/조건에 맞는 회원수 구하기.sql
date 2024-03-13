-- 코드를 입력하세요
SELECT count(USER_ID) as "USERS"
from USER_INFO
where year(joined) = '2021'
and age Between 20 and 29;