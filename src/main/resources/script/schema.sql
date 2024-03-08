drop table if exists project;
drop table if exists task;
drop table if exists milestone;
drop table if exists tag;
drop table if exists member;

create table project(
    project_id  int auto_increment,
    admin_id    int not null,
    name    varchar(100) not null,
    status      varchar(10) not null,
    primary key(project_id)
);

insert into project(admin_id,name,status) values(1,"프로젝트설계","종료");
insert into project(admin_id,name,status) values(1,"프로젝트진행","활성");

create table task(
    task_id int auto_increment,
    project_id  int not null,
    name   varchar(100) not null,
    detail  text,
    primary key (task_id)
);

-- create table milestone(
--        task_id int,
--        name varchar(100) not null,
--        start_date   date not null,
--        end_date date not null,
--        primary key(task_id)
-- );

create table tag(
    tag_id  int auto_increment,
    task_id int not null,
    name    varchar(100) not null,
    primary key (tag_id)
);

-- create table member(
--     member_id   int,
--     project_id  int
-- );