select car_id, round(avg(datediff(end_date, start_date)+1), 1) AVERAGE_DURATION
from car_rental_company_rental_history
group by 1
having average_duration >= 7
order by 2 desc, 1 desc