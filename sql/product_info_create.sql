create table product (
    id int primary key,
    name varchar(100),
    qty int,
    categoryid int,
    price int
);

create table category (
    categoryid int primary key,
    categoryname varchar(100),
    description text,
    expirydates date
);

create table sales (
    salesid int primary key,
    productid int,
    qtysold int
);

create table review (
    productid int,
    currentrating decimal(2, 1),
    totalreviews int
);
