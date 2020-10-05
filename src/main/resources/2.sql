select pr.project_name, sum(dev.salary) as s from developers dev
join dev_projects dev_p on dev.dev_id = dev_p.dev_id
join projects pr on pr.project_id = dev_p.project_id
group by pr.project_name
order by s desc
limit 1;