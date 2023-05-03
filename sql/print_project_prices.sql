select pw.project_id, (sum(w.salary)*DATEDIFF('MONTH', p.start_date, p.finish_date)) as price
from worker w
left outer join project_worker pw
on w.id = pw.worker_id
left outer join project p
on pw.project_id = p.id
group by p.id
order by price desc;
