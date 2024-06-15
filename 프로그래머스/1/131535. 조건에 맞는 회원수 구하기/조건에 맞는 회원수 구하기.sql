select count(*)
from user_info
where joined >= '20210101' and joined <= '20211231'
and age >= 20 and age <= 29