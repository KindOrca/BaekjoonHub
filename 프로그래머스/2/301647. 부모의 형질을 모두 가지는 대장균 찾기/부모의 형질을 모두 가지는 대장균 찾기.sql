select a.ID, a.GENOTYPE, b.genotype PARENT_GENOTYPE
from ecoli_data a, ecoli_data b
where a.parent_id = b.id
and a.genotype & b.genotype = b.genotype
order by a.id