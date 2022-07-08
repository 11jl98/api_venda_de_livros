create table book(
id varchar(36) primary key not null,
name varchar(150),
price decimal(10,2),
status varchar(50),
customer_id varchar(36) not null,
FOREIGN KEY (customer_id) REFERENCES customer(id)
)