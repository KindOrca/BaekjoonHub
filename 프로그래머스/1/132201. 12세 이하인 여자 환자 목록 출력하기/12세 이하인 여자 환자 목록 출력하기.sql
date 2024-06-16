select pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE')
from patient
where age <= 12 and gend_cd = 'W'
order by 4 desc, 1