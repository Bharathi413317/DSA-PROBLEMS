# Write your MySQL query statement 
select p.product_id,p.product_name
from product p
join sales s
on p.product_id=s.product_id 
GrOUP BY
P.PRODUCT_ID ,P.PRODUCT_NAME
HAVING 
MIN(S.SALE_DATE)>='2019-01-01' AND MAX(S.SALE_DATE)<='2019-03-31';

