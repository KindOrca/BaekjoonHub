select book_id, a.author_name, date_format(published_date, '%Y-%m-%d')
from book b
    join author a on b.author_id = a.author_id
where category = '경제'
order by 3