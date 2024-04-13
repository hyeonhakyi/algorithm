select count(ID) as COUNT
from ECOLI_DATA
where (GENOTYPE & 2) != 2
and ((GENOTYPE & 4) = 4
or (GENOTYPE & 1) = 1);