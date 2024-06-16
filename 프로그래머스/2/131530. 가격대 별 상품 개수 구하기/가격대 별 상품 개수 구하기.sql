select price PRICE_GROUP, count(*) PRODUCTS
from (select truncate(price, -4) price from product) temp
group by PRICE_GROUP
order by 1