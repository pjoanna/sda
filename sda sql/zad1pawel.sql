use store2;
 -- zad 1.1
SELECT * 
FROM orders o JOIN customers c
ON o.customer_id=c.customer_id;
-- sposób 2
SELECT *
FROM customers INNER JOIN orders
ON customers.customer_id = orders.customer_id
ORDER BY customers.customer_id; -- posortowane
-- zad 1.2

SELECT c.customer_id,o.order_id, o.order_date
FROM orders o RIGHT JOIN customers c
ON o.customer_id=c.customer_id
ORDER BY c.customer_id;
-- sposób 2
SELECT c.customer_id, o.order_id, o.order_date
FROM customers c LEFT OUTER JOIN orders o
ON c.customer_id = o.customer_id
ORDER BY c.customer_id;

-- próbny sposób 3
SELECT c.customer_id, o.order_id, o.order_date
FROM orders o RIGHT OUTER JOIN customers c
ON c.customer_id = o.customer_id
ORDER BY c.customer_id;
-- próbny sposób 4
SELECT c.customer_id, o.order_id, o.order_date
FROM customers c LEFT JOIN orders o
ON c.customer_id = o.customer_id
ORDER BY c.customer_id;

-- zad 1.3
SELECT c.customer_id,o.order_id, o.order_date
FROM orders o LEFT JOIN customers c
ON o.customer_id=c.customer_id
ORDER BY o.order_id;
-- sposób 2
SELECT customers.customer_id, orders.order_id, orders.order_date
FROM customers RIGHT OUTER JOIN orders
ON customers.customer_id = orders.customer_id
ORDER BY orders.order_id;

 -- zad 1.4
(SELECT c.customer_id,o.order_id, o.order_date
FROM orders o LEFT JOIN customers c
ON o.customer_id=c.customer_id)
UNION ALL
(SELECT c.customer_id,o.order_id, o.order_date
FROM orders o RIGHT JOIN customers c
ON o.customer_id=c.customer_id);




