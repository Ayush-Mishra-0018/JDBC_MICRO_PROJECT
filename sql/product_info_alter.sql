alter table product
add constraint fk_product_category
foreign key (categoryid) references category(categoryid);

alter table sales
add constraint fk_sales_product
foreign key (productid) references product(id);

alter table review
add constraint fk_review_product
foreign key (productid) references product(id);
