select
    a.APNT_NO,
    p.PT_NAME,
    a.PT_NO,
    a.MCDP_CD,
    d.DR_NAME,
    a.APNT_YMD
from
    APPOINTMENT as a
join
    DOCTOR as d on a.MDDR_ID = d.DR_ID
join
    PATIENT as p on a.PT_NO = p.PT_NO
where
    date_format(a.APNT_YMD,'%Y-%m-%d') like '2022-04-13'
    and a.MCDP_CD like 'CS'
    and a.APNT_CNCL_YN like 'N'
order by
    a.APNT_YMD