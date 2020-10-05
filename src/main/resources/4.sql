alter table "projects" add cost int;

UPDATE projects SET cost=65000 WHERE project_id = 1;
UPDATE projects SET cost=14000 WHERE project_id = 2;
UPDATE projects SET cost=11000 WHERE project_id = 3;
UPDATE projects SET cost=56000 WHERE project_id = 4;
UPDATE projects SET cost=10200 WHERE project_id = 5;