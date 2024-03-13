-- 코드를 입력하세요
SELECT DR_NAME,DR_ID,MCDP_CD,
    date_format(HIRE_YMD,'%Y-%m-%d') as "HIRE_YMD"
from DOCTOR
where mcdp_cd = 'cs'
or mcdp_cd = 'gs'
order by HIRE_YMD desc , dr_name;