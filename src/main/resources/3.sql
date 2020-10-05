select s.skills_name, sum(salary) as Summary
from developers dev
         join dev_skills ds on dev.dev_id = ds.dev_id
         join skills s on ds.skills_id = s.skills_id
where s.skills_name = 'Java'
group by s.skills_name;