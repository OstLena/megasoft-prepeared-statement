select C.name, P.client_id, project_count
from client C
         inner join (select count(id) as project_count, client_id
                     from project
                     group by client_id
                     having project_count = (select max(project_count)
                                             from (select count(id) as project_count, client_id
                                                   from project
                                                   group by client_id))) P
                    on P.client_id = C.id
group by P.client_id, C.name;