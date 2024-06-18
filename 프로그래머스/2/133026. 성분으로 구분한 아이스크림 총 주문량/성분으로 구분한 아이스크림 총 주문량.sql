select i.INGREDIENT_TYPE, sum(h.total_order) TOTAL_ORDER
from first_half h
    join icecream_info i on h.flavor = i.flavor
group by 1
order by 2