select count(*) COUNT
from ecoli_data
where genotype % 8 in (1,4,5)