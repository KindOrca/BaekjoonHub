select count(*) FISH_COUNT, month(time) MONTH
from fish_info
group by 2
order by 2