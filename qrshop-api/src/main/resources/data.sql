INSERT INTO users (id, username, password, first_name, last_name) VALUES ('1111-1111-1111', 'admin', 'admin', 'Periklis', 'Astathopoulos');

INSERT INTO products (id, product_name, description, sort_description, price, discount) VALUES ('1111-1111-1111', 'Laptop', 'Lenovo laptop cpu 4 cores, 8gb ram, 1tb ssd', 'Lenovo laptop', 2000, 0);
INSERT INTO products (id, product_name, description, sort_description, price, discount) VALUES ('2222-2222-2222', 'Table', 'Lenovo tablet cpu 4 cores, 8gb ram', 'Lenovo tablet', 600, 0);
INSERT INTO products (id, product_name, description, sort_description, price, discount) VALUES ('3333-3333-3333', 'Phone', 'Lenovo phone cpu 4 cores, 8gb ram', 'Lenovo phone', 300, 0);

INSERT INTO customers (id, first_name, last_name, address_street, address_number, city, postal_code) VALUES ('1111-1111-1111', 'Stavros', 'Tsaxpinis', 'Trapezis', '2', 'Thessaloniki', '12312');

INSERT INTO orders (id, order_date, status, customer_id) VALUES ('1111-1111-1111', '2013-03-12', 'pending', '1111-1111-1111');
INSERT INTO orders (id, order_date, status, customer_id) VALUES ('2222-2222-2222', '2015-03-12', 'sent', '1111-1111-1111');
INSERT INTO orders (id, order_date, status, customer_id) VALUES ('3333-3333-3333', '2016-03-12', 'completed', '1111-1111-1111');

INSERT INTO orders_details (id, quantity, order_id, product_id) VALUES ('1111-1111-1111', 1, '1111-1111-1111', '1111-1111-1111');
INSERT INTO orders_details (id, quantity, order_id, product_id) VALUES ('2222-2222-2222', 1, '1111-1111-1111', '2222-2222-2222');
INSERT INTO orders_details (id, quantity, order_id, product_id) VALUES ('3333-3333-3333', 1, '1111-1111-1111', '3333-3333-3333');

