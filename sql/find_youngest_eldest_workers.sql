select 'Youngest' as type, name, birthday from worker where birthday =  (select max(birthday)
from worker)
union
select 'Eldest' as type, name, birthday from worker where birthday =  (select min(birthday)
from worker);
