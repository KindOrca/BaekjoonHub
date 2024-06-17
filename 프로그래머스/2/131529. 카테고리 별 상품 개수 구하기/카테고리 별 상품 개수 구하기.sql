select category, count(*)
from (
    select product_id, left(product_code,2) category
    from product
) tmp
group by category
order by 1