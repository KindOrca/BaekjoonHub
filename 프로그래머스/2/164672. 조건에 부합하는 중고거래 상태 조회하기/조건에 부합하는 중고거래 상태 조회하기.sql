select board_id, writer_id, title, price,
    case when status = 'SALE' then '판매중'
    when status = 'RESERVED' then '예약중'
    else '거래완료' end as STATUS
from used_goods_board
where created_date = '20221005'
order by 1 desc