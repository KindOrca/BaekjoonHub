select count(*) FISH_COUNT, FISH_NAME
from fish_info f
    join fish_name_info n on f.fish_type = n.fish_type
group by 2
order by 1 desc