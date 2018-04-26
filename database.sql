create database if not exists company;
use company;
CREATE TABLE if not exists employee(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) default NULL,
   age INT  default NULL,
   PRIMARY KEY (id)
);
create table if not exists user
(	
id int not null auto_increment primary key,
name varchar(45),
address varchar(45),
username varchar(45),
password varchar(45),
admin bool);
create table if not exists medication
(
id int not null auto_increment primary key,
name varchar(45),
ingredients varchar(45),
manufacturer varchar(45),
quantity int,
price float);

insert into  medication
(id,name,ingredients,manufacturer,quantity,price) values
(1,'reuprofen','aaa','ddd',0,15.0),
(2,'algocalmin','bbb aaa','sss',0,11.2),
(3,'paracetamol','bbb, sdr','asd',30,15.3);

insert into  user
(id,name,address,username,password,admin) values
(1,'admin','Cluj','admin','admin',true),
(2,'Ana','Cluj','ana','ana',false),
(3,'User','Cluj','user','user',false);
select * from medication;