-- Write your query below
select name from customers where id NOT in (select customer_id from orders);