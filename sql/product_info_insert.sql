-- Inserting into category
insert into category (categoryid, categoryname, description, expirydates) values
(1, 'Electronics', 'Devices like phones, laptops, and accessories', null),
(2, 'Books', 'Various genres including fiction, non-fiction, and educational', null),
(3, 'Clothing', 'Men’s and women’s apparel and accessories', null),
(4, 'Groceries', 'Daily essentials and food items', '2025-04-20'),
(5, 'Frozen Foods', 'Frozen meals and ingredients', '2025-12-31');

-- Inserting into product
insert into product (id, name, qty, categoryid, price) values
(1, 'Smartphone', 50, 1, 24999),
(2, 'Laptop', 20, 1, 58999),
(3, 'Data Structures Book', 100, 2, 499),
(4, 'T-Shirt', 200, 3, 699),
(5, 'Basmati Rice (5kg)', 75, 4, 599),
(6, 'Frozen Pizza (Pack of 2)', 50, 5, 799);

-- Inserting into sales
insert into sales (salesid, productid, qtysold) values
(1, 1, 10),
(2, 2, 5),
(3, 3, 25),
(4, 4, 50),
(5, 6, 30);

-- Inserting into review
insert into review (productid, currentrating, totalreviews) values
(1, 4.5, 100),
(2, 4.0, 60),
(3, 4.7, 120),
(4, 3.8, 150),
(5, 4.2, 80);
