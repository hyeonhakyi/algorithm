select c.ID, c.GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as c
join ECOLI_DATA as p on c.PARENT_ID = p.ID
where p.GENOTYPE & c.GENOTYPE = p.GENOTYPE
order by ID