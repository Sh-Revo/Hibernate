select AVG(dev.salary),pr.project_name from developers dev
join dev_projects dp on dev.dev_id = dp.dev_id
join projects pr on dp.project_id = pr.project_id
where pr.cost = (select MIN(ps.cost)
                 from projects ps)
group by pr.project_name;