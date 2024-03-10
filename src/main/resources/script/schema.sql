drop table if exists member;
drop table if exists tag;
drop table if exists task;
drop table if exists project;
drop table if exists milestone;


create table project(
    project_id  BIGINT auto_increment,
    admin_id    varchar(100) not null,
    name    varchar(100) not null,
    status      varchar(10) not null,
    primary key(project_id)
);

insert into project(admin_id,name,status) values('jieun','A 프로젝트','종료');
insert into project(admin_id,name,status) values('jieun','B 프로젝트','활성');
insert into project(admin_id,name,status) values('sukjoon','C 프로젝트','활성');
insert into project(admin_id,name,status) values('sukjoon','D 프로젝트','휴면');

create table task(
    task_id BIGINT auto_increment,
    project_id  BIGINT not null,
    name   varchar(100) not null,
    detail  text,
    primary key (task_id)
);

insert into task(project_id,name,detail) values(1,'database 설계','ddl 작성 및 erd 다이어그램 정리');
insert into task(project_id,name,detail) values(1,'UI 설계',null);
insert into task(project_id,name,detail) values(1,'페이지 구성','메인 페이지 및 로그인 페이지 구성');

insert into task(project_id,name,detail) values(2,'database 설계','ddl 작성 및 erd 다이어그램 정리');
insert into task(project_id,name,detail) values(2,'UI 설계',null);
insert into task(project_id,name,detail) values(2,'페이지 구성','메인 페이지 및 로그인 페이지 구성');


create table milestone(
       task_id int,
       name varchar(100) not null,
       start_date   date not null,
       end_date date not null,
       primary key(task_id)
);

create table tag(
    tag_id  BIGINT auto_increment,
    task_id BIGINT not null,
    name    varchar(100) not null,
    primary key (tag_id)
);

create table member(
    id BIGINT auto_increment,
    project_id   BIGINT,
    member_id varchar(100),
    primary key (id)
);
insert into member (project_id,member_id) values(1,'sukjoon');
insert into member (project_id,member_id) values(1,'dongyeong');
insert into member (project_id,member_id) values(2,'dongyeong');
insert into member (project_id,member_id) values(2,'sukjoon');
insert into member (project_id,member_id) values(3,'dongyeong');
insert into member (project_id,member_id) values(3,'jieun');
insert into member (project_id,member_id) values(4,'dongyeong');
insert into member (project_id,member_id) values(4,'jieun');