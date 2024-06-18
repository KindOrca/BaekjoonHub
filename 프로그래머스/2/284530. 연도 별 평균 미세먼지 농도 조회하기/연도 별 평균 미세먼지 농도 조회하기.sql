select year(YM) YEAR, round(avg(pm_val1), 2) PM10, round(avg(pm_val2), 2) 'PM2.5'
from air_pollution
where location2 = '수원'
group by 1
order by 1