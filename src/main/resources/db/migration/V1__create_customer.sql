create table customer(
id varchar(36) primary key not null,
name varchar(150),
email varchar(150) unique
)