--create sequence hibernate_sequence start with 1 increment by 1;
--create table user (id integer not null, birth_date timestamp, name_string varchar(255), primary key (id));

--INSERT INTO user VALUES(1,sysdate(),'Adam');
--INSERT INTO user VALUES(2,sysdate(),'Ben');
--INSERT INTO user VALUES(3,sysdate(),'Charlie');

select * from user;