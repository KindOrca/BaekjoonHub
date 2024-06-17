select mcdp_cd '진료과 코드', count(*) '5월예약건수'
from appointment
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by 1
order by 2, 1