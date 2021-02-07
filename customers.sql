drop table customers if exists;

create table customers (
    id int primary key auto_increment,
    name varchar(100) not null,
    city varchar(100) default 'Bangalore',
    email varchar(255),
    phone varchar(255)
);

insert into customers (name, email, phone) values 
('Vinod', 'vinod@vinod.co', '9731424784'),
('Shyam', 'shyam@example.com', '9988776655'),
('James', 'james@xmpl.com', '9998887776'),
('Rajesh', 'rajesh@example.com', '9876598765')
;
