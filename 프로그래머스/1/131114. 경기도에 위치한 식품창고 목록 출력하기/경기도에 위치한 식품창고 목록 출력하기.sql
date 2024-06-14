select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N')
from food_warehouse
where address regexp '^.*경기도.*'
order by 1
