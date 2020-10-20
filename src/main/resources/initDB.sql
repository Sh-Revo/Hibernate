create table  if not exists developer
(
    dev_id serial primary key,
    dev_name VARCHAR(35),
    dev_age int,
    dev_gender varchar(7)
);
alter table developer owner to postgres;



create table  if not exists skill
(
    skills_id serial primary key,
    skills_name varchar(35),
    skills_lvl varchar(15)
);
alter table skill owner to postgres;


create table if not exists project
(
    project_id serial primary key,
    project_name VARCHAR(35),
    project_description VARCHAR
);
alter table project owner to postgres;

create table if not exists companies
(
    company_id serial primary key,
    company_name VARCHAR(25),
    company_location VARCHAR(15)
);
alter table companies owner to postgres;

create table if not exists customer
(
    customer_id serial primary key,
    customer_name VARCHAR(15),
    customer_second_name VARCHAR(15)
);
alter table customer owner to postgres;

create table if not exists dev_skills
(
    dev_id int,
    skills_id int,
    PRIMARY KEY (dev_id, skills_id),
    FOREIGN KEY (dev_id) REFERENCES developer (dev_id),
    FOREIGN KEY (skills_id) REFERENCES skill (skills_id)

);
alter table dev_skills owner to postgres;


create table if not exists dev_projects
(
    dev_id int,
    project_id int,
    PRIMARY KEY (dev_id,project_id),
    FOREIGN KEY (dev_id) REFERENCES developer(dev_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id)
);
alter table dev_projects owner to postgres;

create table if not exists companies_project
(
    companies_id int,
    project_id int,
    PRIMARY KEY (companies_id,project_id),
    foreign key (companies_id) references companies(company_id),
    foreign key (project_id) references project(project_id)
);
alter table companies_project owner to postgres;

create table if not exists customer_projects
(
    customer_id int,
    project_id int,
    PRIMARY KEY (customer_id,project_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (project_id) references project(project_id)
);
alter table customer_projects owner to postgres;

alter table "developer" add salary int;

alter table "project" add cost int;