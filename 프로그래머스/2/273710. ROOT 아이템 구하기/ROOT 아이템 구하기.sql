select i.item_id, i.item_name
from item_info i
    join item_tree t on i.item_id = t.item_id
where parent_item_id is null
order by 1