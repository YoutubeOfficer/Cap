drop table emp;
create table emp(
id varchar2(16) primary key,
name varchar2(16) not null,
password number(10) not null);

insert into emp(id, name, password) values('id1','홍석천',1234);
insert into emp(id, name, password) values('id2','황석천',1235);
insert into emp(id, name, password) values('id3','대석천',1236);
