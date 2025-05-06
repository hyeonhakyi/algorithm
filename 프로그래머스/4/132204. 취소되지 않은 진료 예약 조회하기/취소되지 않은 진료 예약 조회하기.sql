-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINTMENT as a
join PATIENT as p on a.PT_NO = p.PT_NO
join DOCTOR as d on a.MDDR_ID = d.DR_ID
where a.APNT_YMD like '2022-04-13%'
and a.APNT_CNCL_YMD is null
and a.MCDP_CD like 'CS'
order by APNT_YMD