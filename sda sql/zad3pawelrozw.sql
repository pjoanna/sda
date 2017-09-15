use store4;

-- zad1
select sum(employees.salary) from employees;

-- zad2
UPDATE summary_data SET current_category = 
    (SELECT category_id FROM products 
    WHERE summary_data.product_id=products.product_id) 
WHERE EXISTS 
    (SELECT * FROM products,categories
   WHERE categories.category_id = products.category_id);
   
-- zad3