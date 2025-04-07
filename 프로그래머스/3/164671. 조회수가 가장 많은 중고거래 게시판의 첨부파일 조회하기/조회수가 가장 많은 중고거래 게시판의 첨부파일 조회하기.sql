select concat('/home/grep/src/',f.BOARD_ID,'/',f.FILE_ID,f.FILE_NAME,f.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD as u
join USED_GOODS_FILE as f on u.BOARD_ID = f.BOARD_ID
where u.VIEWS in (select max(VIEWS)
                 from USED_GOODS_BOARD )
order by FILE_ID desc